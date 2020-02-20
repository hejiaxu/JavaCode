package com.code.leet;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty binary tree,
return the average value of the nodes on each level in the form of an array.


 */
public class L0637AverageofLevelsinBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Double> averageOfLevels(TreeNode root) {
            ArrayList<Double> r = new ArrayList <>();
            ArrayList<Integer> num = new ArrayList <>();
            bfs(root, 0, r, num);
            for (int i = 0; i < r.size(); i++) {
                r.set(i, r.get(i)/num.get(i));
            }
            return r;

        }

    void bfs(TreeNode root, int height, ArrayList<Double> r, ArrayList<Integer> num) {
        if (root == null) return;

        if (r.size() <= height) {
            r.add((double) root.val);
            num.add(1);
        } else {
            r.set(height, r.get(height) + root.val);
            num.set(height, num.get(height) + 1);
        }
        bfs(root.left, height + 1, r, num);
        bfs(root.right, height + 1, r, num);
    }
}
