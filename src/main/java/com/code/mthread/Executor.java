package com.code.mthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by hejiaxu on 2021/2/1
 */
public class Executor {

    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
    }
}
