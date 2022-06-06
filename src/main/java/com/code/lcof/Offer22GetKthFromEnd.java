package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 */
public class Offer22GetKthFromEnd {
    public static void main(String[] args) {
        ListNode head = new Offer22GetKthFromEnd().new ListNode(7);
        int n = 7;
        ListNode r = new Offer22GetKthFromEnd().getKthFromEnd(head, n);
        System.out.println(r);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp = head, tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return null;
            }
            tail = tail.next;
        }
        while (tail != null) {
            tail = tail.next;
            tmp = tmp.next;
        }
        return tmp;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

// 选一个前节点往前走，选一个后节点晚k步跟进。
// 注意节点不够k个情况