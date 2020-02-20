package com.code.leet;

/*
Reverse a singly linked list.
 */
public class L0206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode r = new ListNode(0);
        while (head != null) {
            ListNode pre = head;
            head = head.next;
            pre.next = r.next;
            r.next = pre;
        }
        return r.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
