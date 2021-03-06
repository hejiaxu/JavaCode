package com.code.leet;

import java.util.HashMap;

/*
Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size
at least 2 that sums up to the multiple of k,
that is, sums up to n*k where n is also an integer.
 */
public class L0523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer v = map.get(sum);
            if (v != null) {
                if (i - v > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
