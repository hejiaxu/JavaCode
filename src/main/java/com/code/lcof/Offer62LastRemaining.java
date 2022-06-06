/**
 * 
 */
package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 */
public class Offer62LastRemaining {


	/**
	 * 暴力超时
	 */
	public static void main(String[] args) {
		// TODO
		Offer62LastRemaining c = new Offer62LastRemaining();
		int uniquePaths = c.lastRemaining2(20, 22);
		System.out.println(uniquePaths);
	}
	public int lastRemaining(int n, int m) {
		int f = 0;
		for (int i = 2; i != n + 1; ++i) {
			f = (m + f) % i;
		}
		return f;
	}

	/**
	 * f(N, M) = (M + f(N − 1, M)) % N
	 * f(1, M) = 0;
	 * 原理简述：
	 * 胜利者编号是随人数变动的，当只有一人时，不用淘汰，胜利者下标 = 0，
	 * 当变成两人时，要淘汰一人，所以胜利者前面还要叫M个号，才能保证胜利者刚好不会被淘汰，但是加上的号很可能会超过人头总数
	 * 所以要对加后的值取模
	 * 比如M=5时，两个人，胜利者编号 （5个号 + 0）% 2 = 1，5 = 2 * 2 + 1，叫过两圈后第一个（下标0）会被淘汰，所以把胜利者排在那个人后面，编号变成了1；
	 * 再比如3个人，在两个人选出胜利者的基础上往胜利者前再加5个号（5个号 + 1）% 3 = 0，5 = 1 * 3 + 2
	 * 叫一圈还要再在胜利者原本的队列前面排两人，那他本身前面已经有一个人了，再+2刚好超过下标，所以要变成排首
	 * 后面以此类推
	 */

	public int lastRemaining2(int n, int m) {
		return f(n, m);
	}

	public int f(int n, int m) {
		if (n == 1) {
			return 0;
		}
		int x = f(n - 1, m);
		return (m + x) % n;
	}
}
