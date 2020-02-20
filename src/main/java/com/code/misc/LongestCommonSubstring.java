package com.code.misc;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s = "abccedd";
        String t = "abccaedd";
        int lcs = new LongestCommonSubstring().longestCommonSubstring(s, t);
        System.out.println(lcs);
    }

    int longestCommonSubstring(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }
        return max;
    }
}
