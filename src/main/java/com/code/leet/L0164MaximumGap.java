/**
 *
 */
package com.code.leet;

/**
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
 *
 * You must write an algorithm that runs in linear time and uses linear extra space.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: nums = [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 *
 */
public class L0164MaximumGap {
    public static void main(String[] args) {
        // TODO

    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int l = 0, r = 1, maxMinGap = 0;
        while (r < nums.length) {
            if (nums[r] < nums[l]) {
                maxMinGap = Math.max(nums[r - 1] - nums[l], maxMinGap);
                l = r;
            }
            r++;
        }
        maxMinGap = Math.max(nums[r - 1] - nums[l], maxMinGap);
        return maxMinGap;
    }
}

//1.基数排序：设置exp为基数区间，第一次缓存各落点数量，第二次循环根据落点位置和落点梳理计算真实落点。直到基础累积大于于最大值。
//2.桶排序