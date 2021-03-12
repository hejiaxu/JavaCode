package com.code.leet;

/**
 * Created by hejiaxu on 2021/1/13
 */
public class L0700SearchInABinarySearchTree {


    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }
            if (root.val < val) {
                return searchBST(root.right, val);
            }
            return searchBST(root.left, val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
