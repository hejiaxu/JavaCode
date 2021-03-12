package com.code.mthread.crossprinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberCondition {

    static Integer count = 0;
    static Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (count < 100) {
                lock.lock();
                if (count % 3 == 0) {
                    System.out.println("thread1-" + count++);
                } else {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition2.signal();

                lock.unlock();
            }


        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (count < 100) {
                lock.lock();
                if (count % 3 == 1) {
                    System.out.println("thread2-" + count++);
                } else {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition3.signal();

                lock.unlock();
            }

        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            while (count < 100) {
                lock.lock();
                if (count % 3 == 2) {
                    System.out.println("thread3-" + count++);
                } else {
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition1.signal();

                lock.unlock();
            }


        });
        thread3.start();


    }


}
