package com.code.mthread;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hejiaxu on 2019/12/31
 */
public class MultiJobsThreadJoin {

    /**
     * 题目：有100个任务，分为10组，每一组需要在前一组完成后开始执行
     */


    public static void main(String[] args) {
        MultiJobsThreadJoin multiJobs = new MultiJobsThreadJoin();
        int len = 10;
        JobGroup[] jobGroup = new JobGroup[len];
        for (int i = 0; i < len; i++) {
            jobGroup[i] = multiJobs.new JobGroup();
            jobGroup[i].init(i);
            jobGroup[i].exe(i > 0 ? jobGroup[i - 1] : null);
        }

    }

    public class Job extends Thread {
        int num;
        Job (int num) {
            this.num = num;
        }
        @Override
        public void run() {
            try {
                sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("job-" + num);
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public class JobGroup {
        Job[] jobs;

        public void init(int batch) {
            this.jobs = new Job[10];
            for(int i = 0; i < jobs.length; i++) {
                jobs[i] = new Job(batch);
            }
        }

        public void exe(JobGroup lastGroup) {
            if (lastGroup != null) {
                Arrays.stream(lastGroup.getJobs()).forEach(
                        job -> {
                            try {
                                job.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }

            Arrays.stream(jobs).forEach(Thread::start);
//            Executors.newScheduledThreadPool(3);
//            Executors.newCachedThreadPool().execute();
            // https://www.linuxidc.com/Linux/2016-03/128997.htm
            // join调用的是native方法，而线程池中会将传入的Job以runnable重新装成一个新的Thread对象，原来Job中的join已经失效。
//            Arrays.stream(jobs).forEach(job -> new Thread(job).start());
//            Arrays.stream(jobs).forEach(executor::execute);
        }

        public Job[] getJobs() {
            return jobs;
        }
    }

}
