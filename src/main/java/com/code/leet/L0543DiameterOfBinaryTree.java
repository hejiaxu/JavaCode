package com.code.leet;

import javafx.util.Pair;

public class L0543DiameterOfBinaryTree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    Integer dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer left = dfs(root.left);
        Integer right = dfs(root.right);
        if (left + right > max) max = left + right;
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {

    }
}

// 递归方案:1.递归计算高度 2.过当前节点的最长路程为左高度+右高度 3、大于当前最大长度则替换
