package com.code.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:

The height of the tree is height and the number of rows m should be equal to height + 1.
The number of columns n should be equal to 2height+1 - 1.
Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
Continue this process until all the nodes in the tree have been placed.
Any empty cells should contain the empty string "".
Return the constructed matrix res.

 

Example 1:


Input: root = [1,2]
Output:
[["","1",""],
 ["2","",""]]
Example 2:


Input: root = [1,2,3,null,4]
Output:
[["","","","1","","",""],
 ["","2","","","","3",""],
 ["","","4","","","",""]]
 

Constraints:

The number of nodes in the tree is in the range [1, 210].
-99 <= Node.val <= 99
The depth of the tree will be in the range [1, 10].

 */
public class L0655PrintBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        List<List<String>> lists = new L0655PrintBinaryTree().printTree(treeNode);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
            }
            System.out.println();

        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        List<List<String>> r = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                strings.add("-");
            }
            r.add(strings);
        }
        dfs(root, r, height - 1, 0, (width - 1) / 2);

        return r;
    }

    private void dfs(TreeNode root, List<List<String>> list, int height, int r, int c) {
        if (root == null) {
            return;
        }
        list.get(r).set(c, String.valueOf(root.val));
        dfs(root.left, list, height, r + 1, c - (int) Math.pow(2, (height - r - 1)));
        dfs(root.right, list, height, r + 1, c + (int) Math.pow(2, (height - r - 1)));
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return l > r ? l + 1 : r + 1;
    }

}

// 计算 2^n,可以用1 << n
// 深度优先遍历和广度优先遍历都可以