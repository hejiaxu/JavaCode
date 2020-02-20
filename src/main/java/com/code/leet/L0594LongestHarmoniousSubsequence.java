package com.code.leet;

import java.util.HashMap;
import java.util.Map;

public class L0594LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if ( map.containsKey(num) ) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if ( map.containsKey(key - 1) ) {
                Integer integer = map.get(key - 1);
                max = max > val + integer ? max : integer + val;
            } else if ( map.containsKey(key + 1) ) {
                Integer integer = map.get(key + 1);
                max = max > val + integer ? max : integer + val;
            }
        }
        return max;

    }
}
