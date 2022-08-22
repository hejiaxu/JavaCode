package com.code.leet;

import java.util.Arrays;

/*
Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].
Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 

 */
public class L1005MaximizeSumOfArrayAfterKNegations {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 9, 9, 8, 4};
        int k = 5;
//        int[] nums = new int[]{-4, -3, -2};
//        int k = 4;
        int i = new L1005MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations2(nums, k);
        System.out.println(i);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                count += nums[i];
            } else if (nums[i] <= 0) {
                if (i == nums.length - 1 && i % 2 == k % 2) {
                    count += nums[i];
                } else {
                    count -= nums[i];
                }
            } else if (i == 0) {
                if (k % 2 == 0) {
                    count += nums[i];
                } else {
                    count -= nums[i];
                }
                // 0 ,1,2,3,4
            } else if (nums[i - 1] >= 0 || i % 2 == k % 2) {
                count += nums[i];
            } else if (nums[i] > -nums[i - 1]  && i != 1) {
                count += 2 * nums[i - 1];
                count += nums[i];
            } else {
                count -= nums[i];
            }
        }
        return count;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        int [] bucket = new int[201];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + 100]++;
        }
        int p = k, count = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] <= 0) {
                continue;
            }
            int value = i - 100;
            if (p <= 0) {
                count += bucket[i] * value;
            } else if (i >= 100) {
                if (p % 2 == 1) {
                    count -= value;
                    bucket[i]--;
                    p--;
                }
                count += bucket[i] * value;
            } else if (p > bucket[i]) {
                bucket[200 - i] += bucket[i];
                p -= bucket[i];
            } else {
                bucket[200 - i] += p;
                count += (bucket[i] - p) * value;
                p = 0;
            }
        }
        return count;
    }


}

// 1.数组排序。2.遍历 判断各种情况是加还是减，注意i>k，第一个正数的位置剩余的次数是否为偶数。最后一个负数和第一个正数需要PK。

// 桶排序，遍历更新
