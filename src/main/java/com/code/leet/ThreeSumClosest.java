/**
 * 
 */
package com.code.leet;

import java.util.Arrays;

/**
 * Jiaxu
 * Jun 10, 2017
 * 
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO 
		int[] nums = new int[]{0,2,1,-3};
		int target =1;
		int threeSumClosest = threeSumClosest(nums, target);
		System.out.println(threeSumClosest);
	}
	
	//32ms
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
        int  l=0;
        int sum = Integer.MAX_VALUE/2;
        while(l<nums.length-1){
        	int k=l+1; 
        	int r=nums.length-1;
        	while(k<r){
        		if (nums[l]+nums[k]+nums[r]-target<=Math.abs(sum-target)&&nums[l]+nums[k]+nums[r]-target>=-Math.abs(sum-target)) {
					sum=nums[l]+nums[k]+nums[r];
					
					//***
					if (nums[l]+nums[k]+nums[r]-target>0) {
						r--;
					}else {
						k++;
					}
				}else if (nums[l]+nums[k]+nums[r]-target>Math.abs(sum-target)) {
					r--;
				}else { 
					k++;
				}
        	}
        	        	l++;

        }
        return sum;
    }
	//20ms
	public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, closest = 0;
        for (int k=0; k<nums.length-2; ++k) {
            for (int i=k+1, j=nums.length-1; i<j; ) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == target) { return target; }
                else if (sum > target) {
                    if (sum-target < diff) {
                        diff = sum-target;
                        closest = sum;
                    }
                    --j;
                } else {
                    if (target-sum < diff) {
                        diff = target-sum;
                        closest = sum;
                    }
                    ++i;
                }
            }
        }
        return closest;
    }
}
