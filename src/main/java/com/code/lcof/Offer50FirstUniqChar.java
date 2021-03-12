package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 *
 */
public class Offer50FirstUniqChar {

    public static void main(String[] args) {
        String s = "";
        int s1 = new Offer50FirstUniqChar().firstUniqChar(s);
        System.out.println(s1);
    }

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        char[] set = new char[256];
        for (int i = 0; i < chars.length; i++) {
            set[chars[i]]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (set[chars[i]] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
