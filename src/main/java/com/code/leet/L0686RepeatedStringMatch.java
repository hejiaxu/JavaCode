package com.code.leet;

/*
Given two strings A and B, find the minimum number of times A has to be repeated
such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it;
and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */
public class L0686RepeatedStringMatch {
    public static void main(String[] args) {
        String A = "abcdabc";
        String B = "abcdabcd";
        int i = new L0686RepeatedStringMatch().repeatedStringMatch3(A, B);
        System.out.println(i);

        System.out.println((double)1 /  2);
    }
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length() + A.length()) {
            count++;
            sb.append(A);
            if (sb.length() >= B.length()) {
                int index = sb.indexOf(B);
                if (index != -1) {
                    return count;
                }
            }
        }
        return -1;
    }

    public int repeatedStringMatch2(String A, String B) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length() + A.length()) {
            sb.append(A);
        }
        int index = sb.indexOf(B);
        if (index != -1) {

            return (int) Math.round((double) (index + B.length()) / A.length());
        }
        return -1;
    }

    public int repeatedStringMatch3(String A, String B) {
        StringBuilder builder = new StringBuilder(A);
        while (builder.length() < B.length())
            builder.append(A);

        int[] next = new int[B.length()];
        for (int i = 0, j = -1; i < B.length(); i++) {
            while (j != -1 && B.charAt(i) != B.charAt(j + 1)) {
                j = next[j];
            }
            next[i] = i > 0 && B.charAt(i) == B.charAt(j + 1) ? j + 1 : -1;
            j = next[i];
        }

        for (int i = 0; i < 2; i++) {
            if (kmpMatch(builder.toString(), B, next))
                return builder.length() / A.length();
            builder.append(A);
        }
        return -1;
    }

    private boolean kmpMatch(String s, String pattern, int[] next) {
        for (int i = 0, j = -1; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            if (j == pattern.length() - 1) {
                return true;
            }
        }
        return false;
    }
}

