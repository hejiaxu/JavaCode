/**
 *
 */
package com.code.leet;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 */

public class L0234PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            // TODO
            this.val = val;
        }
    }

    //2 ms
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
		while (fast != null && slow != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
		ListNode newHead = reverseList(slow);

        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode next = head, newHead = null, tmp;
        while (next != null) {
            tmp = next.next;
            next.next = newHead;
            newHead = next;
            next = tmp;
        }
        return newHead;
    }

    // 把当前节点的下一个变成头结点，直到遍历到结尾。
    public ListNode reverseList2(ListNode head) {
        ListNode pos = head, tmp;
        while (pos != null && pos.next != null) {
            tmp = pos.next;
            pos.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

}
// 通过快慢指针找到中点，注意偶数则取左边的点，将中点以后的倒置后和中点以前的比较。
