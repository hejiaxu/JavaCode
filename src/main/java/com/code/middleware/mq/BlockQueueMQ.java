package com.code.middleware.mq;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
Created by hejiaxu on 2020/1/3
 */
public class BlockQueueMQ {

    class Producer<T> {
        final BlockingQueue<T> queue;
        Producer(BlockingQueue<T> queue) {
            this.queue = queue;
        }
        void produce(T element) {
            try {
                queue.put(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer<T> implements Runnable {
        final BlockingQueue<T> queue;
         Consumer(BlockingQueue<T> queue) {
            this.queue = queue;
        }
        void consume() {
             while (true) {
                 try {
                     T element = queue.take();
                     System.out.println(element);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        }

        @Override
        public void run() {
            consume();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue();
//        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        Producer<Integer> producer = new BlockQueueMQ().new Producer(queue);
        Consumer<Integer> consumer = new BlockQueueMQ().new Consumer(queue);

        new Thread(consumer).start();
        for (int i = 0; i < 100; i++) {
            producer.produce(i);
        }
    }
}
