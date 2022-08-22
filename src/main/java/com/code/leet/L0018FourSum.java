/**
 * 
 */
package com.code.leet;

import java.util.*;

/**
 * Jiaxu
 * Jun 21, 2017
 * 
 */
public class L0018FourSum {

	public static void main(String[] args) {
		// TODO 
		int []nums = {1,0,-1,0,-2,2};
		List<List<Integer>> fourSum = fourSum(nums, 0);
		for (List<Integer> list : fourSum) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	//TLE
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	ArrayList<List<Integer>> combine = combine(nums,target,0,4);
    	ArrayList<List<Integer>> dup = new ArrayList<>();
		for (int i = 0; i < combine.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>)combine.get(i);
			boolean exist = false;
			for (int j = i+1; j < combine.size(); j++) {
				ArrayList<Integer> item2 = (ArrayList<Integer>)combine.get(j);
				if (check(item, item2)) {
					exist=true;
					break;
				}
			}
			if (!exist) {
				dup.add(item);
			}
		}
		return dup;
        
    }
    
    
    private static boolean check(ArrayList<Integer> list, ArrayList<Integer> list2) {
		// TODO 
    	HashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (Integer integer : list) {
			if (map.containsKey(integer)) {
				map.put(integer,map.get(integer)+1);
			}else{
				map.put(integer,1);
			}
		}
		for (Integer integer : list2) {
			if (map.containsKey(integer)) {
				map.put(integer,map.get(integer)-1);
			}else{
				return false;
			}
		}
		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			if(map.get(integer)!=0)return false;
		}
		return true;

	}
	static ArrayList<List<Integer>> combine(int nums[],int target,int pos,int k){
    	ArrayList<List<Integer>> r = new ArrayList<>();
    	if (k==0||pos==nums.length||(target>0&&target<nums[pos])) { 
			return r;
		}
    	ArrayList<List<Integer>> combine = combine(nums,target-nums[pos],pos+1,k-1);
    	if (combine.isEmpty()&&target-nums[pos]==0&&k==1)combine.add(new ArrayList<Integer>());
    	for (List<Integer> list : combine) {
			list.add(nums[pos]);
		}
    	ArrayList<List<Integer>> combine2 = combine(nums,target,pos+1,k);
    	combine.addAll(combine2);
		return combine;
    }
	
	//36ms
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
}
