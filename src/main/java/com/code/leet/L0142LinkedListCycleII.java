package com.code.leet;

/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.

Note: Do not modify the linked list.
 */
public class L0142LinkedListCycleII {
    public static void main(String[] args) {
        L0142LinkedListCycleII l0142LinkedListCycleII = new L0142LinkedListCycleII();
        ListNode head = l0142LinkedListCycleII.new ListNode(1);
        head.next= l0142LinkedListCycleII.new ListNode(2);
        ListNode listNode = l0142LinkedListCycleII.detectCycle(head);
        System.out.println(listNode);
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null || fast != slow) {
            return null;
        }
        ListNode chaser = head;
        while (chaser != slow) {
            chaser = chaser.next;
            slow = slow.next;
        }
        return chaser;
    }


    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && ((slow != fast  && fast != head)|| slow == head)) {
            slow = slow.next;
            fast = fast.next;
            if (fast == head || fast == null) {
                break;
            }
            fast = fast.next;
        }

        if (fast != null) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return fast;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
