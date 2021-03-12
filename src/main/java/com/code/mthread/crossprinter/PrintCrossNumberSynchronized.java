package com.code.mthread.crossprinter;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberSynchronized {


    static Integer count = 0;
    static int[] lock = new int[0];

    public static void main(String[] args) {

        new Thread(() -> {
            while (count < 100)
                synchronized (lock) {
                    try {
                        System.out.println("thread1-" + count++);
                        //唤醒等待share资源的线程，把锁交给线程（该同步锁执行完毕自动释放锁或遇到wait方法自动释放锁）
                        lock.notifyAll();
                        //释放CPU控制权，释放share的锁，本线程阻塞，等待被唤醒。
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();

        new Thread(() -> {
            while (count < 100)
                synchronized (lock) {
                    try {
                        System.out.println("thread2-" + count++);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();

    }


}
