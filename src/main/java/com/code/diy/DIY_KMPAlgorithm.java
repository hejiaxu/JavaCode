package com.code.diy;

public class DIY_KMPAlgorithm {
    public static void main(String[] args) {

    }
    int kmpMatch(String haystack, String needle) {
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
}
