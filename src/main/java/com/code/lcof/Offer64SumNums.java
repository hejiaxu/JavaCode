/**
 * 
 */
package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 */
public class Offer64SumNums {

	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 2};
		Offer64SumNums c = new Offer64SumNums();
		int r = c.sumNums(1);
		System.out.println(r);
	}

	public int sumNums2(int n) {
		return n * (n + 1) / 2;
	}

	public int sumNums(int n) {
		if (n == 1) return 1;
		return sumNums(n - 1) + n;
	}
}
