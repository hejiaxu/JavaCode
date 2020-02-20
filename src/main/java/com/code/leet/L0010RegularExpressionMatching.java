package com.code.leet;

/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
 */
public class L0010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] record = new boolean[s.length() + 1][p.length() + 1];
        record[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && record[0][i - 1]) {
                record[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    record[i + 1][j + 1] = record[i][j];
                } else if (p.charAt(j) == '*' ) {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        record[i + 1][j + 1] = record[i + 1][j - 1] || record[i][j + 1];
                    } else {
                        record[i + 1][j + 1] = record[i + 1][j - 1];
                    }
                }
            }
        }
        return record[s.length()][p.length()];
    }






    public static void main(String[] args) {
        boolean match = new L0010RegularExpressionMatching().isMatch("", "");
        System.out.println(match);
    }
}
