package com.code.leet;


/*
Given a string and an integer k,
you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
public class L0541ReverseStringII {
    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        String s = new L0541ReverseStringII().reverseStr(str, k);
        System.out.println(s);
    }
    public String reverseStr(String s, int k) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()) {
            if (i + k > s.length()) {
                stringBuilder.append(new StringBuilder(s.substring(i, s.length())).reverse());
            } else if (i + 2* k > s.length() ){
                stringBuilder.append(new StringBuilder(s.substring(i, i + k)).reverse());
                stringBuilder.append(s.substring(i + k, s.length()));
            } else {
                stringBuilder.append(new StringBuilder(s.substring(i, i + k)).reverse());
                stringBuilder.append(s.substring(i + k, i + 2 * k));

            }
            i += 2 * k;
        }
        return stringBuilder.toString();
    }
}
