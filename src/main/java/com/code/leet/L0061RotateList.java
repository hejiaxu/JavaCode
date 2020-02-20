package com.code.leet;


/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
*/
public class L0061RotateList {
    public static void main(String[] args) {
        L0061RotateList l0061RotateList = new L0061RotateList();
        ListNode head = l0061RotateList.new ListNode(1);
        head.next = l0061RotateList.new ListNode(2);
        head.next.next = l0061RotateList.new ListNode(3);
        head.next.next.next = l0061RotateList.new ListNode(4);
        head.next.next.next.next = l0061RotateList.new ListNode(5);
        ListNode listNode = l0061RotateList.rotateRight(head, 0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        ListNode last = head;
        while (tmp != null) {
            len++;
            last = tmp;
            tmp = tmp.next;
        }
        last.next = head;

        k %= len;
        ListNode p = head;
        ListNode headLast = head;
        int i = 0;

        while (i + k < len) {
            i++;
            headLast = p;
            p = p.next;
        }
        headLast.next = null;
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
