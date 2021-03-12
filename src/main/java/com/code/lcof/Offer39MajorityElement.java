package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 * <p>
 *  
 * <p>
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 * <p>
 *  
 */
public class Offer39MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 3, 5, 3, 3};
        int strings = new Offer39MajorityElement().majorityElement2(nums);

        int i = -2147483647;
        long j = Integer.MAX_VALUE + 2l;
        System.out.println(i == j);
        int i1 = Integer.MAX_VALUE + 2;
        System.out.println(i1);
        System.out.println(i == i1);
        System.out.println(strings);
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int r = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count <= 0) {
                r = nums[i];
                count = 1;
            } else if (nums[i] == r) {
                count++;
            } else {
                count--;
            }
        }
        return r;
    }


    /**
     * 扩展如果是1/N + 1，则最多有N个数
     */
    public int majorityElement2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] r = new int[]{0, 0}, count = new int[]{0, 0};

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (; j < count.length; j++) {
                if (count[j] > 0) {
                    if (r[j] == nums[i]) {
                        count[j]++;
                        rollUp(r, count, j);
                    }
                } else {
                    r[j] = nums[i];
                    count[j] = 1;
                }
            }
            if (j == count.length) {
                for (int k = 0; k < count.length; k++) {
                    count[k]--;
                }
            }

        }
        return r[0];
    }

    private void rollUp(int[] r, int[] count, int j) {
        for (int i = j; i > 0; i--) {
            if (count[j] > count[j - 1]) {
                swap(r, j, j - 1);
                swap(count, j, j - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
