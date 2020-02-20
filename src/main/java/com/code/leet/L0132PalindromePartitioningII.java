package com.code.leet;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class L0132PalindromePartitioningII {
    public static void main(String[] args) {
        String str = "abbac";
        int i = new L0132PalindromePartitioningII().minCut(str);
        System.out.println(i);
    }
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        boolean [][] p = new boolean[length][length];
        int[] result = new int[length + 1];
        result[0] = -1;
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i <= j + 1 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    min = min < result[j] + 1 ? min : result[j] + 1;
                }
            }
            result[i + 1] = min;
        }
        return result[length];
    }
}
