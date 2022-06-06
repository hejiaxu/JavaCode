package com.code.lcof;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * */
public class Offer34PathSum {
    public static void main(String[] args) {
        TreeNode a = new Offer34PathSum().new TreeNode(0), b = new Offer34PathSum().new TreeNode(0);
        int i = 0;
        List<List<Integer>> r = new Offer34PathSum().pathSum(a, i);
        System.out.println(r);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> r = new LinkedList<>();
        dfs(root, r, new Stack<>(), sum);
        return r;
    }

    private void dfs(TreeNode root, List<List<Integer>> r, Stack<Integer> stack, int sum) {
        if (root == null) {
            return;
        }
        stack.push(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            r.add(new LinkedList<>(stack));
        }

        dfs(root.left, r, stack, sum - root.val);
        dfs(root.right, r, stack, sum - root.val);

        stack.pop();

        return;
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
// 递归，使用栈记录路径，到叶子new成list添加到结果中
// 通过计算总和剪枝