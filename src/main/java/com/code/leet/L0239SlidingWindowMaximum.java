package com.code.leet;

import com.code.lcof.Offer59MaxSlidingWindow;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
Offer59MaxSlidingWindow
 */
public class L0239SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] r = new L0239SlidingWindowMaximum().maxSlidingWindow3(nums, 3);

        System.out.println(r[0]);
        System.out.println(r[1]);
        System.out.println(r[2]);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (i - queue.peek()[1] >= k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                r[i + 1 - k] = queue.peek()[0];
            }

        }
        return r;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];
        Deque<int[]> queue = new LinkedList<>();


        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekLast()[0] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(new int[] {nums[i], i});
            while (!queue.isEmpty() && queue.peekFirst()[1] < i - k + 1) {
                queue.pollFirst();
            }
            if (i - k + 1 >= 0) {
                r[i - k + 1] = queue.peekFirst()[0];
            }
        }
        return r;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i % k == 0 || i == nums.length - 1) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }

        for (int i = 0; i < r.length; i++) {
            r[i] = Math.max(left[i + k - 1], right[i]);
        }

        return r;
    }

}

// 1.使用大顶堆，每次滑动，添加第n个元素，剔除掉位置为n-k的元素(剔除顶元素直到顶的位置大于n-k)
// 2.使用双端队列，元素从左进入前去掉小于它的元素，从右端获取当前最大值时去掉下标小于i-k + 1的元素
// 3.使用稀疏表，计算每个区间左前缀和右前缀的最大值，当前区间最大值为左前缀和右前缀的最大值。
