package com.code.leet;

import java.util.ArrayList;
import java.util.List;

/*
You need to find the largest value in each row of a binary tree.


 */
public class L0515FindLargestValueinEachTreeRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> r = new ArrayList <>();
        bfs(root, 0, r);
        return r;

    }

    void bfs(TreeNode root, int height, ArrayList<Integer> r) {
        if (root == null) return;
        if (r.size() <= height) {
            r.add(root.val);
        } else {
            r.set(height, r.get(height) > root.val ? r.get(height) : root.val);
        }
        bfs(root.left, height + 1, r);
        bfs(root.right, height + 1, r);
    }
}
