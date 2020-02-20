package com.code.leet;

public class L0198HouseRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length + 2];
        sum[0] = 0;
        sum[1] = 0;
        for (int i = 0; i < length; i++) {
            sum[i + 2] = sum[i + 1] > (sum[i] + nums[i]) ? sum[i + 1] : (sum[i] + nums[i]);
        }
        return sum[length + 1];
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5, 1, 2, 3, 4, 5};
        int rob = new L0198HouseRobber().rob(ints);
        System.out.println(rob);
    }
}
