package com.code.leet;
/*
Given a non-empty array of integers, return the third maximum number in this array.
If it does not exist, return the maximum number. The time complexity must be in O(n).

 */
public class L0414ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        int length = nums.length;
        long[] max = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int i = 0; i < length; i++) {
            long num = nums[i];
            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num < max[0] && num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num < max[1] && num > max[2]) {
                max[2] = num;
            }
        }

        return (int) (max[2] > Long.MIN_VALUE ? max[2] : max[0]);
    }
}
