package com.code.diy;


public class DIY_MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 7, 3, 9};
        new DIY_MergeSort().mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
    void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        msort(nums, 0, nums.length - 1, tmp);
    }

    private void msort(int[] nums, int s, int e, int[] tmp) {
        if (s >= e) {
            return;
        }
        int m = (s + e) / 2;
        msort(nums, s, m, tmp);
        msort(nums, m + 1, e, tmp);
        merge(nums, s, m, e, tmp);
    }

    private void merge(int[] nums, int s, int m, int e, int[] tmp) {
        int l = s;
        int r = m + 1;
        int p = 0;
        while (l <= m || r <= e) {
            if (l <= m && r <= e) {
                tmp[p++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
            } else if (l > m) {
                tmp[p++] = nums[r++];
            } else {
                tmp[p++] = nums[l++];
            }
        }
        System.arraycopy(tmp, 0, nums, s, p);

    }
}
