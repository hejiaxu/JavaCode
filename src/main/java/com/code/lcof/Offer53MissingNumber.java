package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 */
public class Offer53MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0};
        int target = 8;
        int r = new Offer53MissingNumber().missingNumber(nums);
        System.out.println(r);
    }


    public int missingNumber(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return nums.length;
        }

        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < nums[l]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j - 1, l);
        if (nums[j - 1] == j - 1) {
            return dfs(nums, j, r);
        }
        if (j <= 2 || nums[j - 2] == j - 2) {
            return j - 1;
        }

        return dfs(nums, l, j);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
