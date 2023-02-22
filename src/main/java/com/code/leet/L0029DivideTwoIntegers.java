/**
 *
 */
package com.code.leet;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class L0029DivideTwoIntegers {

    public static void main(String[] args) {
        // TODO
        //  -2147483648
        //-1

        int divide = new L0029DivideTwoIntegers().divide2(-2147483648, 2147483647);
        System.out.println(divide);

        divide = new L0029DivideTwoIntegers().divide(-2147483648,2147483647);
//        divide = new L0029DivideTwoIntegers().divide(-2147483648,-1);
//		int divide = new L0026DivideTwoIntegers().divide(2147483647,1);
//		int divide = new L0026DivideTwoIntegers().divide4(2147483647,3);
        System.out.println(divide);
    }

    //
    //41ms
    public int divide(int dividend, int divisor) {
        //
        boolean sign = false;
//        boolean sign = (((dividend ^ divisor) >> 31 & 0x01) == 1) ? true : false;
        // 计算符号：要在转换成long之前，否则符号的位置发生了变化
        long dd = dividend, dr = divisor;
        if (dr == 0) {
            return Integer.MAX_VALUE;
        }
        long result = 0;
        if (dd < 0) {
            sign = !sign;
            dd = 0 - dd;
        }
        if (dr < 0) {
            sign = !sign;
            dr = 0 - dr;
        }
        result = divide(dd, dr);
        if (sign) {
            result = 0 - result;
        }

        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }

    public long divide(long dividend, long divisor) {
        long sum = 0, tmp = 1, tmpDivisor = divisor;
        if (dividend < tmpDivisor) {
            return 0;
        } else if (dividend < tmpDivisor + tmpDivisor) {
            return 1;
        } else {
            while ((tmpDivisor << 1) < dividend) {
                tmpDivisor = tmpDivisor << 1;
                tmp = tmp << 1;
            }

            while (tmpDivisor >= divisor) {
                if (dividend >= tmpDivisor) {
                    sum += tmp;
                    dividend -= tmpDivisor;
                } else {
                    tmpDivisor = (tmpDivisor >> 1);
                    tmp = (tmp >> 1);
                }
            }
            return sum;
        }
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = ((dividend ^ divisor) >> 31 & 0x01) == 1 ? -1 : 1;
        int pre = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend -= sign * divisor;
            pre += sign;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int r = 0, tmpDivisor = divisor, tmp = 1;
        while (tmpDivisor <= dividend) {
            dividend -= tmpDivisor;
            r += tmp;
            if ((dividend >> 1) > tmpDivisor) {
                tmpDivisor <<= 1;
                tmp <<= 1;
            }
        }
        while (tmpDivisor >= divisor) {
            if (tmpDivisor <= dividend) {
                dividend -= tmpDivisor;
                r += tmp;
            }
            tmpDivisor >>= 1;
            tmp >>= 1;
        }

        return sign * r == Integer.MAX_VALUE ? sign * r : sign * r + pre;
    }
}
