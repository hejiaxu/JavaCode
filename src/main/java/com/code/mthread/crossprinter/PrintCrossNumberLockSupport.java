package com.code.mthread.crossprinter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

import static com.code.mthread.crossprinter.PrintCrossNumberSynchronized.lock;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberLockSupport {

    static Integer count = 0;
    static Thread thread2 = null;
    static Thread thread1 = null;

    public static void main(String[] args) {
        thread1 = new Thread(() -> {
            while (count < 100) {

                System.out.println("thread1-" + count++);
                LockSupport.unpark(thread2);
                LockSupport.park();
            }
        });

        thread2 = new Thread(() -> {
            while (count < 100) {
                LockSupport.park();
                System.out.println("thread2-" + count++);
                LockSupport.unpark(thread1);
            }
        });


        thread2.start();
        thread1.start();


    }


}
