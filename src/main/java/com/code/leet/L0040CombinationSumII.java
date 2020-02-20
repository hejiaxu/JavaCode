package com.code.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */
public class L0040CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target <= 0) {
            return new LinkedList <>();
        }
        Arrays.sort(candidates);
        HashSet<Integer> done = new HashSet <>();
        List <List <Integer>> lists = combinationSum2Recur(done, candidates, 0, target);
        return lists == null ? new LinkedList <>() : lists;

    }

    private List <List <Integer>> combinationSum2Recur(HashSet<Integer> done, int[] candidates, int pos, int target) {
        List <List <Integer>> r = new LinkedList <>();

        if (target == 0) {
            done.add(candidates[pos - 1]);
            r.add(new LinkedList <>());
            return r;
        }

        if (pos >= candidates.length || target < candidates[pos]) {
            return null;
        }

        int candidate = candidates[pos];
        if (pos != 0 && candidate != candidates[pos - 1]) {
            done.add(candidates[pos - 1]);
            done = new HashSet <>();
        }

        if (!done.contains(candidate)) {
            List <List <Integer>> lists = combinationSum2Recur(done, candidates, pos + 1, target - candidate);
            if ( lists != null ) {
                for (int i = 0; i < lists.size(); i++) {
                    List <Integer> list = lists.get(i);
                    list.add(0, candidate);
                }
                r.addAll(lists);
            }
        }

        List <List <Integer>> c = combinationSum2Recur(done, candidates, pos + 1, target);
        if ( c != null ) {
            r.addAll(c);
        }

        return r;
    }

    public List<List<Integer>> combinationSum2Hash(int[] candidates, int target) {
        Arrays.sort(candidates);
        int hash = 0;
        HashSet<Integer> done = new HashSet <>();
        List <List <Integer>> lists = combinationSum2Recur2(done, hash, candidates, 0, target);
        return lists == null ? new LinkedList <>() : lists;

    }
    private List <List <Integer>> combinationSum2Recur2(HashSet<Integer> done, int hash, int[] candidates, int pos, int target) {
        List <List <Integer>> r = new LinkedList <>();

        if (target == 0) {
            r.add(new LinkedList <>());
            return r;
        }

        if (pos >= candidates.length || target < candidates[pos]) {
            return null;
        }

        int candidate = candidates[pos];

        hash = (hash * 131) + candidate;
        if (!done.contains(hash)) {
            done.add(hash);
            List <List <Integer>> lists = combinationSum2Recur2(done, hash, candidates, pos + 1, target - candidate);
            if (lists != null) {
                for (int i = 0; i < lists.size(); i++) {
                    List <Integer> list = lists.get(i);
                    list.add(0, candidate);
                }
                r.addAll(lists);
            }
        }
        hash = (hash - candidate) / 131;

        List <List <Integer>> c = combinationSum2Recur2(done, hash, candidates, pos + 1, target);
        if ( c != null ) {
            r.addAll(c);
        }


        return r;
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 1, 4, 1, 2, 2};
        int target = 7;
        List <List <Integer>> lists = new L0040CombinationSumII().combinationSum2(candidates, target);
        if ( lists == null ) {
            return;
        }
        for (int i = 0; i < lists.size(); i++) {
            List <Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer integer = list.get(j);
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
