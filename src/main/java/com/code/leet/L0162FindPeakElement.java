package com.code.leet;

/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */
public class L0162FindPeakElement {

    public static void main(String[] args) {
        L0162FindPeakElement m = new L0162FindPeakElement();
        int[] nums = new int[]{1, 2};
        int peakElement = m.findPeakElement(nums);
        System.out.println(peakElement);
    }

    // 此题有一定漏洞，1.全是相同值则没有峰值，2.如果中间段全都是相同的数，怎么能得到峰值。
    public int findPeakElement(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if ((mid == l || nums[mid] > nums[mid - 1]) && (mid == r || nums[mid] > nums[mid + 1])) {
            return mid;
        } else if (mid == l || nums[mid] <= nums[mid + 1]) {
            return dfs(nums, mid + 1, r);
        } else {
            return dfs(nums, l, mid - 1);
        }
    }
}
