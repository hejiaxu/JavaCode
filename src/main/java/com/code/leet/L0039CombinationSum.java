package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,

 */

public class L0039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumRecur(candidates, 0, target);
    }

    public List<List<Integer>> combinationSumRecur(int[] candidates, int pos, int target) {
        List<List<Integer>> r = new LinkedList <>();
        if (0 == target) {
            LinkedList <Integer> e = new LinkedList <>();
            r.add(e);
            return r;
        }

        if (pos >= candidates.length) {
            return null;
        }

        for (int i = 0; i * candidates[pos] <= target; i++) {
            List <List <Integer>> lists = combinationSumRecur(candidates, pos + 1, target - candidates[pos] * i);
            if ( lists != null ) {
                for (List <Integer> list: lists){
                    for (int j = 0; j < i; j++) {
                        list.add(0, candidates[pos]);
                    }
                }
                r.addAll(lists);
            }
        }

        return r;
    }
    public List<List<Integer>> combinationSum5(int[] candidates, int target) {

        List<List<Integer>> r = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        combinationSum(candidates, target, 0, list, r);
        return r;

    }

    private void combinationSum(int[] candidates, int target, int p, List<Integer> list, List<List<Integer>> r) {
        if (target < 0) return;
        if (target == 0) {
            if (list.size() > 0) {
                r.add(new ArrayList<>(list));
                return;
            }
        }
        LinkedList<Integer> integers = new LinkedList<>(list);
        integers.add(candidates[p]);
        combinationSum(candidates, target - candidates[p], p, integers, r);
        if (p < candidates.length - 1) {
            combinationSum(candidates, target, p + 1, list, r);
        }

    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 3, 4, 3};
        int[] nums = {4, 2, 1};
//        int[] nums = {1, 3, 5, 6, 3, 3, 2, 1, 7, 4, 4};
        int target = 32;
        List <List <Integer>> lists = new L0039CombinationSum().combinationSum5(nums, target);
        for (int i = 0; i < lists.size(); i++) {
            List <Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer integer = list.get(j);
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(lists.size());

    }
}
