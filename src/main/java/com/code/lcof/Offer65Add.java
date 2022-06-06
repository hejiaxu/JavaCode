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
public class Offer65Add {


	// miss
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 2};
		Offer65Add c = new Offer65Add();
		int r = c.add(1, -7);
		System.out.println(r);
	}

	/**
	 * 1.按位 &, 相同则进位
	 * 2.不相同则保留
	 * 3.当没有进位时返回值
	 */
	public int add(int a, int b) {
		if (b == 0) return a;
		return add(a ^ b, (a & b) << 1);
	}
}
