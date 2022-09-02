package com.code.interview;

import com.code.leet.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
Write code to remove duplicates from an unsorted linked list.

Example1:

 Input: [1, 2, 3, 3, 2, 1]
 Output: [1, 2, 3]
Example2:

 Input: [1, 1, 1, 1, 2]
 Output: [1, 2]
Note:

The length of the list is within the range[0, 20000].
The values of the list elements are within the range [0, 20000].
Follow Up:

How would you solve this problem if a temporary buffer is not allowed?

 */
public class LCCI0201RemoveDuplicateNode {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head, pre = head;
        while (node != null) {
            if (set.contains(node.val)) {
                pre.next = node.next;
            } else {
                pre = node;
                set.add(node.val);
            }
            node = node .next;
        }
        return head;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode cur = node;
            while (cur.next != null) {
                if (cur.next.val == node.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            node = node.next;
        }
        return head;
    }

}
