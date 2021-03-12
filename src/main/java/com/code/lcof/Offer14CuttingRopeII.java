package com.code.lcof;

import java.math.BigInteger;

/**
 * Created by hejiaxu on 2021/2/19
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * <p>
 */
public class Offer14CuttingRopeII {
    public static void main(String[] args) {

        int n = 74;
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // 2

        int r = new Offer14CuttingRopeII().cuttingRope1(n);
        System.out.println(r);
    }


    /**
     * 不能通过取mod进行比较，数据会失真
     */
    public int cuttingRope(int n) {
        BigInteger[] r = new BigInteger[n];
        r[0] = BigInteger.valueOf(1);
        for (int i = 1; i < n; i++) {
            BigInteger max = r[0].multiply(BigInteger.valueOf(i));
            for (int j = 1; j < i; j++) {
                BigInteger multiply = r[j].multiply(BigInteger.valueOf(i - j));
                if (multiply.compareTo(max) > 0) {
                    max = multiply;
                }
                multiply = BigInteger.valueOf(j + 1).multiply(BigInteger.valueOf(i - j));
                if (multiply.compareTo(max) > 0) {
                    max = multiply;
                }
            }
            r[i] = max;
        }

        return r[n - 1].mod(BigInteger.valueOf(1000000007L)).intValue();
    }


    /**
     * 三相乘是最大的，结果是最多有若干个3和最多两个2的乘积（大于两个2时变成3乘以2更大）。如果n % 3为0，则正好是3相乘，为1则代表多出一个1放在3上更合适，为2则单独乘以2
     */
    public int cuttingRope1(int n) {
        return n <= 3 ? n - 1 : BigInteger.valueOf(3).pow(n / 3).multiply(BigInteger.valueOf(4)).divide(BigInteger.valueOf(4 - n % 3)).mod(BigInteger.valueOf(1000000007)).intValue();
    }


    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        //贪心算法，优先切三，其次切二
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int) (res * n % p);
    }

}
