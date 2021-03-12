package com.code.lcof;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Created by hejiaxu on 2021/2/19
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *

 *
 * */
public class Offer32LevelOrderIII {
    public static void main(String[] args) {
        TreeNode a = new Offer32LevelOrderIII().new TreeNode(0), b = new Offer32LevelOrderIII().new TreeNode(0);
        List<List<Integer>> r = new Offer32LevelOrderIII().levelOrder(a);
        System.out.println(r);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);
        int level = -1;
        List<List<Integer>> r = new LinkedList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            if (p.getKey() != null) {
                if (p.getValue() > level) {
                    curList = new LinkedList<>();
                    r.add(curList);
                    level++;
                }
                if (level % 2 == 0) {
                    curList.add(p.getKey().val);
                } else {
                    curList.addFirst(p.getKey().val);
                }
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
