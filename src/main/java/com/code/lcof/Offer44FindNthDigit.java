package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *  
 *
 * 限制：
 *
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 *
 */
public class Offer44FindNthDigit {
    public static void main(String[] args) {
        int nthDigit2 = new Offer44FindNthDigit().findNthDigit(1);
        System.out.println(nthDigit2);
    }

    /**
     * 1.每个区间10倍增加
     * 2.计算区间
     * 3.按照数字除取的数字  n - 1 / 单数位数
     * 4.按照取余取的位数, n-1 mod 单数位数
     */
    public int findNthDigit(int n) {
        int digitNum = 1;
        long start = 1;
        long countNum = 9;
        while (n > countNum) { // 1.
            n -= countNum;
            digitNum += 1;
            start *= 10;
            countNum = digitNum * start * 9;
        }
        long num = start + (n - 1) / digitNum; // 2.
        return Long.toString(num).charAt((n - 1) % digitNum) - '0'; // 3.
    }

    /**
     * 超时
     */
    public int findNthDigit2(int n) {
        long num = 1;
        int count = 0;
        while (count < n) {
            char[] chars = String.valueOf(num).toCharArray();
            int len = chars.length;
            if (count >= n - len) {
                return chars[n - count - 1] - '0';
            }
            count += len;
            num++;
        }

        return -1;

    }


}
