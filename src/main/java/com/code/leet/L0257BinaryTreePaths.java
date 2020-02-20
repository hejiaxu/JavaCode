package com.code.leet;


import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class L0257BinaryTreePaths {

    public static void main(String[] args) {


    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(r, sb, root);
        return r;
    }

    private void dfs(List<String> r, StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        int length = sb.length();
        if (length != 0) {
            sb.append("->");
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            r.add(sb.toString());
        }
        if (root.left != null) {
            dfs(r, sb, root.left);
        }
        if (root.right != null) {
            dfs(r, sb, root.right);
        }
        sb.setLength(length);
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


