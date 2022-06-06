package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 *实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 *
 */
public class Offer16MyPow {
    public static void main(String[] args) {
//        int n = 3;
//        double d = 2.10000;
        int n = 2147483647;
        double d = 0.00001;
        double r = new Offer16MyPow().myPow2(d, n);
        System.out.println(r);
    }


    public double myPow(double x, int n) {
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }

        double r = dfs(x, n);
        return neg ? 1 / r : r;

    }

    private double dfs(double x, int n) {
        if (n > 3) {
            return dfs(x, n / 2) * dfs(x, n - n / 2);
        }

        double r = 1;
        for (int i = 0; i < n; i++) {
            r *= x;
        }
        return r;
    }


    public double myPow1(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow2(double x, int n) {
        long tmpN = n;
        if (tmpN < 0) {
            x = 1 / x;
            tmpN = -tmpN;
        }

        double tmp = x;
        double r = 1;
        while (tmpN > 0) {
            if ((tmpN & 1) == 1) {
                r *= tmp;
            }
            tmp *= tmp;
            tmpN >>>= 1;
        }

        return r;
    }
}
// review