package com.code.lcof;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hejiaxu on 2021/2/19
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * */
public class Offer32LevelOrder {
    public static void main(String[] args) {
        TreeNode a = new Offer32LevelOrder().new TreeNode(0), b = new Offer32LevelOrder().new TreeNode(0);
        int[] r = new Offer32LevelOrder().levelOrder(a);
        System.out.println(r);
    }

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> r = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                r.add(treeNode.val);
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
        }

        return r.stream().mapToInt(Integer::intValue).toArray();
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
