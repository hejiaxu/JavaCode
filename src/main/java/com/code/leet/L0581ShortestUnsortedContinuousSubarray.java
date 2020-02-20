package com.code.leet;

public class L0581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int start = -1;
        int end = -2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max = nums[i] > max ? nums[i] : max;
            if (nums[i] < max) {
                end = i;
            }
            min = nums[length - 1 - i] < min ? nums[length - 1 - i] : min;
            if (nums[length - 1 - i] > min) {
                start = length - 1 - i;
            }
        }

        return end - start + 1;
    }
}
