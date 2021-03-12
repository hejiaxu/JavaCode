package com.code.mthread.crossprinter;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberObjectNotify {


    public static int count = 0;
    public Integer lock = 0;


    public void printer() {
        while (count < 100) {
            synchronized (lock) {
                if (count < 100)
                System.out.println(Thread.currentThread().getName() + count++);
                try {
                    lock.notifyAll();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new PrintCrossNumberObjectNotify()::printer, "thread1-").start();
        new Thread(new PrintCrossNumberObjectNotify()::printer, "thread2-").start();
    }


}
