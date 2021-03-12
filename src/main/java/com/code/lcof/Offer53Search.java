package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 *  
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 */
public class Offer53Search {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int r = new Offer53Search().search(nums, target);
        System.out.println(r);
    }

    public int search(int[] nums, int target) {
        return dfs(nums, 0, nums.length - 1, target);
    }

    private int dfs(int[] nums, int l, int r, int target) {
        if (l > r) {
            return 0;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            int count = 1;
            for (int i = mid + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = mid - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        } else if (nums[mid] > target) {
            return dfs(nums, l, mid -1, target);
        }
        return dfs(nums, mid + 1, r, target);
    }
}
