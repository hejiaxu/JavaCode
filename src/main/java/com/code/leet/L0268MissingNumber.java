package com.code.leet;


/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2
Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
 */
public class L0268MissingNumber {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums.length) {
                swap(nums, i, nums[i]);
            }
            if (nums[i] != i) {
                miss = i;
            }
        }
        return miss;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
