package com.code.leet;

public class L0235LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        return lowestCommonAncestor(root.val < p.val ? root.left : root.right, p, q);
    }
}
