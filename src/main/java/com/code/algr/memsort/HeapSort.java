package com.code.algr.memsort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by hejiaxu on 2021/1/8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 7, 3, 9};
        sort(nums);
        String join = String.join( ",", Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList()));
        System.out.println(join);
    }

    // max heap
    static void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            insertHeap(array, i);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(array, 0, i);
            reHeap(array, i);
        }


    }

    private static void reHeap(int[] array, int len) {
        int pos = 0;
        while (pos < len) {
            int left = 2 * pos + 1, right = 2 * pos + 2;
            if (right < len) {
                if (array[pos] >= array[left] && array[pos] >= array[right]) {
                    break;
                } else if (array[left] > array[right]) {
                    swap(array, pos, left);
                    pos = left;
                } else {
                    swap(array, pos, right);
                    pos = right;
                }
            } else if (left < len) {
                if (array[left] > array[pos]) {
                    swap(array, pos, left);
                    pos = left;
                } else {
                    break;
                }
            } else {
                break;
            }

        }
    }

    private static void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

    private static void insertHeap(int[] array, int pos) {
        while (pos > 0 && array[pos] > array[(pos - 1) / 2]) {
            swap(array, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

}
