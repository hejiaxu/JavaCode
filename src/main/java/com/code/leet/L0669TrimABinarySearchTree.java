package com.code.leet;

/**
 * Created by hejiaxu on 2021/1/13
 */
public class L0669TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        return recursion(root, low, high);
    }

    private TreeNode recursion(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            TreeNode node = recursion(root.right, low, high);
            if (node == null) {
                root = null;
            } else {
                root.val = node.val;
                root.left = node.left;
                root.right = node.right;
            }
        } else if (root.val > high) {
            TreeNode node = recursion(root.left, low, high);
            if (node == null) {
                root = null;
            } else {
                root.val = node.val;
                root.left = node.left;
                root.right = node.right;
            }

        } else {
            root.left = recursion(root.left, low, high);
            root.right = recursion(root.right, low, high);
        }
        return root;
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
