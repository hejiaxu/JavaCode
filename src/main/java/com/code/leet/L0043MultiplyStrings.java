package com.code.leet;

import java.math.BigInteger;

/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class L0043MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int maxLen = length1 + length2;
        if (length1 == 0 || length2 == 0) {
            return "0";
        }

        int[] r = new int[400];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        // 计算结果
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                int p = (chars1[i] - '0') * (chars2[j] - '0');
                r[maxLen - i - j - 2] += p;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 处理进位
        for (int i = 0; i < maxLen - 2; i++) {
            int p = r[i] % 10;
            r[i + 1] += r[i] / 10;
            r[i] = p;
        }

        // 合并结果
        for (int i = maxLen - 2; i >= 0; i--) {
            if (r[i] == 0 && sb.length() == 0 && i != 0) {
                continue;
            }
            sb.append(r[i]);
        }

        return sb.toString();
    }

    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of
     * num1 and num2, also represented as a string.
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * Example 1:
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * Example 2:
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     * Constraints:
     * 1 <= num1.length, num2.length <= 200
     * num1 and num2 consist of digits only.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     */
    public static void main(String[] args) {
        L0043MultiplyStrings multi = new L0043MultiplyStrings();
        String multiply = multi.multiply("0", "456");
        System.out.println(multiply);
        multiply = multi.multiply("123", "456");
        System.out.println(multiply);
        multiply = multi.multiply("2", "3");
        System.out.println(multiply);
        multiply = multi.multiply("000", "00000");
        System.out.println(multiply);
        multiply = multi.multiply("000", "1");
        System.out.println(multiply);
        multiply = multi.multiply(null, "1");
        System.out.println(multiply);

        String nums1 = "1111111111111111111111111";
        String nums2 = "55555555";
        multiply = multi.multiply(nums1, nums2);
        System.out.println(multiply);
        System.out.println(new BigInteger(multiply).compareTo(new BigInteger(nums1).multiply(new BigInteger(nums2))));

        String num1 = "442351525235";
        String val = "525253252";
        multiply = multi.multiply(num1, val);
        System.out.println(multiply);
        System.out.println(new BigInteger(multiply).compareTo(new BigInteger(num1).multiply(new BigInteger(val))));
    }
}
