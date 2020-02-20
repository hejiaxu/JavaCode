package com.code.leet;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
 */
public class L0007ReverseInteger {
    public static void main(String[] args) {

        int reverse = new L0007ReverseInteger().reverse2(-2147483648);
        System.out.println(reverse);
        System.out.println(Integer.signum(-2));
    }
    public int reverse(int x) {
        try {
            return Integer.signum(x) * Integer.parseInt(new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        int r = 0;
        long l = (long) x;
        long abs = Math.abs(l);
        String str = Long.toString(abs);
        long lReverse = Integer.signum(x) * Long.parseLong(new StringBuilder(str).reverse().toString());
        if (lReverse <= Integer.MAX_VALUE && lReverse >= Integer.MIN_VALUE) {
            r = (int)lReverse;
        }
        return r;
    }
}
