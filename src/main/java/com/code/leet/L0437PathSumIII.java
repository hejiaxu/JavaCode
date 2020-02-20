package com.code.leet;


/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf,
but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class L0437PathSumIII {

    public static void main(String[] args) {

        L0437PathSumIII l0437PathSumIII = new L0437PathSumIII();
        TreeNode tree = l0437PathSumIII.new TreeNode(1);
        tree.right = l0437PathSumIII.new TreeNode(4);
        tree.right.right = l0437PathSumIII.new TreeNode(3);
        int sum = 3;
        int i = l0437PathSumIII.pathSum(tree, sum);
        System.out.println(i);

    }

    public int pathSum(TreeNode root, int sum) {
        return dfs(root, sum, sum, true);
    }

    private int dfs(TreeNode root, int sum, int tmp, boolean r) {
        int num = 0;
        if (root == null) {
            return num;
        }
        if (tmp == root.val) {
            num++;
        }
        if (root.left != null) {
            num += dfs(root.left, sum, tmp - root.val, false);
            if (r) {
                num += dfs(root.left, sum, sum, true);
            }
        }

        if (root.right != null) {
            num += dfs(root.right, sum, tmp - root.val, false);
            if (r) {
                num += dfs(root.right, sum, sum, true);
            }
        }

        return num;
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
