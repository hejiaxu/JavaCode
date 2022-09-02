package com.code.leet;

/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
 */
public class L0654MaximumBinaryTree {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = new L0654MaximumBinaryTree().constructMaximumBinaryTree(nums);

    }

    // 1.遍历依次处理
    // 2.x如果大于root则往上挂，
    // 3.小于root则找到root右边第一个大于他的右节点，替换他的孩子，将x的左指针指向被替换的孩子
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = null;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            TreeNode t = new TreeNode(num);
            if (i == 0) {
                root = t;
            } else {
                if (num > root.val) {
                    t.left = root;
                    root = t;
                } else {
                    TreeNode last = root;
                    while (last.right != null && last.right.val > num) {
                        last = last.right;
                    }
                    t.left = last.right;
                    last.right = t;
                }
            }

        }

        return root;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        } else if (l > r) {
            return null;
        }

        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = dfs(nums, l, max - 1);
        node.right = dfs(nums, max + 1, r);
        return node;
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

