package com.code.mthread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by hejiaxu on 2021/1/27
 */
public class CyclicBarrierThread {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        for (int i = 0; i < 4; i++) {
            String s = String.valueOf(i);
            new Thread(() -> {
                try {
                    System.out.println("thread-" + s + " arrive");
                    Thread.sleep(new Random().nextInt(100));
                    cyclicBarrier.await();
                    System.out.println("meeting start-" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }



    }
}
