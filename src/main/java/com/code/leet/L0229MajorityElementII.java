/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Jun 12, 2017
 * 
 */
public class L0229MajorityElementII {

	public static void main(String[] args) {
		// TODO 

	}
	//6ms
	 public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

	 	if (nums==null || nums.length<1) {
			return result;
		}
        int major1 = nums[0], count1 = 1,count2 = 0,major2 = -1,len = nums.length;
        for(int i = 1; i < nums.length; i++){
        	if (count1 == 0 && count2 == 0) {
                major1 = nums[i];
                count1++;
			}else if (count1 == 0 && count2 != 0) {
				if (major2 == nums[i]) {
					count2++;
				}else{
					major1 = nums[i];
	                count1++;
				}
			}else if(count1 != 0 && count2 == 0) {
				if (major1 == nums[i]) {
					count1++;
				}else{
					major2 = nums[i];
	                count2++;
				}
			}else {
				if (major1 == nums[i]) {
					count1++;
				}else if (major2 == nums[i]) {
					count2++;
				}else {
					count1--;
					count2--;
				}
			}
        }
        count1 = 0;
    	count2 = 0;
    	for (int i = 0; i < len; i++) {
    		if (nums[i] == major1)
    			count1++;
    		else if (nums[i] == major2)
    			count2++;
    	}
    	if (count1 > len / 3)
    		result.add(major1);
    	if (count2 > len / 3)
    		result.add(major2);
        return result;
    }
	 
	 
	 public List<Integer> majorityElement2(int[] nums) {
			if (nums == null || nums.length == 0)
				return new ArrayList<Integer>();
			List<Integer> result = new ArrayList<Integer>();
			int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
			for (int i = 0; i < len; i++) {
				if (nums[i] == number1)
					count1++;
				else if (nums[i] == number2)
					count2++;
				else if (count1 == 0) {
					number1 = nums[i];
					count1 = 1;
				} else if (count2 == 0) {
					number2 = nums[i];
					count2 = 1;
				} else {
					count1--;
					count2--;
				}
			}
			count1 = 0;
			count2 = 0;
			for (int i = 0; i < len; i++) {
				if (nums[i] == number1)
					count1++;
				else if (nums[i] == number2)
					count2++;
			}
			if (count1 > len / 3)
				result.add(number1);
			if (count2 > len / 3)
				result.add(number2);
			return result;
		}
}
