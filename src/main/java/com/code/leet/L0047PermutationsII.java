/**
 * 
 */
package com.code.leet;

import java.util.*;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class L0047PermutationsII {

	public static void main(String[] args) {
		// TODO 
		int []nums=new int[]{1,1,1,4};
        List <List <Integer>> result = new L0047PermutationsII().permuteUnique(nums);
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	//11ms

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
		permuteRecur(result, nums,0);
		return result;
    }
	
	private void permuteRecur(List<List<Integer>> result, int[] nums, int i) {
		// TODO 
		int len = nums.length;
		if (i==len-1) {	
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
                permuteRecur(result, nums, i+1);
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
        if(nums == null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;  
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) {
                continue;
            }
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    //12ms
    public List<List<Integer>> permuteUnique4(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<Integer>());
        for(int i=0; i < nums.length; i++){
            int n = r.size();
            for(int j = 0; j < n; j++){
                List<Integer> list = r.poll();
                for(int k = 0; k <= list.size(); k++){
                    if(k > 0 && list.get(k - 1) == nums[i])
                        break;
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.offer(t);
                }
            }
        }
        return r;
    }

}
