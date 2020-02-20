package com.code.leet;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

 */
public class L0028ImplementstrStr {
    public static void main(String[] args) {
        String haystack = "abacababc";
        String needle = "aabaab";
        int i = new L0028ImplementstrStr().strStr2(haystack, needle);
        System.out.println(i);
    }


    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        next[0] = -1;
        for (int i = 0; i < needle.length() - 1; i++) {
            int j = next[i];
            while (j != -1 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            next[i + 1] = j + 1;
        }
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }
    long R = 31L;
    long M = 10000000000000003L;
    long RK; // R^(pattern.length) % M
    // BM算法
    public int strStr2(String haystack, String needle) {

        if (haystack == null || needle == null || haystack.length() < needle.length())return -1;
        if(needle.length() == 0)return 0;

        long target = hash(needle, 0, needle.length() - 1);
        long hash = hash(haystack, 0, needle.length() - 1);

        RK = 1;
        for (int i = 0; i < needle.length(); i++) {
            RK = (RK * R) % M;
        }
        RK %= M;

        if (hash == target)
            return 0;
        for (int i = 1; i <= haystack.length() - needle.length(); i++) {
            long tmp = nextHash(hash, haystack.charAt(i - 1), haystack.charAt(i + needle.length() - 1));
            if (tmp == target)
                return i;
            hash = tmp;
        }
        return -1;
    }

    long hash(String s, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum * R % M + (long)(s.charAt(i)) % M;
        }
        return sum % M;
    }

    long nextHash(long hash, char oldFirst, char next) {
        long a = hash * R % M;
        long b = next % M;
        long c = oldFirst % M * RK % M;

        return (a + b - c + M) % M;
    }
}
