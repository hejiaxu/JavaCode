package com.code.leet;


import java.util.LinkedList;
import java.util.List;

/*
Given an integer n,
generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class L0095UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new LinkedList<>();
        if (n == 0) {
            return dp[n];
        }
        dp[0].add(null);
        dp[1] = new LinkedList<>();
        dp[1].add(new TreeNode(1));
        if (n > 1)
            for (int i = 2; i < dp.length; i++) {
                List<TreeNode> list = new LinkedList<>();
                for (int j = 0; j < i; j++) {
                    for (TreeNode l : dp[j]) {
                        for (TreeNode r : dp[i - j - 1]) {
                            TreeNode root = new TreeNode(j + 1);
                            root.left = l;
                            root.right = cloneTree(r, j + 1);
                            list.add(root);
                        }
                    }
                }
                dp[i] = list;
            }
        return dp[n];
    }

    private TreeNode cloneTree(TreeNode r, int j) {
        if (r == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(r.val + j);
        treeNode.left = cloneTree(r.left, j);
        treeNode.right = cloneTree(r.right, j);
        return treeNode;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
