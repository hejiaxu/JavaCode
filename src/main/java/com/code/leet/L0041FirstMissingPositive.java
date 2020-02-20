/**
 * 
 */
package com.code.leet;

/**
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class L0041FirstMissingPositive {

	public static void main(String[] args) {
		// TODO 
//		int[] nums = {0,1,1};
		int[] nums = {1};
//		int[] nums = {3,4,-1,1};
//		int[] nums = {-1,4,2,1,9,10};
		int num = new L0041FirstMissingPositive().firstMissingPositive(nums);
		System.out.println(num);
	}


	public  int firstMissingPositive2(int nums[]){
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > 0 && nums[i] < nums.length) {
				swap(nums, i, nums[i] - 1);
			}
		}
		int j = 0;
		while (j < nums.length && nums[j] == j + 1) {
		    j++;
        }
		return j + 1;
	}

	//2ms
	public int firstMissingPositive(int nums[]){
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]!=i+1 && nums[i] < nums.length && nums[i] > 0 && nums[i]!= nums[nums[i]-1]) {
				swap(nums, i);
			}
		}
		int j = 0;
		while (j < nums.length && nums[j] == j+1) {
		    j++;
        }
		return j+1;
	}



	private void swap(int[] nums, int i) {
		int tmp = nums[nums[i]-1];
		nums[nums[i]-1] = nums[i];
		nums[i] = tmp;
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}



}
