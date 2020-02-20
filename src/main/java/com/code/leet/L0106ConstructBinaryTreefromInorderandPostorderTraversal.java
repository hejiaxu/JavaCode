package com.code.leet;


/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class L0106ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecur(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeRecur(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int header = postorder[postEnd];
        TreeNode treeNode = new TreeNode(header);
        int inHeadPos = inEnd;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == header) {
                inHeadPos = i;
            }
        }
        if (inHeadPos > inStart) {
            treeNode.left = buildTreeRecur(inorder, inStart, inHeadPos - 1, postorder, postStart, postStart + inHeadPos - 1 -inStart);
        }
        if (inHeadPos < inEnd) {
            treeNode.right = buildTreeRecur(inorder, inHeadPos + 1, inEnd, postorder, postStart + inHeadPos - inStart, postEnd - 1);
        }
        return treeNode;
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
