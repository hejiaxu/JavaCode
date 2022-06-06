package com.code.lcof;

import java.util.Arrays;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意0.
 * ：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 *
 */
public class Offer42MaxSubArray {


    public int maxSubArray(int[] nums) {
        int[] r = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            if (r[i] < r[i - 1] + nums[i]) {
                r[i] = r[i - 1] + nums[i];
            }
        }
        int t = r[0];
        for (int i = 1; i < nums.length; i++) {
            if (r[i] > t) {
                t = r[i];
            }
        }
        return t;
    }

    // f(n) = max( nums(n), nums(n) + f(n-1) )
    // return max( f(1)... f(n) )
    public int maxSubArray2(int[] nums) {
        int f = nums[0], res = nums[0];
        for (int i = 1, n = nums.length; i < n; ++i) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }
}

// 动态规划，r[n]为包含第n个节点的最大值，遍历r数组得到结果