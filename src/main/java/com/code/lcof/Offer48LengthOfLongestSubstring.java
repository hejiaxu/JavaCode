package com.code.lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hejiaxu on 2021/2/19
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class Offer48LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int s1 = new Offer48LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(s1);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                for (int j = i - len; j < i && chars[j] != chars[i]; j++) {
                    set.remove(chars[j]);
                    len--;
                }
            } else {
                set.add(chars[i]);
                len++;
                max = max < len ? len : max;
            }
        }
        return max;
    }
}
