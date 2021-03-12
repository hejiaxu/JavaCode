package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
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
 * 提示：
 * <p>
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
public class Offer14CuttingRope {
    public static void main(String[] args) {

        int n = 8;
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // 2

        int r = new Offer14CuttingRope().cuttingRope1(n);
        System.out.println(r);
    }

    int count = 0;

    public int cuttingRope(int n) {
        int[] r = new int[n];
        r[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = r[0] * i;
            for (int j = 1; j < i; j++) {
                if (r[j] * (i - j) > max) {
                    max = r[j] * (i - j);
                }
                if ((j + 1) * (i - j) > max) {
                    max = (j + 1) * (i - j);
                }
            }
            r[i] = max;
        }

        return r[n - 1];
    }


    /**
     * 三相乘是最大的，结果是最多有若干个3和最多两个2的乘积（大于两个2时变成3乘以2更大）。如果n % 3为0，则正好是3相乘，为1则代表多出一个1放在3上更合适，为2则单独乘以2
     */
    public int cuttingRope1(int n) {
        return n <= 3 ? n - 1 : (int) Math.pow(3, n / 3) * 4 / (4 - n % 3);
    }
}
