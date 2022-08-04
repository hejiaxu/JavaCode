/**
 *
 */
package com.code.leet;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 */
public class L0283MoveZeroes {

    public static void main(String[] args) {
        // TODO

    }

    //2ms
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                swap(nums, l++, r);
            }
            r++;
        }
    }

    void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    //1ms
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    //0ms
    public void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
// 左指针是找0，右指针找1，找到后交换。直到右指针到底
// 非0填充，遍历完之后补0
