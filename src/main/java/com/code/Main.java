package com.code;

public class Main {

    public static void main(String[] args) {
//
        System.out.println(293666960 & 1 << 24);
        System.out.println(solution("011100"));

    }
    public static int solution(String S) {
        // write your code in Java SE 8
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if(count == 0) {
                    count++;
                } else {
                    count += 2;
                }
            } else {
                if(count > 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
