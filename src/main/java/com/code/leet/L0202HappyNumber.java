package com.code.leet;

import java.util.HashSet;
import java.util.Set;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class L0202HappyNumber {

    public static void main(String[] args) {
        boolean happy = new L0202HappyNumber().isHappy(7);
        System.out.println(happy);
    }
    public boolean isHappy(int n) {
        int count = 0;
        int num = n;
        while (count++ < 8) {
            int o = num % 10;
            int sum = o * o;
            while (num >= 10) {
                num = num / 10;
                o = num % 10;
                sum += o * o;
            }
            if (sum == 1) {
                return true;
            }
            num = sum;
        }
        return false;
    }


    public boolean isHappy2(int n) {
        int num = n;
        Set<Integer> set = new HashSet<>();
        while (true) {
            int o = num % 10;
            int sum = o * o;
            while (num >= 10) {
                num = num / 10;
                o = num % 10;
                sum += o * o;
            }
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            num = sum;
        }
    }

}
