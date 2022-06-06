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

    private static void testPC() {
        Queue<Integer> queue = new LinkedList<>();
        Integer SIZE = 10;

        new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == SIZE) {
                        try {
                            queue.wait();
                            System.out.println("producer-wait");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("producer-" + queue.size());
                    queue.offer(new Random().nextInt(100));
                    queue.notifyAll();
                }

            }
        }).start();


        new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        try {
                            queue.wait();
                            System.out.println("consumer-wait");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    System.out.println(poll);
                    System.out.println("consumer-" + queue.size());
                    queue.notifyAll();
                }

            }
        }).start();
    }

}
