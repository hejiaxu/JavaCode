/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 13, 2017
 * 
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO 
		int []nums=new int[]{3,2,1};
		nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}
	//19ms
	public static void nextPermutation(int[] nums) {
		int len=nums.length,i = len-2;
		if (len<2) {
			return;
		}
		while(i>=0&&nums[i+1]<=nums[i])i--;
        if (i>=0) {
        	int j=i+1;
        	while(j<len&&nums[j]>nums[i])j++;
        	swap(nums,i,j-1);
		}
        reverse(nums,i+1,len-1);
    }
	private static void reverse(int[] nums, int i, int j) {
		// TODO 
		while(i<j){
			swap(nums, i, j);
			i++;
			j--;
		}
		
	}
	private static void swap(int[] nums, int i, int j) {
		// TODO 
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
