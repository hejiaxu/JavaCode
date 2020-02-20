package com.code.leet;

public class L0557ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuilder(split[i]).reverse().toString();
        }
        return String.join(" ", split);
    }
}
