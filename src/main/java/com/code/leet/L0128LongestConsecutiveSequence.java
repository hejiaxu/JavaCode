package com.code.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class L0128LongestConsecutiveSequence {

	public static void main(String[] args) {
//		int[] nums = new int []{0,-1};
//		int[] nums = new int []{100, 4, 200, 1, 3, 2};
		int[] nums = new int []{0,0};
//		int longestConsecutive = longestConsecutive(nums);
//		System.out.println(longestConsecutive);
		int i = new L0128LongestConsecutiveSequence().longestConsecutive(nums);
		System.out.println(i);
	}
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 0;
		int l = 0, r = 1;
		while(r < nums.length){
			if (nums[r] == nums[r - 1]) {
				l++;
			}else if(nums[r] != nums[r - 1] + 1){
				if(r - l> max){
					max = r - l;
				}
				l = r;
			}
			r++;
		}
		if(r - l > max){
			max = r - l;
		}
		return max;
    }
	

	public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
		}
		Set<Integer> set = new HashSet<>();
		for(int num: nums) {
			set.add(num);
		}
		int max = 1;
		for(int num: nums) {
			if(set.remove(num)) {//num hasn't been visited
				int val = num;
				int sum = 1;
				while(set.remove(--val)) {
					sum++;
				}
				val = num;
				while(set.remove(++val)) {
					sum++;
				}
				max = Math.max(max, sum);
			}
		}
		return max;
    }

}
