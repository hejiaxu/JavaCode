package com.code.diy;

/*

 */
public class DIY_QuickSort {
    public static void main(String[] args) {
        int[] nums = {100, 3, 5, 3, 4, 7, 13, 2, 5, 2, 19};
        new DIY_QuickSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    void sort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pos = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < nums[l]) {
                swap(nums, i, pos++);
            }
        }
        swap(nums, l, pos - 1);
        qSort(nums, l, pos - 2);
        qSort(nums, pos, r);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
