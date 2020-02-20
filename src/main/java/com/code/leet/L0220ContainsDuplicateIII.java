/**
 * 
 */
package com.code.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 Given an array of integers, find out whether there are two distinct indices i and j
 in the array such that the absolute difference between nums[i] and nums[j] is at most t
 and the absolute difference between i and j is at most k.

 */
public class L0220ContainsDuplicateIII {

	public static void main(String[] args) {
		int[] a = {-3, 3};
		boolean containsNearbyAlmostDuplicate4 = new L0220ContainsDuplicateIII().containsNearbyAlmostDuplicate(a, 2, 4);
		System.out.println(containsNearbyAlmostDuplicate4);
	}

	//58ms O(N*log(k))
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long tmp = (long)nums[i];
			if (i > k) {
				set.remove((long)nums[i - k]);
			}

			Long ceil = set.ceiling(tmp);
			if (ceil != null && ceil - tmp <= t) {
				return true;
			}

			Long floor = set.floor(tmp);
			if (floor != null && tmp - floor <= t) {
				return true;
			}
			set.add(tmp);
		}
		
		return false;
	}

	//28ms O(N)
	public boolean containsNearbyAlmostDuplicate5(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
}
