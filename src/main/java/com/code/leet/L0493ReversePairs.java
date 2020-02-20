package com.code.leet;


/*
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.

 */

public class L0493ReversePairs {

    public int reversePairs(int[] nums) {
        int count = mergsort(nums, 0, nums.length - 1);
        return count;
    }

    private int mergsort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int count = mergsort(nums, start, mid) + mergsort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            int num = j - (mid + 1);
            count += num;
        }
        mysort(nums, start, mid, end); //86ms
//        Arrays.sort(nums, start, end + 1); // 153ms
        return count;

    }

    private void mysort(int[] nums, int start, int mid, int end) {
        int len = end - start + 1;
        int[] copy = new int[len];
        int r = mid + 1;
        int p = 0;
        int s = start;
        while(s <= mid && r <= end) {
            if (nums[s] < nums[r]) {
                copy[p++] = nums[s++];
            } else {
                copy[p++] = nums[r++];
            }
        }
        while(s <= mid) {
            copy[p++] = nums[s++];
        }
        while(r <= end) {
            copy[p++] = nums[r++];
        }
        System.arraycopy(copy, 0, nums, start, len);
    }

    public static void main(String[] args) {
        int[] ints = {1,3,2,3,1};
//        int[] ints = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int i = new L0493ReversePairs().reversePairs(ints);
        System.out.println(i);

    }
}
