package com.code.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

 */
public class L0652FindDuplicateSubtrees {
    public static void main(String[] args) {
        L0652FindDuplicateSubtrees l0652FindDuplicateSubtrees = new L0652FindDuplicateSubtrees();
        TreeNode root = l0652FindDuplicateSubtrees.new TreeNode(0);
        root.left = l0652FindDuplicateSubtrees.new TreeNode(0);
        root.left.left = l0652FindDuplicateSubtrees.new TreeNode(0);
        root.right = l0652FindDuplicateSubtrees.new TreeNode(0);
        root.right.right= l0652FindDuplicateSubtrees.new TreeNode(0);
        List<TreeNode> duplicateSubtrees = l0652FindDuplicateSubtrees.findDuplicateSubtrees(root);
        for (TreeNode treeNode: duplicateSubtrees) {
                System.out.println(treeNode.val);
        }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> r = new LinkedList<>();
        dfs(root, map);
        for (List<TreeNode> val: map.values()) {
            if (val.size() > 1) {
                r.add(val.get(0));
            }
        }
        return r;
    }

    private String dfs(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) {
            return null;
        }
        //can not be inorder, the symmetric struct may result the same
        String key =  root.val + dfs(root.left, map) + dfs(root.right, map);
        List<TreeNode> orDefault = map.getOrDefault(key, new LinkedList<>());
        orDefault.add(root);
        map.put(key, orDefault);
        return key;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
