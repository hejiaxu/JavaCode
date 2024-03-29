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

}
