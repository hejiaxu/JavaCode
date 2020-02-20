package com.code.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of integers that might contain duplicates,
nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class L0090SubsetsII {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return recur(nums, nums.length - 1);
    }

    private List<List<Integer>> recur(int[] nums, int i) {
        List<List<Integer>> r = new LinkedList<>();
        if (i == -1) {
            r.add(new LinkedList<>());
            return r;
        }
        int count = 1;
        while (i - count >= 0 && nums[i - count] == nums[i]) {
            count++;
        }
        List<List<Integer>> items = recur(nums, i - count);

        while (count > 0) {
            for (List<Integer> integers : items) {
                List<Integer> dupIntegers = new LinkedList<>();
                for (Integer integer : integers) {
                    dupIntegers.add(integer);
                }
                for (int j = 0; j < count; j++) {
                    dupIntegers.add(nums[i]);
                }
                r.add(dupIntegers);
            }
            count--;
        }
        r.addAll(items);
        return r;
    }
}
