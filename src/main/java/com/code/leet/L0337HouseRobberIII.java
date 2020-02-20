package com.code.leet;

public class L0337HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            rob(root.left);
        }
        if (root.right != null) {
            rob(root.right);
        }

        int childMax = 0;
        int grandMax = root.val;
        if (root.left != null) {
            childMax += root.left.val;
            if (root.left.left != null) {
                grandMax += root.left.left.val;

            }
            if (root.left.right != null) {
                grandMax += root.left.right.val;
            }
        }
        if (root.right != null) {
            childMax += root.right.val;
            if (root.right.left != null) {
                grandMax += root.right.left.val;

            }
            if (root.right.right != null) {
                grandMax += root.right.right.val;
            }
        }

        root.val = childMax > grandMax ? childMax : grandMax;

       return root.val;
    }

}
