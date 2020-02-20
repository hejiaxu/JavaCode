package com.code.leet;

/*
Given an array of non-negative integers,
you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */

public class L0055JumpGame {

    public boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < 0) {
                return false;
            }
            if (nums[i] > end) {
                end = nums[i];
            }
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 0, 4};
        boolean b = new L0055JumpGame().canJump(nums);
        System.out.println(b);
    }
}
