package com.code.diy;

public class DIY_IntegerParseInt {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
    }
    //case 1 :  > Integer.MAX_VALUE
    //case 2 :  < Integer.MIN_VALUE
    //case 3 :  negative
    //case 4 :  invalid surrounding character
    public int myAtoi(String s, int radix) {
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;

                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    return 0;
                }
                if (result < multmin) {
                    return 0;
                }
                result *= radix;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }
}
