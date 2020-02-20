package com.code.leet;


import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class L0113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> r = new LinkedList<>();
        if (root == null) {
            return r;
        }
        List<Integer> list = new LinkedList<>();
        dfs(r, list, root, sum);
        return r;
    }

    private void dfs(List<List<Integer>> r, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int len = list.size();
        Integer val = root.val;
        list.add(val);
        if (root.left == null && root.right == null && sum == root.val) {
            List<Integer> listr = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                listr.add(list.get(i));
            }
            r.add(listr);
        }
        if (root.left != null) {
            dfs(r, list, root.left, sum - root.val);
        }
        if (root.right != null) {
            dfs(r, list, root.right, sum - root.val);
        }
        list.remove(len);
    }

    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
