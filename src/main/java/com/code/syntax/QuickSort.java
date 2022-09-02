/**
 *
 */
package com.code.syntax;

/**
 * Jiaxu
 * Jun 5, 2017
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        // TODO
        int[] nums = {3, 2, 1, 5, 6, 4};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    static void sort(int nums[]) {
        qSort(nums, 0, nums.length - 1);
    }

    static void qSort(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }
        int left = end, right = end;

        while (left > start) {
            if (nums[left] > nums[start]) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right--;
            }
            left--;
        }
        int tmp = nums[right];
        nums[right] = nums[start];
        nums[start] = tmp;
        qSort(nums, start, right - 1);
        qSort(nums, right + 1, end);
    }


}
