/**
 * 
 */
package com.code.leet;

import java.util.HashSet;

/**
 * Jiaxu
 * Apr 20, 2017
 * 
 */
public class L0217ContainsDuplicate {

	public static void main(String[] args) {
		// TODO 

	}
	//27ms
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
        	if (set.contains(nums[i])) {
				return true;
			}else {
				int j = nums[i];
				set.add(j);
			}
			
		}
		
		return false;
    }
	//15ms
	public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
			 if(!set.add(i))// if there is same
				 return true;
		
		return false;
    }
}
