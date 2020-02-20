/**
 * 
 */
package com.code.leet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */

public class L0077Combinations {

	public static void main(String[] args) {
		// TODO 
		List<List<Integer>> combine = new L0077Combinations().combine(4, 2);
		for (Iterator iterator = combine.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
    //12ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList();
        if (n < k || k == 0) return ans;

        ans = combine(n-1, k-1);
        //if at this point ans is empty, it can only be that k-1 == 0,
        //n-1<k-1 is not possible since n>=k (if n<k, the function would have already returned at an early point)
        if (ans.isEmpty()) {
            ans.add(new LinkedList<Integer>());
        }
        for (List<Integer> list:ans) {
            list.add(n);
        }

        ans.addAll(combine(n-1, k));
        return ans;
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new LinkedList();
        if (k == 0) {
            ans.add(new LinkedList<Integer>());
            return ans;
        }
        if (n < k) return ans;
        ans = combine(n-1, k-1);
        for (List<Integer> list:ans) {
            list.add(n);
        }
        ans.addAll(combine(n-1, k));
        return ans;
    }
}
