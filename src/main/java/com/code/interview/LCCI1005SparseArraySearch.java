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
public class LCCI1005SparseArraySearch {

    public int findString(String[] words, String s) {
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cache.put(words[i], i);
        }
        return cache.getOrDefault(s, -1);
    }

    public int findString2(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (words[mid].equals("")) {
                if (words[r].equals(s)) {
                    return r;
                }
                r--;
            } else if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
