package com.code.leet;

/*
Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
 */
public class L0044WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] record = new boolean[s.length() + 1][p.length() + 1];
        record[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                record[0][i + 1] |= record[0][i];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    record[i + 1][j + 1] = record[i][j];
                } else if (p.charAt(j) == '*') {
                    record[i + 1][j + 1] = record[i][j] || record[i][j + 1] || record[i + 1][j];
                }
            }
        }
        return record[s.length()][p.length()];
    }

    public static void main(String[] args) {
//        String s = "abefcdgiescdfimde";
//        String p = "ab*cd?i*de";
        String s = "aa";
        String p = "*";
        boolean match = new L0044WildcardMatching().isMatch(s, p);
        System.out.println(match);
    }
}
