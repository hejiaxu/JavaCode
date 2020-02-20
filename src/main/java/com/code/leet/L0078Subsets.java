package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class L0078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        return recur(nums, nums.length - 1);
    }

    public List<List<Integer>> recur(int[] nums, int p) {
        List<List<Integer>> r = new LinkedList<>();
        if (p == -1) {
            r.add(new LinkedList<>());
            return r;
        }
        List<List<Integer>> items = recur(nums, p - 1);
        for (List<Integer> item: items) {
            List<Integer> dupInteger = new LinkedList<>();
            for (Integer integer : item) {
                dupInteger.add(integer);
            }
            dupInteger.add(nums[p]);
            r.add(dupInteger);
        }
        r.addAll(items);
        return r;
    }

}
