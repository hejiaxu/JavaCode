package com.code.leet;

public class L0213HouseRobberII {

    public int rob(int[] nums) {
        int max = 0;
        int length = nums.length;
        if (length == 0) {
            return max;
        }
        int[] sum = new int[length + 2];
        int[] excludeZero = new int[length + 2];
        sum[0] = 0;
        sum[1] = 0;
        for (int i = 0; i < length; i++) {
            sum[i + 2] = sum[i + 1] > (sum[i] + nums[i]) ? sum[i + 1] : (sum[i] + nums[i]);
        }
        for (int i = 1; i < length; i++) {
            excludeZero[i + 2] = excludeZero[i + 1] > (excludeZero[i] + nums[i]) ? excludeZero[i + 1] : (excludeZero[i] + nums[i]);
        }

        max = sum[length] > excludeZero[length + 1] ? sum[length] : excludeZero[length + 1];
        max = max > nums[0] ? max : nums[0];

        return max;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int rob = new L0213HouseRobberII().rob(ints);
        System.out.println(rob);

    }
}
