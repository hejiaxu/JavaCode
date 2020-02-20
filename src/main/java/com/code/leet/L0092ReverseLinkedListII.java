package com.code.leet;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class L0092ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = new ListNode(0);
        ListNode left = head;
        int p = 1;
        ListNode pre = r;
        while (left != null && p < m) {
            p++;

            pre.next = left;
            pre = left;
            left = left.next;
        }
        ListNode last = left;
        while (left != null && p <= n) {
            p++;
            ListNode tmp = left;
            left = left.next;
            tmp.next = pre.next;
            pre.next = tmp;
            last.next = left;
        }
        return r.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
