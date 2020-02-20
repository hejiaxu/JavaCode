package com.code.leet;

public class L0540SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r ^= nums[i];
        }
        return r;
    }
}
