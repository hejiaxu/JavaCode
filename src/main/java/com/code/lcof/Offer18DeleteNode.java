package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 *
 */
public class Offer18DeleteNode {
    public static void main(String[] args) {
        ListNode head = new Offer18DeleteNode().new ListNode(7);
        int n = 7;
        ListNode r = new Offer18DeleteNode().deleteNode(head, n);
        System.out.println(r);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
// review
