/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 10, 2017
 * 
 */
public class MaximumGap {
	public static void main(String[] args) {
		// TODO 

	}
	public int maximumGap(int[] nums) {
        if (nums.length<2) {
			return 0;
		}
        int l=0,r=1,maxMinGap=0;
        boolean asc=true;
        while(r<nums.length){
        	if (nums[r]<nums[l]) {
				maxMinGap=Math.max(nums[r-1]-nums[l], maxMinGap);
				l=r;
			}
        	r++;
        }
		maxMinGap=Math.max(nums[r-1]-nums[l], maxMinGap);
        return maxMinGap;
    }
}
