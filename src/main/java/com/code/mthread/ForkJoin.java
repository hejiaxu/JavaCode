package com.code.mthread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by hejiaxu on 2021/2/1
 */
public class ForkJoin {
    public static void main(String[] args) throws Exception {
        // 创建2000个随机数组成的数组:
        long[] array = new long[2000];
        long expectedSum = 0;


        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
            // 故意放慢计算速度:
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Expected sum: " + expectedSum + " in " + (endTime - startTime) + " ms.");
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }

    static class SumTask extends RecursiveTask<Long> {
        static final int THRESHOLD = 5;
        long[] array;
        int start;
        int end;

        SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // 如果任务足够小,直接计算:
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += this.array[i];
                    // 故意放慢计算速度:
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
                return sum;
            }
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            //System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);
            invokeAll(subtask1, subtask2);
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            //System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
            return result;
        }
    }

}

