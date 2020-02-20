package com.code.leet;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
You need to construct a string consists of parenthesis
and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()".
And you need to omit all the empty parenthesis pairs
that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 */
public class L0606ConstructStringfromBinaryTree {
    public static void main(String[] args) {

    }

    public String tree2str2(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack< >();
        stack.push(t);
        Set< TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

    public String tree2str(TreeNode t) {
        StringBuilder r = new StringBuilder();
        dfs(t, r);
        return r.toString();
    }

    private void dfs(TreeNode t, StringBuilder r) {

        if (t != null) {
            r.append(t.val);
            if (t.left != null || t.right != null) {
                r.append('(');
                dfs(t.left, r);
                r.append(')');
            }
            if (t.right != null) {
                r.append('(');
                dfs(t.right, r);
                r.append(')');
            }
        }
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
