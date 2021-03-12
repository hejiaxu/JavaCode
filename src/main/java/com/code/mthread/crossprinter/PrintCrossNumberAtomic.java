package com.code.mthread.crossprinter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberAtomic {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        new Thread(() -> {
            while (count.get() < 100) {
                if (count.get() % 2 == 0) {
                    int andIncrement = count.getAndIncrement();
                    synchronized (PrintCrossNumberAtomic.class) {

                        System.out.println("thread1-" + andIncrement);
                    }
                }

            }
        }).start();

        new Thread(() -> {
            while (count.get() < 100) {
                if (count.get() % 2 == 1) {
                    int andIncrement = count.getAndIncrement();
                    synchronized (PrintCrossNumberAtomic.class) {
                        System.out.println("thread2-" + andIncrement);
                    }

                }
            }
        }).start();

    }


}
