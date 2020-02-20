package com.code.leet;

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class L0024SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = new ListNode(0);
        ListNode last = r;
        while (head != null && head.next != null) {
            ListNode pre = head;
            last.next = head.next;
            head = head.next.next;
            last.next.next = pre;
            last = last.next.next;
        }
        last.next = head;
        return r.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
