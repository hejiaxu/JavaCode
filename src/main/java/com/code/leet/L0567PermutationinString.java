/**
 *
 */
package com.code.leet;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class L0567PermutationinString {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean b = new L0567PermutationinString().checkInclusion3(s1, s2);
        System.out.println(b);

    }

    //21ms
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int len1 = c1.length, len2 = c2.length;
        if (len1 > len2) {
            return false;
        }
        int[] tmp1 = new int[256];
        for (int i = 0; i < len1; i++) {
            tmp1[c1[i]]++;
            tmp1[c2[i] + 128]++;
        }
        for (int j = len1; j < len2; j++) {
            if (check(tmp1)) {
                return true;
            }
            tmp1[c2[j] + 128]++;
            tmp1[c2[j - len1] + 128]--;
        }
        return false;
    }

    private boolean check(int[] tmp1) {
        for (int i = 0; i < 128; i++) {
            if (tmp1[i] != tmp1[i + 128]) {
                return false;
            }
        }
        return true;
    }

    //21ms
    public boolean checkInclusion2(String s1, String s2) {
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for (int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while (--count[s2.charAt(l++)] != 0) { /* do nothing */}
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }


    //21ms
    public boolean checkInclusion3(String s1, String s2) {
        int[] count = new int[128];
        int target = s1.length();
        for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]++;
        for (int r = 0; r < s2.length(); r++) {
            if (r >= s1.length()) {
                if (++count[s2.charAt(r - s1.length())] > 0) {
                    target++;
                }
            }
            if (--count[s2.charAt(r)] >= 0) {
                target--;
            }
            if (target == 0) {
                return true;
            }
        }
        return false;
    }
}

// 缓存记录s1每个字符出现次数以及总字符数，遍历s2相同的就减，超过s1长度的加回。缓存字符数为0时则包含，遍历完则不包含。