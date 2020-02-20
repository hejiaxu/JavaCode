package com.code.leet;

import java.util.LinkedList;
import java.util.List;

public class L0448FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int[] tmp = new int[length];

        for (int i = 0; i < length; i++) {
            tmp[nums[i] - 1] = 1;
        }

        List<Integer> r = new LinkedList <>();
        for (int i = 0; i < length; i++) {
            if (tmp[i] != 1) {
                r.add(i + 1);
            }
        }

        return r;
    }
}
