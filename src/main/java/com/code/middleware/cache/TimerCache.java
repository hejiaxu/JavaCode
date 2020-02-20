package com.code.middleware.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hejiaxu on 2020/1/3
 *
 * 参考:https://www.cnblogs.com/jobs/archive/2007/04/27/730255.html
 */
public class TimerCache<K, V> {

    // 内容存储
    private final ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();
    // 过期控制
    private final DelayQueue<KVItem> queue = new DelayQueue();
    // 清理线程
    private final Thread daemon = new DaemonThread("cache-daemon");
    // 可重入锁控制并发
    private final transient ReentrantLock lock = new ReentrantLock();

    public TimerCache() {
        daemon.start();
    }

    /**
     * 1.如何保证放入的唯一且和过期时间一致
     * 2.如果更新了内容过期时间怎么整
     */
    public void put(K key, V value, long expire) {
        KVItem item = new KVItem(key, value, expire + System.currentTimeMillis());
        lock.lock();
        map.put(key, value);
        queue.offer(item);
        lock.unlock();
    }

    public V get(K key) {
        return map.get(key);
    }


    class KVItem<K> implements Delayed {
        K key;
        V value;
        long expire;

        public KVItem(K key, V value, long expire) {
            this.key = key;
            this.value = value;
            this.expire = expire;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) {
                return 0;
            }
            if (o instanceof KVItem) {
                long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
                if (diff == 0) {
                    return 0;
                } else if (diff > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    class DaemonThread extends Thread {
        public DaemonThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                KVItem take = null;
                try {
                    take = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (take != null) {
                    boolean remove = map.remove(take.getKey(), take.getValue());
                    if (remove) {
                        System.out.println("daemon remove, key=" + take.getKey());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TimerCache<Integer, Integer> cache = new TimerCache<>();
        cache.put(1, 2, 1000);
        cache.put(1, 2, 1000);
        cache.put(3, 10, 10000);
        cache.put(4, 100, 10000);
        cache.put(10, 200, 30000);
        cache.put(10, 300, 30000);
        cache.put(10, 1000, 100);
        cache.put(20, 300, 30000);
    }
}
