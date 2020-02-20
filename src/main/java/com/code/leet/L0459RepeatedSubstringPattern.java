package com.code.leet;

/*

Given a non-empty string check if it can be constructed by taking a substring of it
and appending multiple copies of the substring together.
You may assume the given string consists of lowercase English letters only
and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class L0459RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abaababaab";
        boolean b = new L0459RepeatedSubstringPattern().repeatedSubstringPattern(s);
        System.out.println(b);
    }
    public boolean repeatedSubstringPattern(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int gap = 1; gap <= length / 2; gap++) {
            if (length % gap != 0) {
                continue;
            }
            boolean exist = true;
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < length; j += gap) {
                    if (charArray[i] != charArray[j]) {
                        exist = false;
                        break;
                    }
                }
            }
            if (exist) {
                return true;
            }
        }

        return false;
    }
}
