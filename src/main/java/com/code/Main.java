package com.code;

import com.code.leet.L0581ShortestUnsortedContinuousSubarray;

public class Main {

    public static void main(String[] args) {
        L0581ShortestUnsortedContinuousSubarray c = new L0581ShortestUnsortedContinuousSubarray();
        int[] a = {1, 3, 2, 2, 2};
        int unsortedSubarray = c.findUnsortedSubarray(a);
        System.out.println(unsortedSubarray);

        print(0 ^ 10);
    }

    static void print(Object a) {
        System.out.println(a);
    }

}
