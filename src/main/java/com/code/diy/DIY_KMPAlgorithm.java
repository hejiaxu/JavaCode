package com.code.diy;

public class DIY_KMPAlgorithm {
    public static void main(String[] args) {
        String haystack = "abcabcacabcabcaebed", needle = "ababcaabc";
        int i = new DIY_KMPAlgorithm().kmpMatch(haystack, needle);
        System.out.println(i);


    }

    // abcabcacabcabcabd
    //  a b c a b c a b d
    //  0 1 2 3 4 5 6 7 8
    // -1 0 1
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
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        int i = 0, j = 0;
        //        String haystack = "abcabcacabcabcaebed", needle = "ababcaabc";
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

    // 1.计算匹配前缀(注意首位标记-1) 2.匹配，相同则继续(两个串都移动)，不同则根据匹配前缀计算跳转值(-1时则移动被匹配串)，根据匹配前缀数组，跳转到前一个匹配点。

}
