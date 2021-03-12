package com.code.algr.memsort;

/**
 * Created by hejiaxu on 2021/1/8
 */
public class SelectSort {
    void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[pos]) {
                    pos = j;
                }
            }
            if (i != pos) {
                int tmp = array[i];
                array[i] = array[pos];
                array[pos] = tmp;
            }
        }
    }
}
