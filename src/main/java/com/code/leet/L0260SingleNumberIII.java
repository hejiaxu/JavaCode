package com.code.leet;

/*
Given an array of numbers nums,
in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant space complexity?
 */
public class L0260SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
    public int[] singleNumber(int[] nums) {
        int r1 = 0;
        int r2 = 0;
        int xor = 0;
        for (int j = 0; j < nums.length; j++) {
            xor ^= nums[j];
        }
        int lastOne = xor & -xor;

        for (int i = 0; i < nums.length; i++) {
            if ((lastOne & nums[i]) == 0) {
                r1 ^= nums[i];
            } else {
                r2 ^= nums[i];
            }
        }
        return new int[] {r1, r2};
    }
}
