package com.code.interview;

import java.util.HashMap;
import java.util.Map;

/*
Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string.

Example1:

 Input: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 Output: -1
 Explanation: Return -1 if s is not in words.
Example2:

 Input: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 Output: 4
Note:

1 <= words.length <= 1000000

 */
public class I1005SparseArraySearchLCCI {

    public int findString(String[] words, String s) {
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cache.put(words[i], i);
        }
        return cache.containsKey(s) ? cache.get(s) : -1;
    }
}
