package com.code.misc;

public class LongestCommonSequence {

    public static void main(String[] args) {
        String s = "abcce";
        String t = "ace";
        int lcs = new LongestCommonSequence().lcs(s, t);
        System.out.println(lcs);
    }
    int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 1 : 0), dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }
}
