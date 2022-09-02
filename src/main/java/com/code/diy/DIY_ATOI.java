package com.code.diy;

public class DIY_ATOI {

    //case 1 :  > Integer.MAX_VALUE
    //case 2 :  < Integer.MIN_VALUE
    //case 3 :  negative
    //case 4 :  invalid surrounding character
    public int myAtoi(String str) {
        long longResult = 0;
        int neg = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '-' || chars[i] == '+')) {
                if (chars[i] == '-') {
                    neg = -1;
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                longResult = longResult * 10 + str.charAt(i) - '0';
            } else {
                longResult = 0;
                break;
            }
        }
        longResult *= neg;
        int intResult = (int) longResult;
        if (longResult > Integer.MAX_VALUE) {
            intResult = Integer.MAX_VALUE;
        } else if (longResult < Integer.MIN_VALUE) {
            intResult = Integer.MIN_VALUE;
        }
        return intResult;
    }
}

// 1.标记正负号，2.数字*10累加，3.非法字符置为0，4.越界处理，置为边界值