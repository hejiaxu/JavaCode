package com.code.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.
 */
public class L0377CombinationSumIV {

    //amazing
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public int combinationSum4Orign(int[] nums, int target) {
        List <List <Integer>> lists = combinationSumRecur(nums, 0, target);

        return lists == null ? 0 : lists.size();
    }


    public List<List<Integer>> combinationSumRecur(int[] candidates, int pos, int target) {
        List<List<Integer>> r = new LinkedList<>();
        if (0 == target) {
            ArrayList <Integer> e = new ArrayList <>();
            r.add(e);
            return r;
        }

        if (pos >= candidates.length || target < candidates[pos]) {
            return null;
        }

        int candidate = candidates[pos];
        for (int i = 0; i * candidate <= target; i++) {
            List <List <Integer>> lists = combinationSumRecur(candidates, pos + 1, target - candidate * i);
            if ( lists != null ) {
                for (int j = 0; j < i; j++) {
                    List <List <Integer>> appendLists = new LinkedList <>();
                    for (int k = 0; k < lists.size(); k++) {
                        List <Integer> list =  lists.get(k);
                        for (int l = 0; l <= list.size(); l++) {
                            if (l > 0 && candidate == list.get(l - 1)) {
                                break;
                            }
                            ArrayList <Integer> integers = new ArrayList <>(list);
                            integers.add(l, candidate);
                            appendLists.add(integers);
                        }
                    }
                    lists = appendLists;
                }
                r.addAll(lists);
            }
        }

        return r;
    }

    public int combinationSum4ShortRecur(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4ShortRecur(nums, target - nums[i]);
            }
        }
        return res;
    }

    public int combinationSum42(int[] nums, int target) {
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num == i)
                    res[i] += 1;
                else
                    res[i] += res[i-num];
            }
        }
        return res[target];
    }


    public static void main(String[] args) {
        int[] nums = {1, 50};
        int target = 200;
        int i = new L0377CombinationSumIV().combinationSum42(nums, target);
        System.out.println(i);
//        List <List <Integer>> lists = new L0377CombinationSumIV().combinationSumRecur(nums, 0, target);
//        if ( lists == null ) {
//            return;
//        }
//        for (int j = 0; j < lists.size(); j++) {
//            List <Integer> list = lists.get(j);
//            for (int k = 0; k < list.size(); k++) {
//                Integer integer = list.get(k);
//                System.out.print(integer);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

    }
}
