/**
 *
 */
package com.code.leet;

/**

 Implement int sqrt(int x).

 Compute and return the square root of x.

 x is guaranteed to be a non-negative integer.
 */
public class L0069SqrtX {
    public static void main(String[] args) {
        int mySqrt = new L0069SqrtX().mySqrt(8);
        System.out.println(mySqrt);
    }

    // r的落脚一定在左边，精彩
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int l = 0, r = x / 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            long pow = (long) mid * mid;
            if (pow == x) {
                return mid;
            } else if (pow < x) {
                l = (mid + 1);
            } else {
                r = (mid - 1);
            }
        }
        return r;
    }

    // y = sqrt(x) -> x - y ^ 2 = 0
    // f = y ^ 2 - x0
    // f' = 2y
    // f' * (yn - yn-1) = xn - xn-1
    // yn = yn-1 - (yn-1 ^ 2 - x0) / (2 * yn-1)
    double sqrt(double x) {
        double yp = x + 0.25, yn, ypp = yp;
        for (; ; ) {
            yn = (yp * yp + x) / (2 * yp);
            if (Math.abs(yn - yp) <= 0.00001) break;
            if (ypp == yn) {
                break; // to break two value cycle.
            }
            ypp = yp;
            yp = yn;
        }
        return yn;
    }

    int mySqrt2(int x) {
        double yp = x + 0.25, yn;
        for (; ; ) {
            yn = (yp * yp + x) / (2 * yp);
            if (Math.abs(yn - yp) <= 0.1) break;
            yp = yn;
        }
        return (int) yn;
    }
}
