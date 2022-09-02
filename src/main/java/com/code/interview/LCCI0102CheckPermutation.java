package com.code.interview;



/*
Given two strings,write a method to decide if one is a permutation of the other.

Example 1:

Input: s1 = "abc", s2 = "bca"
Output: true
Example 2:

Input: s1 = "abc", s2 = "bad"
Output: false
Note:

0 <= len(s1) <= 100
0 <= len(s2) <= 100

 */
public class LCCI0102CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        int[] bucket = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            bucket[s1.charAt(i)]++;
            bucket[s2.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (bucket[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
