/**
 *
 */
package com.code.leet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class L0003LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        // TODO
        int result = new L0003LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(result);

    }

    //46 ms
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] hash = new int[128];
        int tmpLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hash[ch] > 0) {
                if (tmpLen > maxLen) {
                    maxLen = tmpLen;
                }
                int pre = hash[ch];
                tmpLen -= pre;
                for (int j = 0; j < 128; j++) {
                    if (hash[j] > 0) {
                        hash[j] -= pre;
                    }
                }

            }

            hash[ch] = ++tmpLen;
        }

        return maxLen > tmpLen ? maxLen : tmpLen;
    }

}
// 用缓存或者数组记录当前段的字符，左右指针l,r，右边出现在缓存中时，则l右移，并删除缓存对应元素，直到出现重复值。每次操作都记录当前剩余的字符和最大字符数。
