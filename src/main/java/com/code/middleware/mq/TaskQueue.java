package com.code.middleware.mq;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hejiaxu on 2021/1/21
 */
public class TaskQueue {
    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::get).start();
        new Thread(taskQueue::add).start();
        new Thread(taskQueue::add).start();
        new Thread(taskQueue::add).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (taskQueue.queue.size() > 0) {

            new Thread(taskQueue::get).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");

    }

    Queue<Integer> queue = new LinkedList<>();
    int capacity = 10;

    public void add() {
        for (int i = 0; i < 15; i++) {
            offer(i);
        }
    }
    public void get() {
        Integer poll = poll();
        System.out.println(poll);
    }
    public synchronized void offer(Integer i) {
        while (queue.size() >= capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(i);
        this.notifyAll();
    }

    public synchronized Integer poll() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poll = queue.poll();
        this.notifyAll();
        return poll;
    }
}
