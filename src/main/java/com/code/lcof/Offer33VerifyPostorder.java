package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 */
public class Offer33VerifyPostorder {
    public static void main(String[] args) {
//        int[] a = new int[]{1, 6, 3, 2, 5};
        int[] a = new int[]{1, 3, 2, 6, 5};
        boolean r = new Offer33VerifyPostorder().verifyPostorder(a);
        System.out.println(r);
    }

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }

        int pos = l;
        while (pos < r) {
            if (postorder[pos] >= postorder[r]) {
                break;
            }
            pos++;
        }
        int tmp = pos;
        while (tmp < r) {
            if (postorder[tmp] < postorder[r]) {
                return false;
            }
            tmp++;
        }

        return dfs(postorder, l, pos - 1) && dfs(postorder, pos, r - 1);
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
