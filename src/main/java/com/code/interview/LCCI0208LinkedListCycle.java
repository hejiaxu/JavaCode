package com.code.interview;

import com.code.leet.ListNode;

/*
Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Example 3:

Input: head = [1], pos = -1
Output: no cycle
Follow Up:
Can you solve it without using additional space?

 */
public class LCCI0208LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (fast == slow) {
                break;
            }
        }

        if (fast != slow) {
            return null;
        }

        while (fast != head) {
            fast = fast.next;
            head = head.next;
        }

        return head;
    }
}
