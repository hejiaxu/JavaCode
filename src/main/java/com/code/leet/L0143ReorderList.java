package com.code.leet;


import java.util.Stack;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class L0143ReorderList {

    public static void main(String[] args) {
        L0143ReorderList l0143ReorderList = new L0143ReorderList();
        ListNode head = l0143ReorderList.new ListNode(2);
        head.next = l0143ReorderList.new ListNode(1);
        head.next.next = l0143ReorderList.new ListNode(5);
        l0143ReorderList.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = head.next;
            head.next = pop;
            head = head.next;
            // when len is even, slow is more, so head can not go to the null or will miss the last one
            if (head.next != null) {
                head = head.next;
            }
        }

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
