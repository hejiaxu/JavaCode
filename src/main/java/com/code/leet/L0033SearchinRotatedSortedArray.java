package com.code.leet;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class L0033SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        int search = new L0033SearchinRotatedSortedArray().search(nums, target);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (r < 0) {
            return -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
