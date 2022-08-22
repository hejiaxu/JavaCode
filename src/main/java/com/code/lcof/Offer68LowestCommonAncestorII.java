package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中
 *
 *
 */
public class Offer68LowestCommonAncestorII {
    // miss
    public static void main(String[] args) {

        TreeNode treeNode = new Offer68LowestCommonAncestorII().new TreeNode(1);
        treeNode.left = new Offer68LowestCommonAncestorII().new TreeNode(2);
        treeNode.right = new Offer68LowestCommonAncestorII().new TreeNode(3);
//        treeNode.left.left = new Offer68LowestCommonAncestorII().new TreeNode(6);
//        treeNode.left.right = new Offer68LowestCommonAncestorII().new TreeNode(2);
//        treeNode.right.left = new Offer68LowestCommonAncestorII().new TreeNode(0);
//        treeNode.right.right = new Offer68LowestCommonAncestorII().new TreeNode(8);
//        treeNode.left.right.left = new Offer68LowestCommonAncestorII().new TreeNode(7);
//        treeNode.left.right.right = new Offer68LowestCommonAncestorII().new TreeNode(4);
        TreeNode r = new Offer68LowestCommonAncestorII().lowestCommonAncestor(treeNode, treeNode.right, treeNode.left);
        System.out.println(r.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        dfs(root, p, q);

        return lca;
    }


    /**
     * 1.后序遍历，返回是否访问目标节点
     * 2.访问到目标节点则标记
     * 3.目前节点全部已标记(可能存在父子关系), 如果是父子关系，则当前节点是目标节点，子节点存在目标节点，则是结果，否则需要左右子节点分别访问到目标节点
     */
    boolean isVistedP = false, isVistedQ = false;
    TreeNode lca = null;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (isVistedP && isVistedQ || root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean r = left || right;
        if (root == p) {
            isVistedP = true;
            r = true;
        } else if (root == q) {
            isVistedQ = true;
            r = true;
        }
        if (isVistedP && isVistedQ && (((root == p || root == q) && (left || right)) || (left && right)) && lca == null) {
            lca = root;
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
