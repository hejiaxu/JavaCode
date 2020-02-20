package com.code.leet;

/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string
which is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class L0115DistinctSubsequences {
    public static void main(String[] args) {
        String s = "ccc";
        String t = "c";
        int i = new L0115DistinctSubsequences().numDistinct(s, t);
        System.out.println(i);
    }


    public int numDistinct2(String s, String t) {
        if (t != "") {
            int left = 0;
            while (left < s.length() && s.charAt(left) != t.charAt(0)) {
                left++;
            }
            int right = s.length();
            while (right > left && s.charAt(right - 1) != t.charAt(t.length() - 1)) {
                right--;
            }
            s = s.substring(left, right);
        }
        if (s.length() < t.length()) {
            return 0;
        }
        // array creation
        int[][] mem = new int[t.length()+1][s.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=s.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.
        for(int j=0; j<s.length(); j++) {
            for(int i=0; i<t.length(); i++) {
                if(t.charAt(i) == s.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }


    public int numDistinct(String s, String t) {
        // arr works as a hash table
        int[][] arr = new int[256][t.length()+1];
        int[] cnt = new int[t.length()+1];
        cnt[0] = 1;
        char c;
        for(int i = 0; i < t.length(); i++ ) {
            // arr[c] is a list of all the positions character c appears
            // arr[c][0] records how many times character c appears
            c = t.charAt(i);
            arr[c][arr[c][0]+1] = i+1;
            arr[c][0]++;
        }
        // DP
        for( char a: s.toCharArray() ) {
            if( arr[a][0] != 0 ) {
                for( int i = arr[a][0]; i > 0; i-- ) {
                    cnt[arr[a][i]] += cnt[arr[a][i]-1];
                }
            }
        }
        return cnt[t.length()];
    }

}
