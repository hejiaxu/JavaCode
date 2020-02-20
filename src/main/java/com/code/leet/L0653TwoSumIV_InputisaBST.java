package com.code.leet;

import java.util.Deque;
import java.util.LinkedList;

public class L0653TwoSumIV_InputisaBST {
    public static void main(String[] args) {

    }
    public boolean findTarget(TreeNode root, int k) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(root, deque);
        Integer first = deque.pollFirst();
        Integer last = deque.pollLast();
        while (first != null && last != null && first != last) {
            if (first + last == k) {
                return true;
            } else if (first + last < k) {
                first = deque.pollFirst();
            } else {
                last = deque.pollLast();
            }
        }
        return false;
    }

    private void dfs(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        dfs(root.left, deque);
        deque.offerLast(root.val);
        dfs(root.right, deque);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
