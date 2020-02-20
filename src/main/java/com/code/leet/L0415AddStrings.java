package com.code.leet;

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class L0415AddStrings {

    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i1 >= 0 && i2 >= 0) {
            int add1 = num1.charAt(i1) - '0';
            int add2 = num2.charAt(i2) - '0';
            int sum = (add1 + add2 + carry);
            carry = sum / 10;
            stringBuilder.insert(0, sum  % 10);
            i1--;
            i2--;
        }

        while(i1 >= 0) {
            int add = num1.charAt(i1) - '0';
            int sum = (add + carry);
            carry = sum / 10;
            stringBuilder.insert(0, sum % 10);
            i1--;
        }

        while(i2 >= 0) {
            int add = num2.charAt(i2) - '0';
            int sum = (add + carry);
            carry = sum / 10;
            stringBuilder.insert(0, sum % 10);
            i2--;
        }

        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new L0415AddStrings().addStrings("923", "321");
        System.out.println(s);
    }
}
