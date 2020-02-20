package com.code.leet;

/**
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class L0025ReverseNodesinkGroup {

	public static void main(String[] args) {
		// TODO 
		L0025ReverseNodesinkGroup reverseNodesinkGroup= new L0025ReverseNodesinkGroup();
		ListNode head = reverseNodesinkGroup.new ListNode(1);
		head.next = reverseNodesinkGroup.new ListNode(2);
		head.next.next = reverseNodesinkGroup.new ListNode(3);
		head.next.next.next = reverseNodesinkGroup.new ListNode(5);
		ListNode reverseKGroup = reverseNodesinkGroup.reverseKGroup(head, 3);
		while(reverseKGroup!=null){
			System.out.println(reverseKGroup.val);
			reverseKGroup=reverseKGroup.next;
		}
	}
	
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }

    public ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		int len = 0;
		while (start != null) {
			start = start.next;
			len++;
		}
		if (len < k) {
			return head;
		}
		ListNode r = new ListNode(0);
		int count = 0;
		start = head;
		while (start != null && count++ < k) {
			ListNode pre = start;
			start = start.next;

			pre.next = r.next;
			r.next = pre;
		}
		head.next = reverseKGroup(start, k);
    	return r.next;
    }

}
