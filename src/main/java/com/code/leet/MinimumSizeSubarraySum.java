/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 9, 2017
 * 
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO 

	}
	//3ms
	public int minSubArrayLen(int s, int[] nums) {
		int minLen = nums.length+1;
        int i=0,j=0,sum=0;
        while(j<nums.length||sum>=s){
        	if (sum>=s) {
				minLen=Math.min(minLen, j-i);
				sum-=nums[i++];
			}else {
				sum+=nums[j++];
			}
        }
        if(minLen==nums.length+1)return 0;
        return minLen;
    }

}
