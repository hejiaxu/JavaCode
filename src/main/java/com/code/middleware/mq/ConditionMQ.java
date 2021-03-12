package com.code.middleware.mq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hejiaxu on 2021/3/9
 */
public class ConditionMQ {
    public static void main(String[] args) {

    }

    int size = 10;
    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    static Queue<Integer> queue = new LinkedList<>();

    public void produce(Integer item) {
        if (queue.size() < 10) {
            lock.lock();
            if (queue.size() < 10) {
                queue.offer(item);
            }
        }
    }

    public void consumer() {
        while (true) {
            lock.lock();
            if (size == 0) {

            }
        }
    }



}
