package com.code.leet;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class L0031NextPermutation {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int l = length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            l--;
        }
        if (l < 0) {
            reverse(nums , 0, length - 1);
            return;
        }
        int r = length - 1;
        while (true) {
            if (nums[r] > nums[l]) {
                break;
            }
            r--;
        }
        swap(nums, l, r);
        reverse(nums , l, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        // TODO
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

}
