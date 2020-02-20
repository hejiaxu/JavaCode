package com.code.leet;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/tabs/description
Given an array of integers and an integer k, you need to find the total
 number of continuous subarrays whose sum equals to k.
 */
public class L0560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int num = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                num++;
            }
            if (map.containsKey(sum - k)) {
                num += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return num;
    }
}
