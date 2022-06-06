/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;

/**
 * Jiaxu
 * Nov 16, 2016
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * 
 */
public class L0300LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO 
		L0300LongestIncreasingSubsequence bean = new L0300LongestIncreasingSubsequence();
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
