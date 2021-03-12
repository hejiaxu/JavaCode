package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Offer54KthLargest {
    public static void main(String[] args) {
        TreeNode a = new Offer54KthLargest().new TreeNode(3);
        TreeNode a1 = new Offer54KthLargest().new TreeNode(1);
        TreeNode a2 = new Offer54KthLargest().new TreeNode(4);
//        TreeNode a3 = new Offer54KthLargest().new TreeNode(0);
        TreeNode a4 = new Offer54KthLargest().new TreeNode(2);
        a.left = a1;
        a.right = a2;
        a1.right = a4;
        int r = new Offer54KthLargest().kthLargest(a, 1);
        System.out.println(r);
    }

    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
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
