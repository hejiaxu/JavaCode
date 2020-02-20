/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 11, 2017
 * 
 */
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO 

	}
	
	//2ms
	public void moveZeroes(int[] nums) {
        int l=0,r=0;
        while(r<nums.length){
        	if (nums[r]==0) {
				swap(nums,l++,r);
			}
        	r++;
        }
    }
	void swap(int[] nums,int l, int r){
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
	//1ms
	public void moveZeroes2(int[] nums) {
	      int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	    }
	
	//0ms
	public void moveZeroes3(int[] nums){
		int index=0;
		for (int i=0;i<nums.length;i++){
			if (nums[i]!=0) nums[index++]=nums[i];
		}
		while(index<nums.length){
			nums[index++]=0;
		}
	}
}
