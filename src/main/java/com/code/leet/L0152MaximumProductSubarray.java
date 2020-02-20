package com.code.leet;


/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class L0152MaximumProductSubarray {

    //reference
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere, minhere;

        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }

    public static void main(String[] args) {
        int[] nums = {803, -10, 3, -1, 1, 1, -2, -1, 1, -100000};
        int i = new L0152MaximumProductSubarray().maxProduct(nums);
        System.out.println(i);
    }
}
