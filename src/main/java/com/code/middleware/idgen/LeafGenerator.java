package com.code.middleware.idgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hejiaxu on 2021/1/14
 * 优点：简单，应用中无需引入其他产品。采用批量号段生成，把生成的号段保存到内存中可以减少数据库的访问压力。
 * 缺点：DB单点故障，应用重启后缓存在内存中的号段丢失。生成的id不连续。 DB实现HA。对集群做高可用。
 */
public class LeafGenerator {
    /**
     * DROP TABLE IF EXISTS `leaf`;
     * CREATE TABLE `leaf` (
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     * `appname` varchar(255) DEFAULT NULL comments '应用名',
     * `max_id` bigint(20) DEFAULT NULL coments 'id最大值',
     * `step` int(11) DEFAULT NULL comments '步长',
     * PRIMARY KEY (`id`),
     * UNIQUE KEY `id_index` (`id`) USING BTREE
     * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
     * <p>
     * INSERT INTO `leaf` VALUES ('1', 'appid', '1001', '100');
     */

    //最大ID值
    AtomicLong maxId = new AtomicLong();

    //步长
    AtomicInteger step = new AtomicInteger();
    //当前值
    AtomicLong current = new AtomicLong(1);
    //开始值
    AtomicLong startId = new AtomicLong();

    //查询数据库获取对应appname当前的最大Id值
    public void genermaxID(String tag) {
        String sql = "select name, max_id ,step from leaf where name=?";

        String url = "jdbc:mysql://localhost:3306/users";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "");

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, tag);

            ResultSet rs = pstm.executeQuery();

            long max_id = 0;

            while (rs.next()) {

                max_id = rs.getLong("max_id");

                maxId.set(max_id);
                step.set(rs.getInt("step"));
            }

            startId.set(maxId.longValue() - step.longValue());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public long getNextId(String tag) {

        if (current.get() > maxId.get()) {

            getNextSegement(tag);
        }

        if (current.get() < startId.get()) {

            current.set(startId.get());
        }


        long temp = current.get();

        while (!current.compareAndSet(temp, temp + 1)) {
            temp = current.get();
        }

        return temp + 1;
    }

    //批量获取Id的最大值和最小值
    private synchronized void getNextSegement(String tag) {
        genermaxID(tag);

        update(tag);
        genermaxID(tag);

    }

    //更新数据库中的指定应用的最大ID值
    public void update(String tag) {
        String sql = "update leaf set max_id=max_id+step where name=?";

        String url = "jdbc:mysql://localhost:3306/users";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, tag);
            pstm.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}