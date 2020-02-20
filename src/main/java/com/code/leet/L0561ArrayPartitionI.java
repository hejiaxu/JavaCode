/**
 * 
 */
package com.code.leet;

import java.util.LinkedList;

/**
 * Jiaxu
 * Jun 11, 2017
 * 
 */
public class L0561ArrayPartitionI {

	public static void main(String[] args) {
		// TODO
		LinkedList hashSet = new LinkedList();
		LinkedList hashSet2 = new LinkedList();
		hashSet.addAll(hashSet2);
	}
	
 	//0ms
    public int arrayPairSum(int[] nums) {
        int[] exist = new int[20001];
 		for (int i = 0; i < nums.length; i++) {
 			exist[nums[i] + 10000]++;
 		}
 		int sum = 0;
 		boolean odd = true;
 		for (int i = 0; i < exist.length; i++) {
 			while (exist[i] > 0) {
 				if (odd) {
 					sum += i - 10000;
 				}
 				odd = !odd;
 				exist[i]--;
 			}
 		}
 		return sum;
     }
}
