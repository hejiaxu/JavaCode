/**
 *
 */
package com.code.leet;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *  
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *  
 *
 *
 */
public class L0290WordPattern {

    public static void main(String[] args) {
        // TODO
        L0290WordPattern l0290WordPattern = new L0290WordPattern();
    }

    //1 ms
    public static boolean wordPattern(String pattern, String str) {
        String[] tmp = new String[26];
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (tmp[pattern.charAt(i) - 'a'] == null) {
                /*
                 * 考虑如果不同必须和之前的都不一样
                 */
                for (int j = 0; j < 26; j++) {
                    if (tmp[j] != null && tmp[j].equals(split[i])) {
                        return false;
                    }
                }
                tmp[pattern.charAt(i) - 'a'] = split[i];
            } else {
                if (!tmp[pattern.charAt(i) - 'a'].equals(split[i])) {
                    return false;
                }
            }
        }

        return true;

    }

}

// 通过map或数组记录已经有的字母对应的单词，如果和之前不匹配则返回失败，遍历完则返回成功