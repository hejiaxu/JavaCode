package com.code.interview;


import com.code.leet.ListNode;

/*
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

Example:

Input: head = 3->5->8->5->10->2->1, x = 5
Output: 3->1->2->10->5->5->8

 */
public class LCCI0204PartitionList {

    public ListNode partition2(ListNode head, int x) {
        ListNode small = head, large = head;
        while(small != null && large != null) {
            while(large != null && (large == small || large.val >= x)) {
                large = large.next;
            }
            while(small != null && small != large && small.val < x) {
                small = small.next;
            }
            if (small != null && large != null) {
                int tmp = small.val;
                small.val = large.val;
                large.val = tmp;
            }
        }
        return head;
    }


    public ListNode partition(ListNode head, int x) {
        for (ListNode small = head, large = head; small != null && large != null;) {
            if (large.val >= x || large == small) {
                large = large.next;
            } else if (small.val < x) {
                small = small.next;
            } else {
                int tmp = small.val;
                small.val = large.val;
                large.val = tmp;
                small =small.next;
                large = large.next;
            }
        }

        return head;
    }
}
