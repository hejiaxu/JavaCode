/**
 * 
 */
package com.code.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Jiaxu
 * Apr 20, 2017
 * 
 */
public class L0219ContainsDuplicateII {

	public static void main(String[] args) {
//		containsNearbyDuplicate4({-1,-1}, 1);
		
		int [] a = {-1,2,1};
		boolean containsNearbyDuplicate4 = new L0219ContainsDuplicateII().containsNearbyDuplicate3(a, 1);
		System.out.println(containsNearbyDuplicate4);
	}

	//20ms
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])&&i-map.get(nums[i])<=k) {
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
    }

	//23ms
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (j - i > k) {
                set.remove(nums[i]);
                i++;
            }
            if (set.contains(nums[j])) return true;
            set.add(nums[j]);
        }
        return false;
	}
	//23ms
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		int i = 0, j = 0;
		for (; j < nums.length; j++) {
			if (j - i > k) {
				set.remove(nums[i]);
				i++;
			}
			if (set.contains(nums[j])) return true;
			set.add(nums[j]);
		}
		return false;
	}
}
