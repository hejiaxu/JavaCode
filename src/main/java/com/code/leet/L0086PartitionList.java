package com.code.leet;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class L0086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallLast = small;
        ListNode big = new ListNode(0);
        ListNode bigLast = big;
        while (head != null) {
            if (head.val < x) {
                smallLast.next = head;
                smallLast = smallLast.next;
            } else {
                bigLast.next = head;
                bigLast = bigLast.next;
            }
            head = head.next;
        }
        smallLast.next = big.next;
        bigLast.next = null;
        return small.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
