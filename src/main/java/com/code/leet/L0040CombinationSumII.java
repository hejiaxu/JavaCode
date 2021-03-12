package com.code.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
            return r;
        }

        int candidate = candidates[pos];
        if (pos != 0 && candidate != candidates[pos - 1]) {
            done.add(candidates[pos - 1]);
            done = new HashSet <>();
        }

        if (!done.contains(candidate)) {
            List <List <Integer>> lists = combinationSum2Recur(done, candidates, pos + 1, target - candidate);
            for (int i = 0; i < lists.size(); i++) {
                List <Integer> list = lists.get(i);
                list.add(0, candidate);
            }
            r.addAll(lists);
        }

        List <List <Integer>> c = combinationSum2Recur(done, candidates, pos + 1, target);
        r.addAll(c);

        return r;
    }

    public List<List<Integer>> combinationSum2Hash(int[] candidates, int target) {
        Arrays.sort(candidates);
        int hash = 0;
        HashSet<Integer> done = new HashSet <>();
        return combinationSum2Recur2(done, hash, candidates, 0, target);
    }

    private List <List <Integer>> combinationSum2Recur2(HashSet<Integer> done, int hash, int[] candidates, int pos, int target) {
        List <List <Integer>> r = new LinkedList <>();

        if (target == 0) {
            r.add(new LinkedList <>());
            return r;
        }

        if (pos >= candidates.length || target < candidates[pos]) {
            return r;
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
        r.addAll(c);


        return r;
    }

    // 1126ms
    public List<List<Integer>> combinationSum2Baoli(int[] candidates, int target) {

        Arrays.sort(candidates);
        return combinationSum2Rec(candidates, new boolean[candidates.length],0, target);
    }

    Set<String> set = new HashSet<>();

    private List<List<Integer>> combinationSum2Rec(int[] candidates, boolean[] used, int p, int target) {
        List<List<Integer>> r = new ArrayList<>();
        if (target < 0) {
            return r;
        } else if (target == 0) {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                if (used[i]) {
                    integerList.add(candidates[i]);
                }
            }
            r.add(integerList);
            return r;
        }

        if (p >= candidates.length) {
            return r;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p);
        for (int i = 0; i < p; i++) {
            if (used[i]) {
                stringBuilder.append("_");
                stringBuilder.append(candidates[i]);
            }
        }
        String pre = stringBuilder.toString();

        if (!set.contains(pre)) {
            set.add(pre);
            used[p] = true;
            int target1 = target - candidates[p];
            r.addAll(combinationSum2Rec(candidates, used, p + 1, target1));
            used[p] = false;
        }

        r.addAll(combinationSum2Rec(candidates, used, p + 1, target));

        return r;
    }


    public static void main(String[] args) {
//        int[] candidates = {1, 1, 1, 4, 1, 2, 2};
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {2,5,2,1,2};
        int target = 8;
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
