package com.code.leet;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class L0501FindModeinBinarySearchTree {
    public static void main(String[] args) {
        L0501FindModeinBinarySearchTree cc = new L0501FindModeinBinarySearchTree();
        TreeNode root = cc.new TreeNode(6);
        root.left = cc.new TreeNode(2);
        root.left.left = cc.new TreeNode(0);
        root.left.right = cc.new TreeNode(4);
        root.left.right.left = cc.new TreeNode(2);
        root.left.right.right = cc.new TreeNode(6);

        root.right = cc.new TreeNode(8);
        root.right.left = cc.new TreeNode(7);
        root.right.right = cc.new TreeNode(9);
        int[] mode = cc.findMode(root);
        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }


    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        if (cLen > maxLen) {
            count = 1;
            maxLen = cLen;
        } else if (maxLen != 0 && cLen == maxLen) {
            count++;
        }
        int[] r = new int[count];
        cLen = 0;
        cNum = null;
        findR(root, r);
        if (maxLen != 0 && cLen == maxLen) {
            r[0] = cNum;
        }
        return r;
    }

    int maxLen = 0;
    int cLen = 0;
    int count = 0;
    Integer cNum = null;

    void findR(TreeNode root, int[] r) {
        if (root == null) {
            return;
        }
        findR(root.left, r);
        if (cNum != null && cNum.equals(root.val)) {
            cLen++;
        } else {
            if (cLen == maxLen) {
                r[--count] = cNum;
            }
            cNum = root.val;
            cLen = 1;
        }
        findR(root.right, r);
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (cNum != null && cNum.equals(root.val)) {
            cLen++;
        } else {
            if (maxLen != 0 && cLen == maxLen) {
                count++;
            } else if (cLen > maxLen) {
                maxLen = cLen;
                count = 1;
            }
            cNum = root.val;
            cLen = 1;
        }
        dfs(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
