package com.code.leet;

/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
You are responsible to gather all the input requirements up front.



Requirements for atoi:

The function first discards as many whitespace characters as necessary
until the first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters,
no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
If the correct value is out of the range of representable values,
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class L0008StringtoInteger_atoi {

    public static void main(String[] args) {
        Integer.parseInt("1");
        Integer.valueOf("1");
        int i = new L0008StringtoInteger_atoi().myAtoi("1");
        System.out.println(i);

    }
    //case 1 :  > Integer.MAX_VALUE
    //case 2 :  < Integer.MIN_VALUE
    //case 3 :  negative
    //case 4 :  invalid surrounding character
    //case 5 :  > Long.MAX_VALUE
    public int myAtoi(String str) {
        long longResult = 0;
        int neg = 1;
        char[] chars = str.toCharArray();
        int i = 0;

        //deal with whitespace
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }

        //deal with +/-
        if (i < chars.length && chars[i] == '-') {
            neg = -1;
            i++;
        } else if (i < chars.length && chars[i] == '+') {
            i++;
        }

        //deal with number
        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9' && longResult < (long)2 * Integer.MAX_VALUE) {
            longResult = longResult * 10 + chars[i] - '0';
            i++;
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
