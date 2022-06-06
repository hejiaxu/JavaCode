package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 *  
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 *  
 * <p>
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class Offer36TreeToDoublyList {
    public static void main(String[] args) {
        Node a = new Offer36TreeToDoublyList().new Node(4);
        Node b = new Offer36TreeToDoublyList().new Node(2);
        Node c = new Offer36TreeToDoublyList().new Node(5);
        Node d = new Offer36TreeToDoublyList().new Node(1);
        Node e = new Offer36TreeToDoublyList().new Node(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        Node r = new Offer36TreeToDoublyList().treeToDoublyList(a);
        System.out.println(r);
    }

    Node h = null, pre = null;

    public Node treeToDoublyList(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        pre.right = h;
        h.left = pre;
        return h;
    }

    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        dfs(head.left);

        if (h == null) {
            h = head;
        }
        if (pre != null) {
            pre.right = head;
        }
        head.left = pre;
        pre = head;
        dfs(head.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}

// 递归中序遍历，用全局pre记录前一个点，处理前一个点right，当前点的left
// 注意首个点处理。