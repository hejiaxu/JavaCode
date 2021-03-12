package com.code.algr.memsort;

/**
 * Created by hejiaxu on 2021/1/8
 */
public class QuickSort {
    void sort(int[] array) {
        recursion(array, 0, array.length - 1);
    }

    private void recursion(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left + 1;
        int r = right;
        while (l < r) {
            if (array[l] < array[left]) {
                l++;
            } else if (array[r] > array[right]) {
                r--;
            } else {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }

            int tmp = array[left];
            array[left] = array[r];
            array[r] = tmp;
        }
        recursion(array, left, r - 1);
        recursion(array, r + 1, right);
    }

}
