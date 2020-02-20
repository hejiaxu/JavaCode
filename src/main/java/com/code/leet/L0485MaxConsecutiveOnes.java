package com.code.leet;

/*
Given a binary array, find the maximum number of consecutive 1s in this array.

 */
public class L0485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = max > end - start ? max : end - start;
                start = i + 1;
            }
            end++;
        }
        return max > end - start ? max : end - start;
    }

}
