package com.code.mthread.crossprinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class PrintCrossNumberReentrantLock {


    public static volatile int count = 0;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            while (count < 100) {
                lock.lock();
                if (count < 100)  {
                    if (count % 2 == 0) {

                        System.out.println("thread1-" + count++);
                    }
                }
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            while (count < 100) {
                lock.lock();
                if (count < 100)  {
                    if (count % 2 == 1) {
                        System.out.println("thread2-" + count++);
                    }
                }
                lock.unlock();
            }
        }).start();
    }
//    public static volatile int flag = 0; //volatile修饰变量保证对线程的可见性
//    private static final int N  = 50;
//    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock();//声明一个锁对象，
//        Condition c = lock.newCondition();//创建这个锁对应的一个条件变量
//
//        Thread r1 = new Thread( //线程A用来输出偶数
//                ()->{
//                    while(flag<=N){
//                        try{
//                            lock.lock();//首先获取锁
//                            if(flag%2==1){//如果当前值为奇数，就将线程阻塞挂起
//                                c.await();//将当前线程挂起
//                            }
//                            System.out.println(Thread.currentThread().getName()+"打印:"+flag);
//                            flag++;//自增1
//                            c.signal(); //唤醒其他因为这个条件而被被挂起的线程
//                        }catch(InterruptedException e){
//                            e.printStackTrace();
//                        }finally{
//                            //这里必须在finally代码块中来释放锁，防止应其他异常导致线程中断，但是锁					    //却没有释放，导致出现死锁
//                            lock.unlock();
//                        }
//                    }
//                }
//        );
//
//        Thread r2 = new Thread(//线程B用来输出奇数
//                ()->{
//                    while(flag<N){
//                        try{
//                            lock.lock();//首先获取锁
//                            if(flag%2==0){//如果当前值为偶数，就将线程阻塞挂起
//                                c.await();
//                            }
//                            System.out.println(Thread.currentThread().getName()+"打印:"+flag);
//                            flag++;//自增1
//                            c.signal();
//                        }catch(InterruptedException e){
//                            e.printStackTrace();
//                        }finally{
//                            lock.unlock();
//                        }
//                    }
//                }
//        );
//        r1.setName("线程A");
//        r2.setName("线程B");
//        r1.start();
//        r2.start();
//    }

}
