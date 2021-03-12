package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 */
public class Offer56SingleNumbers {
    // miss

    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        int[] r = new Offer56SingleNumbers().singleNumbers(nums);

        System.out.println(r[0]);
        System.out.println(r[1]);
    }


    /**
     * 1.获取异或的位
     * 2.将数字分成两批，包含异或位的和不包含的
     */
    public int[] singleNumbers(int[] nums) {
        if (nums.length <= 2) {
            return new int[]{0, 0};
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int lastOne = xor ^ (xor - 1);
//        int lastOne = 1;
//        while ((lastOne & xor) == 0) {
//            lastOne <<= 1;
//        }
        int a = 0, b = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lastOne) > 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[] {a, b};
    }

}
