package com.code.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 */
public class L0720LongestWordinDictionary {


    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl","world"};
        String s = new L0720LongestWordinDictionary().longestWord(words);
        System.out.println(s);
    }
    public String longestWord(String[] words) {
        Arrays.sort(words, new StrLenComparator());
        int max = 0;
        String r = "";
        HashSet<String> set = new HashSet<>();
        set.add(r);
        for (int i = 0; i < words.length; i++) {
            HashSet<String> setAdd = new HashSet<>();
            for (String str: set) {
                if (str.length() == words[i].length() - 1 && isSub(words[i], str)) {
                    setAdd.add(words[i]);
                    if (words[i].length() > max) {
                        r = words[i];
                        max = words[i].length();
                    }
                }
            }
            set.addAll(setAdd);
        }
        return r;
    }

    class StrLenComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 == len2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int p = 0;
                while (p < len1) {
                    if (chars1[p] != chars2[p]) {
                        return chars1[p] - chars2[p];
                    }
                    p++;
                }
            }
            return len1 - len2;
        }
    }

    boolean isSub(String str, String p) {
        int l = 0;
        int r = 0;
        while (l < str.length() && r < p.length()) {
            if (str.charAt(l) == p.charAt(r)) {
                r++;
            }
            l++;
        }
        return r == p.length();
    }

}
