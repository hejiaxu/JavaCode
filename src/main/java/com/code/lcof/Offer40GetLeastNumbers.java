package com.code.lcof;

import java.util.Arrays;

/**
 * Created by hejiaxu on 2021/2/19
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 */
public class Offer40GetLeastNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 6, 7, 2, 0};
        int[] strings = new Offer40GetLeastNumbers().getLeastNumbers(nums, 7);
        System.out.println(strings);
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);

        return Arrays.copyOf(arr, k);
    }

    private void quicksort(int[] arr, int start, int end, int k) {
        if (start >= k || start >= end) {
            return;
        }

        int small = start + 1, large = start + 1;
        while (large <= end) {
            if (arr[large] <= arr[start]) {
                swap(arr, small, large);
                small++;
            }
            large++;

        }
        swap(arr, small - 1, start);
        quicksort(arr, start, small - 2, k);
        quicksort(arr, small, end, k);
    }

    private void quicksort2(int[] arr, int start, int end, int k) {
        if (start >= k || start >= end) {
            return;
        }

        int small = start + 1, large = end;
        while (small <= large) {
            if (arr[small] > arr[start] && arr[large] <= arr[small]) {
                swap(arr, small, large);
            }

            if (arr[small] <= arr[start]) {
                small++;
            }
            if (arr[large] > arr[start]) {
                large--;
            }
        }
        swap(arr, small - 1, start);
        quicksort2(arr, start, small - 2, k);
        quicksort2(arr, small, end, k);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

// 快速排序，左侧大于4时结束