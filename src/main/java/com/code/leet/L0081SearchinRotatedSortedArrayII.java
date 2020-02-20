package com.code.leet;

/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
 */
public class L0081SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int [] nums = {1,3,3,1,1};
        int target = 3;
        boolean search = new L0081SearchinRotatedSortedArrayII().search(nums, target);
        System.out.println(search);
    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (r < 0) {
            return false;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
            } else if (nums[l] < nums[mid]) {
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
        return false;
    }
}
