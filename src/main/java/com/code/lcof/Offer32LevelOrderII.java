package com.code.lcof;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Created by hejiaxu on 2021/2/19
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 *
 * */
public class Offer32LevelOrderII {
    public static void main(String[] args) {
        TreeNode a = new Offer32LevelOrderII().new TreeNode(0), b = new Offer32LevelOrderII().new TreeNode(0);
        List<List<Integer>> r = new Offer32LevelOrderII().levelOrder(a);
        System.out.println(r);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);
        int level = -1;
        List<List<Integer>> r = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            if (p.getKey() != null) {
                if (p.getValue() > level) {
                    curList = new LinkedList<>();
                    r.add(curList);
                    level++;
                }
                curList.add(p.getKey().val);
                queue.offer(new Pair<>(p.getKey().left, p.getValue() + 1));
                queue.offer(new Pair<>(p.getKey().right, p.getValue() + 1));
            }
        }

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
