package com.code.diy;

import java.math.BigDecimal;

/**
 * Created by hejiaxu on 2021/1/15
 */
public class SqrtTrible {

    public static void main(String[] args) {
        double v = divideG(28.01);
        BigDecimal bigDecimal = new BigDecimal(v).setScale(2, BigDecimal.ROUND_UP);
        System.out.println(bigDecimal.doubleValue());
    }

    public static double divideG(double num) {
        int neg = num < 0 ? -1 : 1;
        num = Math.abs(num);
        double right = num,left = 0;
        while (left < right) {
            double mid = (right + left) / 2; // 13.49,6.74,3.33，2.50，2.92, 3.13
            if (mid * mid * mid < num) {
                if ((mid + 0.01) * (mid + 0.01) * (mid + 0.01) >= num) {
                    return neg * mid;
                }
                left = mid + 0.01; // (1.67, 3.33) (2.51, 3.33)(2.93, 3.33)
            } else {
                right = mid - 0.01; //13.49,6.74,3.33 (2.93, 3,12)
            }
        }
        return neg * left;
    }
}
