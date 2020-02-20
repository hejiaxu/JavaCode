package com.code.leet;


/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

 */
public class L0628MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int subMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int subMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                thirdMax = subMax;
                subMax = max;
                max = nums[i];
            } else if (nums[i] >= subMax) {
                thirdMax = subMax;
                subMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
            if (nums[i] <= min) {
                subMin = min;
                min = nums[i];
            } else if (nums[i] < subMin) {
                subMin = nums[i];
            }
        }
        return max * subMax * thirdMax > max * min * subMin ? max * subMax * thirdMax : max * min * subMin;
    }
}
