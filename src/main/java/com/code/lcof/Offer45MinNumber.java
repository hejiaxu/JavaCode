package com.code.lcof;

import com.sun.deploy.util.StringUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Offer45MinNumber {

    public static void main(String[] args) {
        String[] s = new String[]{"3", "31", "112"};
        Arrays.sort(s);
//        int[] arr = new int[]{3, 9, 20, 15, 7};
        int[] arr = new int[]{12,121};
        String s1 = new Offer45MinNumber().minNumber(arr);
        System.out.println(s1);
    }

    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.joining());
    }
}
