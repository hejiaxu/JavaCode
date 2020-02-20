package com.code.leet;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of strings, you need to find the longest uncommon subsequence among them.
The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence
by deleting some characters without changing the order of the remaining elements. Trivially,
any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings,
and the output needs to be the length of the longest uncommon subsequence.
If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3
Note:

All the given strings' lengths will not exceed 10.
The length of the given list will be in the range of [2, 50].
 */
public class L0522LongestUncommonSubsequenceII {
    public static void main(String[] args) {
//        String[] strs = {"aabbcc", "aabbcc","bc","bcc","aabbccc"};
//        String[] strs = {"aaa", "aaa","aa"};
        String[] strs = {"a","b","c","d","e","f","a","b","c","d","e","f"};
        int luSlength = new L0522LongestUncommonSubsequenceII().findLUSlength(strs);
        System.out.println(luSlength);
    }
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new StringLenCom());
        for (int i = 0; i < strs.length - 1; i++) {
            if (!strs[i].equals(strs[i + 1])) {
                boolean existSub = false;
                if (i > 0) {
                    for (int j = 0; j < i; j++) {
                        if (isSub(strs[j], strs[i])) {
                            existSub = true;
                            break;
                        }
                    }
                }
                if (!existSub) {
                    return strs[i].length();
                }
                if (i == strs.length - 2) {
                    existSub = false;
                    if (i > 0) {
                        for (int j = 0; j < i + 1; j++) {
                            if (isSub(strs[j], strs[i + 1])) {
                                existSub = true;
                                break;
                            }
                        }
                    }
                    if (!existSub) {
                        return strs[i + 1].length();
                    }
                }
            }
        }
        return -1;
    }

    boolean isSub(String str, String sub) {
        int l = 0;
        int r = 0;
        while (l < str.length() && r < sub.length()) {
            if (str.charAt(l) == sub.charAt(r)) {
                l++;
                r++;
            } else {
                l++;
            }
        }
        return r == sub.length();
    }
    class StringLenCom implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int length2 = o2.length();
            int length1 = o1.length();
            if (length1 == length2) {
                int p = 0;
                while (p < length1) {
                    if (o1.charAt(p) != o2.charAt(p)) {
                        return o2.charAt(p) - o1.charAt(p);
                    }
                    p++;
                }
            }
            return length2 - length1;
        }

    }

}
