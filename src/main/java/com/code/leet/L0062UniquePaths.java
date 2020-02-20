/**
 * 
 */
package com.code.leet;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class L0062UniquePaths {

	public static void main(String[] args) {
		// TODO
		L0062UniquePaths l0062UniquePaths = new L0062UniquePaths();
		int uniquePaths = l0062UniquePaths.uniquePaths(23, 12);
		System.out.println(uniquePaths);
	}
	
	//0ms
	public int uniquePaths(int m, int n) {
		if (m > n) {
			return uniquePaths(n, m);
		}
		int[] tmp = new int[m];
		tmp[0]=1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				tmp[j] += tmp[j - 1];
			}
		}
		return tmp[m - 1];
	}
	
	public int uniquePaths2(int m, int n) {
		if (m > n) return uniquePaths2(n, m);
		long result = 1;
		for (int i = 1; i < m; i++) {
//			int N = n+m-2;
//			result= result*(N-i+1)/i;
			result *= (n - 1 + i) / i;
		}
		return (int)result;
	}
}
