package com.code.algr.memsort;

/**
 * Created by hejiaxu on 2021/1/8
 */
public class ShellSort {
    void sort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int j = 0; j < array.length - gap; j++) {
                if (array[j] > array[j + gap]) {
                    int tmp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = tmp;
                }
            }
        }
    }

}
