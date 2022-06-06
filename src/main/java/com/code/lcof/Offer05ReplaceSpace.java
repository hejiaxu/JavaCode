package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05ReplaceSpace {
    public static void main(String[] args) {
        String s = " a a a";
        String r = new Offer05ReplaceSpace().replaceSpace1(s);
        System.out.println(r);
    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
// review
