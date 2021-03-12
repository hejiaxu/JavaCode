package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 */
public class Offer57TwoSum {

    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        int[] r = new Offer57TwoSum().twoSum(nums , 1);

        System.out.println(r[0]);
        System.out.println(r[1]);
    }


    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {

            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};

            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {};
    }

}
