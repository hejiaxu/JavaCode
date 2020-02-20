/**
 * 
 */
package com.code.misc;

/**
 * Jiaxu
 * May 19, 2017
 * 
 */
public class KthInTwoSortedArray {
	public static void main(String[] args) {
		int[] s={1,3,5,6,22},t={2,4,8,10};
		int kthInArrays = kthInArrays(s, t, 3);
		System.out.println(kthInArrays);
	}
	
	public static int kthInArrays(int []s, int []t,int k){
		return findKth(s, 0, s.length, t, 0, t.length, k);
	}
	
	
	public static int findKth(int []s,int sStart,int sEnd,int[]t,int tStart,int tEnd,int k){
		if (tEnd-tStart>sEnd-sStart) {
			return findKth(t, tStart, tEnd, s, sStart, sEnd, k);
		}
		if (tEnd-tStart==0) {                        }
		if (k==1) {
			return Math.min(s[sStart], t[tStart]);
		}
		int ti=Math.min(tEnd-tStart, k/2);
		if (s[sStart+ti]>=t[tStart+ti]) {
			return findKth(s, sStart, sEnd, t, tStart+ti, tEnd, k-ti);
		}
		
		return findKth(s, sStart+ti, sEnd, t, tStart, tEnd, k-ti);
	}
}
