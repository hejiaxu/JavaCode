package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer07BuildTree {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode r = new Offer07BuildTree().buildTree(preorder, inorder);
        System.out.println(r);
    }
    int preL = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inL = 0, inR = preorder.length - 1;


        return dfs(preorder, inorder, inL, inR);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int inL, int inR) {
        if (preL >= preorder.length || inL > inR) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preL]);

        int pos = inL;
        for (int i = inL + 1; i <= inR; i++) {
            if (preorder[preL] == inorder[i]) {
                pos = i;
            }
        }
        preL++;
        treeNode.left = dfs(preorder, inorder, inL, pos - 1);
        treeNode.right = dfs(preorder, inorder, pos + 1, inR);

        return treeNode;
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
