/**
 *
 */
package com.code.leet;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *  
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 */
public class L0209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        // TODO

    }

    //3ms
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length || sum >= target) {
            if (sum >= target) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i++];
            } else {
                sum += nums[j++];
            }
        }
        if (minLen == nums.length + 1) return 0;
        return minLen;
    }

}
// 1.像虫子一样往前爬，记录当前长度，长了去头，短了加尾，如果长于目标值则最短长度。
