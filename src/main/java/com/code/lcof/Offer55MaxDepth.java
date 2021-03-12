package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 */
public class Offer55MaxDepth {
    public static void main(String[] args) {
        TreeNode a = new Offer55MaxDepth().new TreeNode(3);
        TreeNode a1 = new Offer55MaxDepth().new TreeNode(1);
        TreeNode a2 = new Offer55MaxDepth().new TreeNode(4);
//        TreeNode a3 = new Offer54KthLargest().new TreeNode(0);
        TreeNode a4 = new Offer55MaxDepth().new TreeNode(2);
        a.left = a1;
        a.right = a2;
        a1.right = a4;
        boolean r = new Offer55MaxDepth().isBalanced(a);
        System.out.println(r);
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balance;
    }

    boolean balance = true;
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left - right > 1 || right - left > 1) {
            balance = false;
        }
        return left > right ? left + 1 : right + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
