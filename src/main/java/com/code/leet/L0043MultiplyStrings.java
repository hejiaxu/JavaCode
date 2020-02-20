package com.code.leet;

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
        int[] r = new int[220];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                r[num1.length() + num2.length() -i - j - 2] += p;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length() - 2; i++) {
            int p = r[i] % 10;
            r[i + 1] += r[i] / 10;
            r[i] = p;
        }
        for (int i = num1.length() + num2.length() - 2; i >= 0; i--) {
            if (r[i] == 0 && sb.length() == 0 && i != 0) {
                continue;
            }
            sb.append(r[i]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        String multiply = new L0043MultiplyStrings().multiply("13", "33");
        System.out.println(multiply);
    }
}
