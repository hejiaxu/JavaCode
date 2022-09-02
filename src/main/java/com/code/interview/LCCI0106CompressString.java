package com.code.interview;

/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

Example 1:

Input: "aabcccccaaa"
Output: "a2b1c5a3"
Example 2:

Input: "abbccd"
Output: "abbccd"
Explanation:
The compressed string is "a1b2c2d1", which is longer than the original string.

 */
public class LCCI0106CompressString {
    public String compressString(String S) {
        if (S == null || S.equals("")) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                sb.append(S.charAt(i));
            } else if (S.charAt(i) != S.charAt(i - 1)) {
                sb.append(count);
                sb.append(S.charAt(i));
                count = 1;
            } else {
                count++;
            }
            if (i == S.length() - 1) { // 漏掉了
                sb.append(count);
            }
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
