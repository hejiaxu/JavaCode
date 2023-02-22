package com.code.leet;


import java.util.HashMap;
import java.util.Map;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.



Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"


Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
 */
public class L0166FractionToRecurringDecimal {

    public static void main(String[] args) {
        String s = new L0166FractionToRecurringDecimal().fractionToDecimal(-1, 17);
        System.out.println(s);
    }
    // 计算正负
    // 
    public String fractionToDecimal(int numerator, int denominator) {
        String neg = numerator == 0 || ((numerator ^ denominator) >> 31 & 0x01) != 1 ? "" : "-";
        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(neg);
        stringBuilder.append(num / den);
        num %= den;
        if (num == 0) {
            return stringBuilder.toString();
        }
        Map<Long, Integer> cache = new HashMap<>();
        stringBuilder.append(".");
        int pos = stringBuilder.length();
        while (num != 0) {
            cache.put(num, pos);
            if (num < den) {
                num *= 10;
            }
            pos++;
            stringBuilder.append(num / den);
            num %= den;
            if (cache.containsKey(num)) {
                Integer recurPos = cache.get(num);
                return stringBuilder.substring(0, recurPos) + "(" + stringBuilder.substring(recurPos) + ")";
            }
        }

        return stringBuilder.toString();
    }
}

// String.format
// 计算符号        String neg = numerator == 0 || ((numerator ^ denominator) >> 31 & 0x01) != 1 ? "" : "-";
// 强制转换        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);