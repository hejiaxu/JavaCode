package com.code.leet;

import java.util.List;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class L0019RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int count = 1;
        ListNode it = head;
        while (count < n && it != null) {
            count++;
            it = it.next;
        }
        if (it == null) {
            return head.next;
        }
        ListNode slow = head;
        while (it.next != null) {
            slow = slow.next;
            it = it.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
