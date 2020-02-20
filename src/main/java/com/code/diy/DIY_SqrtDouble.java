package com.code.diy;

public class DIY_SqrtDouble {

    public static void main(String[] args) {
        double sqrt = new DIY_SqrtDouble().sqrt(0.01);
        System.out.println(sqrt);
        double sqrt2 = new DIY_SqrtDouble().sqrt2(36);
        System.out.println(sqrt2);
    }

    double sqrt(double x) {
        assert (x >= 0);
        double l = 0;
        double r = x + 0.25;
        double mid = (l + r) / 2;
        while (Math.abs(mid * mid - x) > 0.00001) {
            if (mid * mid > x) {
                r = mid;
            } else {
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    // y = sqrt(x) -> x - y ^ 2 = 0
    // f = y ^ 2 - x0
    // f' = 2y
    // f' * (yn - yn-1) = xn - xn-1
    // yn = yn-1 - (yn-1 ^ 2 - x0) / (2 * yn-1)
    double sqrt2(double x) {
        double yp = x + 0.25, yn, ypp = yp;
        for (; ; ) {
            yn = (yp * yp + x) / (2 * yp);
            if (Math.abs(yn - yp) <= 0.00001) break;
            if (ypp == yn) break; // to break two value cycle.
            ypp = yp;
            yp = yn;
        }
        return yn;
    }
}
