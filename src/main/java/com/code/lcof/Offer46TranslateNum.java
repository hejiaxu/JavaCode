package com.code.lcof;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by hejiaxu on 2021/2/19
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 */
public class Offer46TranslateNum {

    public static void main(String[] args) {
        String[] s = new String[]{"3", "31", "112"};
        Arrays.sort(s);
//        int[] arr = new int[]{3, 9, 20, 15, 7};
        int num = 12258;
        int s1 = new Offer46TranslateNum().translateNum(num);
        System.out.println(s1);
    }

    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] r = new int[chars.length];
        r[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            r[i] += r[i - 1];
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '5')) {
                if (i > 1) {
                    r[i] += r[i - 2];
                } else {
                    r[i] += 1;
                }
            }
        }

        return r[chars.length - 1];
    }
}
