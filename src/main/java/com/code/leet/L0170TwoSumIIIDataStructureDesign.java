package com.code.leet;

import java.util.HashMap;
import java.util.Map;

/*
question: design and implements a TwoSum class. it should support the following operations: add and find.

add: add the number to an internal data structure.

find: find if there exists any pair of numbers which sum is equal to the value.

 */
public class L0170TwoSumIIIDataStructureDesign {

    Map<Integer, Integer> cache = new HashMap<>();


    public void add(int input) {
        cache.put(input, cache.getOrDefault(input, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            int key = value - entry.getKey();

            if (key == entry.getKey() && entry.getValue() >= 2) {
                return true;
            }
            if (key != entry.getKey() && cache.containsKey(key)) {
                return true;
            }
        }
        return false;
    }
}
