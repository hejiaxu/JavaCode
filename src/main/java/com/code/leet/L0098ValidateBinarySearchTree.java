package com.code.leet;

/**
 * Created by hejiaxu on 2021/1/8
 */
public class L0098ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {

        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursion(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (val >= max || val <= min) {
            return false;
        }
        return recursion(root.left, min, val) && recursion(root.right, val, max);
    }

}
