package com.code.leet;


/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class L0105ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) {
            return null;
        }
        int headVal = preorder[preStart];
        TreeNode head = new TreeNode(headVal);
        int inHeadPos = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == headVal) {
                inHeadPos = i;
                break;
            }
        }
        if (inHeadPos > inStart) {
            head.left = recur(preorder, preStart + 1, preStart + inHeadPos - inStart, inorder, inStart, inHeadPos - 1);
        }
        if (inHeadPos < inEnd) {
            head.right = recur(preorder, preStart + inHeadPos - inStart + 1, preEnd, inorder, inHeadPos + 1, inEnd);
        }
        return head;
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
