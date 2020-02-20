package com.code.leet;


/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class L0494TargetSum {

    public static void main(String[] args) {
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        int s = 0;
        int targetSumWays = new L0494TargetSum().findTargetSumWays(nums, s);
        System.out.println(targetSumWays);
    }

    // sum(p) + sum(n) = sum(num)
    // sum(p) - sum(n) = S
    // sum(p) = (S + sum(num) ) / 2
    // subset problem
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum < S || (S + sum) % 2 == 1 ? 0 : subSet(nums, (S + sum) / 2);
    }

    private int subSet(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = s - nums[i]; j >= 0; j--) {
                dp[j + nums[i]] += dp[j];
            }
        }
        return dp[s];
    }

    public int findTargetSumWays2(int[] nums, int S) {
        return findWays(nums, 0, S);
    }

    private int findWays(int[] nums, int pos, int sum) {
        int count = 0;
        if (pos == nums.length - 1) {
            if (sum + nums[pos] == 0) {
                count++;
            }
            if (sum - nums[pos] == 0) {
                count++;
            }
        } else {
            count += findWays(nums, pos + 1, sum + nums[pos]);
            count += findWays(nums, pos + 1, sum - nums[pos]);
        }
        return count;
    }


}
