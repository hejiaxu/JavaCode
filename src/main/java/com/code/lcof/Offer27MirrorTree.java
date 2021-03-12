package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * */
public class Offer27MirrorTree {
    public static void main(String[] args) {
        TreeNode a = new Offer27MirrorTree().new TreeNode(0), b = new Offer27MirrorTree().new TreeNode(0);
        TreeNode r = new Offer27MirrorTree().mirrorTree(a);
        System.out.println(r);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode r = new TreeNode(root.val);
        r.left = mirrorTree(root.right);
        r.right = mirrorTree(root.left);

        return r;
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
