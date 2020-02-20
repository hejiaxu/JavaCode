package com.code.leet;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


 */
public class L0091DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            //0 can not be encoded to upper case
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            //0x can not be encoded to upper case
            if (i > 0 && s.charAt(i - 1) > 0 && ((s.charAt(i) <= '6' && s.charAt(i - 1) <= '2') || s.charAt(i - 1) <= '1')) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[length];
    }
    public static void main(String[] args) {
        int i = new L0091DecodeWays().numDecodings("10");
        System.out.println(i);
    }
}
