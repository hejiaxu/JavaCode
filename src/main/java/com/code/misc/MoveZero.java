package com.code.misc;

import com.code.utils.Printer;

/**
 * Created by hejiaxu on 2021/9/15
 * 题目描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 *
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 *
 * 尽量减少操作次数。时间复杂度O(n)，空间复杂度O(1)
 */
public class MoveZero {


    public static void main(String[] args) {
        // case 1
        int[] input = {0,1,0,3,12};
        int[] output = {1,3,12,0,0};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZero(input);
        Printer.printArrInt(input);
        System.out.println(moveZero.equals(input, output));
    }

    void moveZero(int[] arr) {
        int l = 0, r = 0;
        while (r < arr.length) {
            if (arr[r] != 0) {
                if (arr[l] == 0) {
                    swap(arr, l, r);
                }
                l++;
            }
            r++;
        }
    }

    boolean equals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
