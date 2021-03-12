package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 */
public class Offer10NumWays {
    public static void main(String[] args) {

        int r = new Offer10NumWays().numWays(7);
        System.out.println(r);
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int tmp1 = 1, tmp2 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp3 = tmp1 + tmp2;
            tmp1 = tmp2 % 1000000007;
            tmp2 = tmp3 % 1000000007;
        }
        return tmp2;
    }
}
