package com.code.leet;

/*
Given an integer, write a function to determine if it is a power of two.

 */

public class L0231PowerofTwo {
    public static void main(String[] args) {
        boolean powerOfTwo = new L0231PowerofTwo().isPowerOfTwo2(8);
        System.out.println(powerOfTwo);
    }
    public boolean isPowerOfTwo(int n) {
        double sqrt = Math.log(n) / Math.log(2);
        return Math.abs(sqrt - Math.floor(sqrt)) < 0.0000000001;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    boolean isPowerOfTwo3(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    boolean isPowerOfTwo4(int n) {
        if (n == 1) {
            return true;
        }
        return n % 2 == 0 && isPowerOfTwo4(n / 2);
    }


}
