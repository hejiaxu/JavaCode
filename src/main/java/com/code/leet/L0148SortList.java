package com.code.leet;


/*
Sort a linked list in O(n log n) time using constant space complexity.
 */
public class L0148SortList {

    public static void main(String[] args) {
        L0148SortList l0148SortList = new L0148SortList();
        ListNode head = l0148SortList.new ListNode(2);
        head.next = l0148SortList.new ListNode(1);
        ListNode listNode = l0148SortList.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode pre = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (left != null && right != null) {
                if (left.val < right.val) {
                    pre.next = left;
                    left = left.next;
                } else {
                    pre.next = right;
                    right = right.next;
                }
                pre = pre.next;

        }
        if (left != null) {
            pre.next = left;
        }
        if (right != null) {
            pre.next = right;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
