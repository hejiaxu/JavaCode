/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Mar 29, 2017
 * 
 */


public class PalindromeLinkedList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			// TODO
			this.val = val;
		}
	}
	//2 ms
	public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head, newHead = null;
        while(fast!=null&&slow!=null){
        	fast=fast.next;
        	if (fast!=null) {
				fast=fast.next;
			}
        	slow=slow.next;
        }
        newHead = reverseList(slow);
		
        while(newHead!=null){
        	if (newHead.val!=head.val) {
				return false;
			}
        	newHead=newHead.next;
        	head= head.next;
        }
		return true;
    }
	
	public ListNode reverseList(ListNode head){
		ListNode next = head,newHead = null,tmp=null;
		while(next!=null){
			tmp = next.next;
			next.next=newHead;
			newHead = next;
			next = tmp;
		}
		return newHead;
	}
}
