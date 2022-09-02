package com.code.interview;

import com.code.leet.ListNode;

/*
Implement an algorithm to find the kth to last element of a singly linked list. Return the value of the element.

Note: This problem is slightly different from the original one in the book.

Example:

Input:  1->2->3->4->5 和 k = 2
Output:  4
Note:

k is always valid.

 */
public class LCCI0202KthNodeFromEndOfList {
    public int kthToLast(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            if (tail == null) {
                return 0;
            }
            tail = tail.next;
        }

        while (tail.next != null) {
            tail = tail.next;
            head = head.next;
        }
        return head.val;
    }
}
