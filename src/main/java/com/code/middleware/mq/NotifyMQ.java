package com.code.middleware.mq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by hejiaxu on 2021/3/9
 */
public class NotifyMQ {
    public static void main(String[] args) {
        NotifyMQ notifyMQ = new NotifyMQ();

        notifyMQ.produce(1);
        notifyMQ.produce(2);
        notifyMQ.produce(3);
        new Thread(notifyMQ::produce).start();
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(notifyMQ::consume).start();

    }

    int count = 0;
    private void produce() {
        while (true) {
            if (queue.size() < size) {
                synchronized (queue) {
                    if (queue.size() >= size) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(count++);
                    queue.notifyAll();
                }
            } else {
                System.out.println("===producer===");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    int size = 10;
    final Queue<Integer> queue = new LinkedList<>();

    public void produce(Integer item) {
        queue.offer(item);

    }

    public void consume() {
        while (true) {
            if (!queue.isEmpty()) {
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(queue.poll());
                    queue.notifyAll();
                }
            } else {
                System.out.println("===consumer===");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
