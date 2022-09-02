package com.code.interview;

/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

Example 1:

Input: s = "leetcode"
Output: false
Example 2:

Input: s = "abc"
Output: true
 */
public class LCCI0101IsUnique {

    public boolean isUnique(String astr) {
        boolean[] bucket = new boolean[128];
        for (int i = 0; i < astr.length(); i++) {
            if (bucket[astr.charAt(i)]) {
                return false;
            } else {
                bucket[astr.charAt(i)] = true;
            }

        }
        return true;
    }
}
