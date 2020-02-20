package com.code.leet;


/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
public class L0342PowerofFour {
    public static void main(String[] args) {
        boolean powerOfFour3 = new L0342PowerofFour().isPowerOfFour3(-4);

        System.out.println(powerOfFour3);
    }
    public boolean isPowerOfFour(int num) {
        double sqrt = Math.log(num) / Math.log(4);
        return Math.abs(sqrt - Math.rint(sqrt)) < 0.0000000001;
    }

    public boolean isPowerOfFour2(int num) {
        return (num > 0) && (num % 4 == 0) && (num == 1 || isPowerOfFour2(num));
    }

    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    public boolean isPowerOfFour4(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    boolean isPowerOfFour5(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
