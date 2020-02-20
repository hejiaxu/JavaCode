package com.code.leet;

/*

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class L0326PowerofThree {
    public static void main(String[] args) {
        boolean powerOfThree = new L0326PowerofThree().isPowerOfThree(243);
        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n) {
        double sqrt = Math.log(n) / Math.log(3);
        return Math.abs(sqrt - Math.rint(sqrt)) < Double.MIN_VALUE;
    }

    public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 && (3 ^ 19) % n == 0);
    }

    public boolean isPowerOfThree3(int n) {
        return (n > 0) && (n % 4 == 0) && (n == 1 || isPowerOfThree3(n / 3));
    }

    public boolean isPowerOfThree4(int n) {
        return Integer.toString(n, 3).matches("10*");
    }

    public boolean isPowerOfThree5(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
