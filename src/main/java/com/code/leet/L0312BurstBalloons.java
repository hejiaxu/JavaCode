package com.code.leet;

import java.util.Arrays;

/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.


Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10

 */
public class L0312BurstBalloons {
    public int maxCoins(int[] nums) {
        int[][] cache = new int[nums.length + 2][nums.length + 2];
        int[] balloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = balloons[nums.length + 1] = 1;
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(balloons, 0, balloons.length, cache);
    }

    private int dfs(int[] nums, int start, int end, int[][] cache) {
        if(cache[start][end - 1] >= 0) {
            return cache[start][end -1];
        }
        if (start >= end - 2) {
            return 0;
        }
        for (int i = start + 1; i < end - 1; i++) {
            int cal = nums[i] * nums[start] * nums[end - 1] + dfs(nums, start, i + 1, cache) + dfs(nums, i, end, cache);
            if (cal > cache[start][end - 1]) {
                cache[start][end - 1] = cal;
            }
        }
        return cache[start][end - 1];
    }


    public static void main(String[] args) {
//        int[] nums = new int[] {1, 3, 5};
        int[] nums = new int[] {3,1, 5,8};
        int i = new L0312BurstBalloons().maxCoins(nums);
        System.out.println(i);
        System.out.println(new L0312BurstBalloons().maxCoins2(nums));
    }

    public int[][] rec;
    public int[] val;

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
}
// 依次剔除掉打中的气球，深度遍历所有组合,通过二维数组缓存过程中的值,每个叶子节点即为这个节点打掉时的得分。