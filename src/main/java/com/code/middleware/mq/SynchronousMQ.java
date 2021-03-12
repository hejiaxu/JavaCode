package com.code.middleware.mq;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by hejiaxu on 2021/2/3
 */
public class SynchronousMQ {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();


        new Thread(() -> {
            while (true) {
                try {
                    Integer take = queue.take();
                    System.out.println("consume-" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    queue.put(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
