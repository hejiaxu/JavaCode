/**
 * 
 */
package com.code.leet;

import java.util.HashMap;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class L0001TwoSum {
	public static void main(String[] args) {
		int []nums = new int[]{-2,-1,0,1,2,4};
		int[] twoSum = new L0001TwoSum().twoSum(nums, 3);
		for (int i : twoSum) {
			System.out.print(i);
		}
	}

	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
	}
	public static int[] twoSum2(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<r){
        	if (nums[l]+nums[r]==target) {
				break;
			}else if (nums[l]+nums[r]>target) {
				int start=l+1,end=r-1;
				int mid = start;
				while(start<end){
					mid = (start+end)/2;
					if (nums[mid] ==target-nums[l]) {
						break;
					}else if (nums[mid] >target-nums[l]) {
						end=mid-1;
					}else {
						start=mid+1;
					}
				}
				r=mid;
			} else {
				int start=l+1,end=r-1;
				int mid = start;
				while(start<end){
					mid = (start+end)/2;
					if (nums[mid]==target-nums[r]) {
						break;
					}else if (nums[mid]>target-nums[r]){
						end=mid-1;
					}else {
						start=mid+1;
					}
				}
				l=mid;
			}
        }
        return new int[]{nums[l],nums[r]};

    }

}
