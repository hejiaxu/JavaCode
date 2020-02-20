package com.code.leet;


/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class L0067AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length(); i++) {
            int sum = carry + a.charAt(a.length() - i - 1) -'0' + b.charAt(b.length() - i - 1) -'0';
            carry = sum >= 2 ? 1 : 0;
            sb.insert(0, sum % 2);
        }
        for (int i = a.length(); i < b.length(); i++) {
            int sum = carry + b.charAt(b.length() - i - 1) -'0';
            carry = sum >= 2 ? 1 : 0;
            sb.insert(0, sum % 2);
        }
        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
