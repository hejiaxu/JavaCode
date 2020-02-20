package com.code.diy;

public class DIY_SundayAlgorithm {
    public static void main(String[] args) {
        String haystack = "ccca";
        String needle = "cca";
        int i = new DIY_SundayAlgorithm().strstr(haystack, needle);
        System.out.println(i);
    }

    int strstr(String haystack, String needle) {
        int[] hash = new int[128];
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            hash[needle.charAt(i)] = i;
        }

        int i = 0;
        int jump = 0;
        int p = 0;

        while (i + m <= haystack.length()) {
            jump = 0;
            if (haystack.charAt(i + p) == needle.charAt(p)) {
                p++;
                if (p == needle.length()) {
                    return i;
                }
            } else {
                if (i + m >= haystack.length()) {
                    break;
                }
                jump = m - ((i + m) >= haystack.length() ? 0 : hash[haystack.charAt(i + m)]);
                p = 0;
            }
            i += jump;
        }

        return -1;
    }
}
