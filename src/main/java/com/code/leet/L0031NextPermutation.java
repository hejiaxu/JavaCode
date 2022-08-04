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
// 1,2,3,4 → 1,2,4,3 -> 1,3,2,4 -> 1,3,4,2 -> 1,4,2,3 -> 2,1,3,4
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
            reverse(nums, 0, length - 1);
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
        reverse(nums, l, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }

    public static void main(String[] args) {
        // TODO
//        int[] nums = new int[]{3, 2, 1};
//        int[] nums = new int[]{1, 4, 2, 3};
        int[] nums = new int[]{1, 3, 2};
        new L0031NextPermutation().nextPermutation2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //19ms
    public void nextPermutation2(int[] nums) {
        int len = nums.length, i = len - 2;
        if (len < 2) {
            return;
        }
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i >= 0) {
            int j = i + 1;
            while (j < len && nums[j] > nums[i]) j++;
            swap(nums, i, j - 1);
        }
        reverse(nums, i + 1, len - 1);
    }
}
// 从后找第一个升序点，回找第一个大于升序点，两者交换，将升序点之后的全部倒置。