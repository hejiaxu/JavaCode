package com.code.leet;

/*
Given a Binary Search Tree (BST),
convert it to a Greater Tree such that every key of the original BST is changed
to the original key plus sum of all keys greater than the original key in BST.
 */
public class L0538ConvertBSTtoGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    public int dfs(TreeNode root, int pre) {
        if (root == null) {
            return pre;
        }
        int val = dfs(root.right, pre);
        root.val += val;
        return dfs(root.left, root.val);
    }


}
