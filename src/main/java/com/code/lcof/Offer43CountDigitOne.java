package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 */
public class Offer43CountDigitOne {

    /**
     * 变量递推公式：
     * 设计按照 “个位、十位、...” 的顺序计算，则 high / cur / low / digit
     * high/cur/low/digit 应初始化为：
     * <p>
     * <p>
     * high = n / 10
     * cur = n % 10
     * low = 0
     * digit = 1 # 个位
     * 因此，从个位到最高位的变量递推公式为：
     * <p>
     * <p>
     * while high != 0 or cur != 0: # 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
     * low += cur * digit # 将 cur 加入 low ，组成下轮 low
     * cur = high % 10 # 下轮 cur 是本轮 high 的最低位
     * high //= 10 # 将本轮 high 最低位删除，得到下轮 high
     * digit *= 10 # 位因子每轮 × 10
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    public int countDigit(int n, int m) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur < m) res += high * digit;
            else if (cur == m) res += high * digit + low + 1;
            else res += high * digit + digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        int i = new Offer43CountDigitOne().countDigitOne(301);
        System.out.println(i);
    }

}

// 计算十进制下每一位为m的数字数量，累加得到综合
// 当前位是小于m,m,大于m的情况下计算规则各不相同