package com.code.leet;

/*
Given a binary tree and a sum,
determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class L0112PathSum {
    public static void main(String[] args) {
        L0112PathSum l0112PathSum = new L0112PathSum();
        TreeNode root = l0112PathSum.new TreeNode(1);
        boolean b = l0112PathSum.hasPathSum(root, 1);
        System.out.println(b);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean r = false;
        if (root.left != null) {
            r = hasPathSum( root.left, sum - root.val);
        }
        if (!r && root.right != null) {
            r = hasPathSum( root.right, sum - root.val);
        }
        return r;
    }

    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
