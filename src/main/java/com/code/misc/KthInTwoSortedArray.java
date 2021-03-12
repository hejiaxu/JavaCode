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
//		int[] s={1,3,5,6,22, 29, 30},t={2,4,8,10};
		int[] s={1,2},t={3,4};
		int kthInArrays = kth(s, t, 3);
		System.out.println(kthInArrays);
	}
	
	public static int kthInArrays(int []s, int []t,int k){
		return findKth(s, 0, s.length, t, 0, t.length, k);
	}
	
	
	public static int findKth(int []s,int sStart,int sEnd,int[]t,int tStart,int tEnd,int k){
		if (tEnd-tStart>sEnd-sStart) {
			return findKth(t, tStart, tEnd, s, sStart, sEnd, k);
		}
		if (tEnd-tStart==0) {

		}
		if (k==1) {
			return Math.min(s[sStart], t[tStart]);
		}
		int ti=Math.min(tEnd-tStart, k/2);
		if (s[sStart+ti]>=t[tStart+ti]) {
			return findKth(s, sStart, sEnd, t, tStart+ti, tEnd, k-ti);
		}
		
		return findKth(s, sStart+ti, sEnd, t, tStart, tEnd, k-ti);
	}

	public static int kth (int arr1[], int arr2[], int k) {
		int i = k;
		int arr1Pos = 0, arr2Pos = 0;
		while (i > 1) {

			int arr1PosRight = arr1Pos + i / 2 - 1;
			if (arr1PosRight >= arr1.length) {
				arr1PosRight = arr1.length - 1;
			}
			int arr2PosRight = i / 2 + arr2Pos - 1;
			if (arr2PosRight >= arr2.length) {
				arr2PosRight = arr2.length - 1;
			}

			if (arr1[arr1PosRight] < arr2[arr2PosRight]) {
				i -= arr1PosRight - arr1Pos + 1;
				arr1Pos = arr1PosRight + 1;
			} else {
				i -= arr2PosRight - arr2Pos + 1;
				arr2Pos = arr2PosRight + 1;
			}

			if (arr1Pos >= arr1.length) {
				return arr2[arr2Pos + i - 1];
			} else if (arr2Pos >= arr2.length) {
				return arr1[arr1Pos + i - 1];
			}
		}

		return arr1[arr1Pos] < arr2[arr2Pos] ? arr1[arr1Pos] : arr2[arr2Pos];
	}
}
