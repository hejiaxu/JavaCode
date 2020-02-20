package com.code.mthread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hejiaxu on 2019/12/31
 */
public class MultiJobsCountDownLatch {

    /**
     * 题目：有100个任务，分为10组，每一组需要在前一组完成后开始执行
     */
    public static void main(String[] args) {
        MultiJobsCountDownLatch multiJobs = new MultiJobsCountDownLatch();
        int len = 10;
        JobGroup[] jobGroup = new JobGroup[len];
        CountDownLatch lastLatch = null;
        for (int i = 0; i < len; i++) {
            CountDownLatch latch = new CountDownLatch(10);
            jobGroup[i] = multiJobs.new JobGroup(latch, i);
            jobGroup[i].exe(lastLatch);
            lastLatch = latch;
        }

    }

    public class Job extends Thread {
        CountDownLatch latch;
        int batch;
        Job (CountDownLatch latch, int batch) {
            this.latch = latch;
            this.batch = batch;
        }
        @Override
        public void run() {
            try {
                sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
            System.out.println("job-batch:" + + batch + "-count:" + latch.getCount());
        }
    }

    public class JobGroup {
        Job[] jobs;
        CountDownLatch latch;

        JobGroup(CountDownLatch latch, int batch) {
            this.latch = latch;
            this.jobs = new Job[10];
            for(int i = 0; i < jobs.length; i++) {
                jobs[i] = new Job(latch, batch);
            }
        }

        public void exe(CountDownLatch latch) {
            try {
                if (latch != null) {
                    latch.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Arrays.stream(jobs).forEach(Thread::start);
        }
    }

}
