package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/*

Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class L0216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List <List <Integer>> lists = combinationSum3Recur(nums, 0, k, n);
        return lists == null ? new LinkedList <>() : lists;
    }

    private List <List <Integer>> combinationSum3Recur(int[] nums, int pos, int k, int n) {
        List <List <Integer>> r = new LinkedList<>();
        if (k == 0 && n == 0) {
            r.add(new LinkedList <>());
            return r;
        }

        if (pos >= nums.length || k <= 0 || n < nums[pos]) {
            return null;
        }

        List <List <Integer>> lists = combinationSum3Recur(nums, pos + 1, k - 1, n - nums[pos]);
        if (lists != null) {
            for (List<Integer> list : lists) {
                list.add(nums[pos]);
            }
            r.addAll(lists);
        }

        List <List <Integer>> exclude = combinationSum3Recur(nums, pos + 1, k, n);
        if (exclude != null) {
            r.addAll(exclude);
        }

        return r;
    }

    public static void main(String[] args) {
        List <List <Integer>> lists = new L0216CombinationSumIII().combinationSum3(3, 9);
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
