package com.code.leet;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */
public class L0021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        ListNode last = r;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                last.next = l2;
                last = last.next;
                l2 = l2.next;
            } else {
                last.next = l1;
                last = last.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            last.next = l1;
        }
        if (l2 != null) {
            last.next = l2;
        }
        return r.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
