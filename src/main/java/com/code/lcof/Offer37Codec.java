package com.code.lcof;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hejiaxu on 2021/2/19
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 */
public class Offer37Codec {
    public static void main(String[] args) {

        Offer37Codec cc = new Offer37Codec();
        Offer37Codec.TreeNode root = cc.new TreeNode(6);
        root.left = cc.new TreeNode(2);
        root.left.left = cc.new TreeNode(0);
        root.left.right = cc.new TreeNode(4);
        root.left.right.left = cc.new TreeNode(2);
        root.left.right.right = cc.new TreeNode(6);

        root.right = cc.new TreeNode(8);
        root.right.left = cc.new TreeNode(7);
        root.right.right = cc.new TreeNode(9);

        String[] split = "".split(",");


        TreeNode treeNode = cc.deserialize("[5,2,3,null,null,2,4,3,1]");
        String serialize = cc.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = cc.deserialize(serialize);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            if (poll == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        stringBuilder.insert(0, "[");
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    // "[5,2,3,null,null,2,4,3,1]"
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        String[] split = data.substring(1, data.length() - 1).split(",");
        String s = split[0];
        if (s == "null") {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(s));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (i < split.length && !"null".equals(split[i])) {
                treeNode.left = new TreeNode(Integer.valueOf(split[i]));
                queue.offer(treeNode.left);
            }
            i++;
            if (i < split.length && !"null".equals(split[i])) {
                treeNode.right = new TreeNode(Integer.valueOf(split[i]));
                queue.offer(treeNode.right);
            }
            i++;
        }

        return head;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
