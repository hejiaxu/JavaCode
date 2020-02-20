/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 Given a collection of distinct numbers, return all possible permutations.
 */
public class L0046Permutation {

	public static void main(String[] args) {
		// TODO
		int []nums=new int[]{1, 1, 1, 4};
		Integer [] nums2 = new Integer[nums.length];
		List<List<Integer>> permute6 = new L0046Permutation().permute2(nums);
		for (Iterator iterator = permute6.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}

	//10ms
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> r = new LinkedList<>();
		r.add(new ArrayList<Integer>());
		for(int i = 0; i < nums.length; i++) {
			int n = r.size();
			for(int j = 0; j < n; j++){
				List<Integer> list = r.poll();
				for(int k = 0; k <= list.size(); k++){
					ArrayList<Integer> t = new ArrayList<>(list);
					t.add(k, nums[i]);
					r.offer(t);
				}
			}
		}
		return r;
	}

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        permuteRecur(result, nums,0);
		return result;
    }

	private void permuteRecur(List<List<Integer>> result, int[] nums, int i) {
		int len = nums.length;
		if (i == len - 1) {
			List<Integer> item = new LinkedList<>();

			for (int k = 0; k < len; k++) {
                item.add(nums[k]);
            }

			result.add(item);
			return;
		}

		for (int l = i; l < len; l++) {
			swap(nums, i, l);
			permuteRecur(result, nums, i + 1);
			swap(nums, i, l);
		}
	}
	
	//10ms
	public List<List<Integer>> permute6(int[] nums) {
  		List<List<Integer>> result = new LinkedList<>();
  		int len = nums.length;
		int sum = 1;
		List<Integer> item = new LinkedList<>();

		for(int i = 0; i < len; i++) {
  			sum *= (i + 1);
			item.add(nums[i]);
		}

  		for (int i = 0; i < sum; i++) {
  			result.add(item);
  			nextPermutation(nums);
		}
		return result;
		
	}
	
	public static void nextPermutation(int[] nums) {
		int len=nums.length,i = len-2;
		if (len<2) {
			return;
		}
		while(i>=0&&nums[i+1]<=nums[i])i--;
        if (i>=0) {
        	int j=i+1;
        	while(j<len&&nums[j]>nums[i])j++;
        	swap(nums,i,j-1);
		}
        reverse(nums,i+1,len-1);
    }

	private static void reverse(int[] nums, int i, int j) {
		// TODO 
		while(i<j){
			swap(nums, i, j);
			i++;
			j--;
		}
		
	}
	private static void swap(int[] nums, int i, int j) {
		// TODO 
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
