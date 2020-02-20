/**
 * 
 */
package com.code.leet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Jun 9, 2017
 * 
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO 
		int []nums = new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> threeSum = threeSum(nums);
		for (Iterator iterator = threeSum.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
				System.out.print(",");
			}
			System.out.println();
			
		}
	}
	//81ms
	public static List<List<Integer>> threeSum(int[] nums) {
	 	Arrays.sort(nums);
		
		List<List<Integer>> result = new LinkedList<>();
		int k=0,r=nums.length;
		while(k < r-2) {
			if (!(k>0&&nums[k]==nums[k-1])) {
				int target = -nums[k];
				int i=k+1,j=r-1;
				while(i<j){
					if (nums[i]+nums[j]==target) {
						List<Integer> item = Arrays.asList(nums[k],nums[i],nums[j]);
						result.add(item);;
						while(i<j&&nums[i]==nums[i+1]){
							i++;
						}
						while(i<j&&nums[j]==nums[j-1]){
							j--;
						}
						i++;j--;
					}else if (nums[i]+nums[j]>target) {
						j--;
					}else {
						i++;
					}
				}
			}
			
			k++;
		}
		return  result;
    }
	
	//81ms
	public static List<List<Integer>> threeSum2(int[] nums,int t) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		int k=0,r=nums.length;
		while(k < r-2) {
			if (!(k>0&&nums[k]==nums[k-1])) {
				int target = t-nums[k];
				int i=k+1,j=r-1;
				while(i<j){
					if (nums[i]+nums[j]==target) {
						List<Integer> item = Arrays.asList(nums[k],nums[i],nums[j]);
						result.add(item);;
						while(i<j&&nums[i]==nums[i+1]){
							i++;
						}
						while(i<j&&nums[j]==nums[j-1]){
							j--;
						}
						i++;j--;
					}else if (nums[i]+nums[j]>target) {
						j--;
					}else {
						i++;
					}
				}
			}
			
			k++;
		}
		return  result;
	}
}
