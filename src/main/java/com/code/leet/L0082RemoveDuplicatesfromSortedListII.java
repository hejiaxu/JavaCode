package com.code.leet;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class L0082RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = new ListNode(0);
        ListNode prev = r;

        while (head != null) {
            ListNode p = head;
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            if (head.next == p) {
                prev.next = head;
                prev = prev.next;
            }
            head = p;
        }
        prev.next = null;
        return r.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
