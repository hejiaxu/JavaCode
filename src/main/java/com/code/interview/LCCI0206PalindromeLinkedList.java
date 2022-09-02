package com.code.interview;

import com.code.leet.ListNode;

/*
Implement a function to check if a linked list is a palindrome.

 

Example 1:

Input:  1->2
Output:  false
Example 2:

Input:  1->2->2->1
Output:  true
 

Follow up:
Could you do it in O(n) time and O(1) space?

 */
public class LCCI0206PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        boolean palindrome = new LCCI0206PalindromeLinkedList().isPalindrome(head);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        reverseWithPre(slow);
        while (slow.next != null) {
            if (head.val != slow.next.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    // 倒置的时候错误操作倒置了回环
    private void reverseWithPre(ListNode pre) {
        ListNode node = pre.next;
        pre.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre.next;
            pre.next = node;
            node = tmp;
        }
    }



    ListNode front = null;
    public boolean isPalindrome2(ListNode head) {
        front = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean dfs = dfs(head.next);
        if (!dfs) {
            return false;
        }
        if (head.val != front.val) {
            return false;
        }
        front = front.next;
        return true;
    }
}


