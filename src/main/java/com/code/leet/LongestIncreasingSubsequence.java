/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;

/**
 * Jiaxu
 * Nov 16, 2016
 * 
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO 
		LongestIncreasingSubsequence bean = new LongestIncreasingSubsequence();
		int[]nums = new int[]{2,3,5,6,7,8,9,2,3,4,5,6,7,6,4432,4,3,2,1,4,5,66,77,77,88,6,4,432,2};
		int lengthOfLIS = bean.lengthOfLIS(nums);
		System.out.println(lengthOfLIS);
	}

	
	//39ms
	int length = 0;
	public int lengthOfLIS(int[] nums) {
		int[] llis = new int[nums.length];
		for (int i = 0; i < llis.length; i++) {
			llis[i] = lis(llis, nums, i);
			if (llis[i] > length) {
				length = llis[i];
			}
		}
		return length;
    }
	public int lis(int[] llis, int[] nums, int i) {
		int l = 1;
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i]) {
				if (llis[j] + 1 > l) {
					l = llis[j] + 1;
				}
			}
		}
		return l;
	}
	
	//4ms
    public int lengthOfLIS2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
                continue;
            }
            int last = list.get(list.size() - 1);
            if (nums[i] > last) {
                list.add(nums[i]);
            } else {
                int pos = find(list, nums[i]);
                list.set(pos, nums[i]);
            }
        }
        return list.size();
    }
    public int find(ArrayList<Integer> list, int val) {
        int start = 0, end = list.size() - 1;
        if (val < list.get(0))
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == val)
                return mid;
            if (list.get(mid) < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
	
}
