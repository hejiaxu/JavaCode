/**
 *
 */
package com.code.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 */
public class L0076MinimumWindowSubstring {

    public static void main(String[] args) {
        // TODO
        Map<String, Integer> cache = new HashMap<>();
        cache.put("a", null);
        System.out.println(cache.isEmpty());
        cache.put(null, 1);
        System.out.println(cache.isEmpty());
        System.out.println(cache.get(null));
    }

    //27ms
    public String minWindow(String s, String t) {
        int hashT[] = new int[128];
        int hashS[] = new int[128];
        for (int i = 0; i < t.length(); i++) {
            hashT[t.charAt(i)]++;
        }
        int l = 0, r = 0, min = Integer.MAX_VALUE, minL = 0, minR = 0;
        while (r < s.length() || isOk(hashT, hashS)) {
            if (isOk(hashT, hashS)) {
                if (r - l < min) {
                    min = r - l;
                    minL = l;
                    minR = r;
                }
                hashS[s.charAt(l)]--;
                l++;
            } else {
                hashS[s.charAt(r)]++;
                r++;
            }
        }
        return s.substring(minL, minR);
    }

    public boolean isOk(int hashT[], int hashS[]) {
        for (int i = 0; i < hashT.length; i++) {
            if (hashT[i] != 0 && hashT[i] > hashS[i]) {
                return false;
            }
        }
        return true;
    }
}

// 记录窗口做l,右r,满足包含子串时l右移, 不满足时r右移。通过hash[128]记录当前的值和子串是否匹配。r-l匹配且小于最小值时更新最小值