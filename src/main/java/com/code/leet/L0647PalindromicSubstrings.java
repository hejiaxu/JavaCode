package com.code.leet;

public class L0647PalindromicSubstrings {


    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        int[][] record = new int[length][length];
        for (int interval = 0; interval < length; interval++) {
            for (int start = 0; start + interval < length; start++) {
                if (interval > 1 && record[start + 1][start + interval - 1] != 1) {
                    continue;
                }
                if (interval == 0 || s.charAt(start) == s.charAt(start + interval)) {
                    record[start][start + interval] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb";
        int i = new L0647PalindromicSubstrings().countSubstrings(s);
        System.out.println(i);

    }
}
