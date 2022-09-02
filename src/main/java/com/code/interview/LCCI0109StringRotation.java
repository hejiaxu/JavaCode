package com.code.interview;

import java.util.Objects;

/*
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat"). Can you use only one call to the method that checks if one word is a substring of another?

Example 1:

Input: s1 = "waterbottle", s2 = "erbottlewat"
Output: True
Example 2:

Input: s1 = "aa", s2 = "aba"
Output: False
 
 */
public class LCCI0109StringRotation {

    public boolean isFlipedString(String s1, String s2) {
        if (Objects.equals(s1,s2)) {
            return true;
        } else if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s1.charAt((j + i) % len) != s2.charAt(j)) {
                    break;
                } else if (j == len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public boolean isFlipedString3(String s1, String s2) {
        if (Objects.equals(s1,s2)) {
            return true;
        } else if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] next = new int[s2.length()];
        next[0] = -1;
        for (int i = 0; i < s2.length() - 1; i++) {
            int j = next[i];
            while (j != -1 && s2.charAt(i) != s2.charAt(j)) {
                j = next[j];
            }
            next[i + 1] = j + 1;
        }

        int j = 0;
        for (int i = 0; i < s1.length() + s2.length(); i++) {
            if (j == s2.length()) {
                return true;
            } else if (j == -1 || (i < s1.length() ? s1.charAt(i) == s2.charAt(j) : s2.charAt(i - s1.length()) == s2.charAt(j))) {
                j++;
            } else {
                j = next[j];
            }
        }
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
