/**
 *
 */
package com.code.leet;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 */
public class L0016ThreeSumClosest {

    public static void main(String[] args) {
        // TODO
        int[] nums = new int[]{0, 2, 1, -3};
        int target = 1;
        int threeSumClosest = threeSumClosest(nums, target);
        System.out.println(threeSumClosest);
    }

    //32ms
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int sum = Integer.MAX_VALUE / 2;
        while (l < nums.length - 1) {
            int k = l + 1;
            int r = nums.length - 1;
            while (k < r) {
                if (nums[l] + nums[k] + nums[r] - target <= Math.abs(sum - target) && nums[l] + nums[k] + nums[r] - target >= -Math.abs(sum - target)) {
                    sum = nums[l] + nums[k] + nums[r];

                    //***
                    if (nums[l] + nums[k] + nums[r] - target > 0) {
                        r--;
                    } else {
                        k++;
                    }
                } else if (nums[l] + nums[k] + nums[r] - target > Math.abs(sum - target)) {
                    r--;
                } else {
                    k++;
                }
            }
            l++;

        }
        return sum;
    }

    //20ms
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, closest = 0;
        for (int k = 0; k < nums.length - 2; ++k) {
            for (int i = k + 1, j = nums.length - 1; i < j; ) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (sum - target < diff) {
                        diff = sum - target;
                        closest = sum;
                    }
                    --j;
                } else {
                    if (target - sum < diff) {
                        diff = target - sum;
                        closest = sum;
                    }
                    ++i;
                }
            }
        }
        return closest;
    }
}

// 先做排序，一层循环是否包括该数字，第二层通过左右指针，如果大于目标则右指针左移，如果小于目标值则左指针右移。同时判断差值是否小于最小值并更新。
