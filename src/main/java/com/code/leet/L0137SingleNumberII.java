package com.code.leet;

/*
Given an array of integers,
every element appears three times except for one, which appears exactly once.
Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
 */
public class L0137SingleNumberII {
    public static void main(String[] args) {
//        System.out.println( -1 >> 31);
//        System.out.println( -1 >>> 31);
//        System.out.println( 1 << 31);
//        System.out.println( 1 <<< 31);
        int[] nums = {1, 1, 1, -3};
        int i = new L0137SingleNumberII().singleNumber2(nums);
        System.out.println(i);
    }
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int i = 31; i >= 0; i--) {
            int bitNum = 0;
            for (int j = 0; j < nums.length; j++) {
                bitNum += (nums[j] >>> i) & 1;
            }
            r = (r << 1) + bitNum % 3;
        }
        return r;
    }

    public int singleNumber2(int[] nums) {
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            two |= (one & nums[i]) ;
            one = one ^ nums[i];
            int tmp = one;
            one = one & ~two;
            two = two & ~tmp;
        }
        return one;
    }
}
