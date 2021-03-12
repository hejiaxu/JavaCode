package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 */
public class Offer21Exchange {
    public static void main(String[] args) {
        int[] s = new int[] {1, 2, 3, 4};
        int[] r = new Offer21Exchange().exchange(s);
        System.out.println(r);
    }

    public int[] exchange(int[] nums) {
        int i = 1, j = 0;
        while (j < nums.length && i < nums.length) {
            if (i <= j) {
                i++;
            } else if (nums[i] % 2 == 0) {
                i++;
            } else if (nums[j] % 2 == 1) {
                j++;
            } else {
                swap(nums, i, j);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
