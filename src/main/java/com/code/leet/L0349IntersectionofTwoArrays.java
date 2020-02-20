package com.code.leet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L0349IntersectionofTwoArrays {

    public static void main(String[] args) {
        int[] A = {12, 50, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 50};
        int[] intersection = new L0349IntersectionofTwoArrays().intersection(A, B);

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] r = new int[list.size()];

        int j = 0;
        for (int i: list) {
            r[j++] = i;
        }
        return r;
    }
}
