/**
 *
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class L0047PermutationsII {

    public static void main(String[] args) {
        // TODO
//		int []nums=new int[]{1,1,1,4};
        int[] nums = new int[]{-1, 2, 0, -1, 1, 0, 1};
        List<List<Integer>> result = new L0047PermutationsII().permuteUnique6(nums);
        int i = 0;
        for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
            List<Integer> list = (List<Integer>) iterator.next();
            for (Iterator iterator2 = list.iterator(); iterator2.hasNext(); ) {
                Integer integer = (Integer) iterator2.next();
                System.out.print(integer);
            }
            System.out.println(i);

            i++;
        }
        System.out.println(i);

    }

    //11ms

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteRecur(result, nums, 0);
        return result;
    }

    private void permuteRecur(List<List<Integer>> result, int[] nums, int i) {
        // TODO
        int len = nums.length;
        if (i == len - 1) {
            List<Integer> item = new LinkedList<>();
            for (int k = 0; k < len; k++) {
                item.add(nums[k]);
            }
            result.add(item);
            return;
        }
        Set<Integer> done = new HashSet<>();
        for (int l = i; l < len; l++) {
            if (!done.contains(nums[l])) {
                done.add(nums[l]);
                swap(nums, i, l);
                permuteRecur(result, nums, i + 1);
                swap(nums, i, l);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        // TODO
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //9ms
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    //12ms
    public List<List<Integer>> permuteUnique4(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int n = r.size();
            for (int j = 0; j < n; j++) {
                List<Integer> list = r.poll();
                for (int k = 0; k <= list.size(); k++) {
                    if (k > 0 && list.get(k - 1) == nums[i])
                        break;
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.offer(t);
                }
            }
        }
        return r;
    }

    public List<List<Integer>> permuteUnique6(int[] nums) {
        Arrays.sort(nums);

        return dfs(nums, 0);

    }

    private List<List<Integer>> dfs(int[] nums, int p) {
        List<List<Integer>> r = new LinkedList<>();
        if (p == nums.length) {
            List<Integer> integerList = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                integerList.add(nums[i]);
            }
            r.add(integerList);
            return r;
        }
        r.addAll(dfs(nums, p + 1));

        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[p]) {
                continue;
            }
            swap(nums, p, i);
            r.addAll(dfs(nums, p + 1));
            swap(nums, p, i);
        }

        return r;
    }

}
