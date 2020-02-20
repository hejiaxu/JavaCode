package com.code.leet;

public class L0160IntersectionofTwoLinkedLists { 
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        return getIntersectionNode(headA, lenA, headB, lenB);

    }

    private ListNode getIntersectionNode(ListNode headA, int lenA, ListNode headB, int lenB) {
        if ( lenA < lenB ) return getIntersectionNode(headB, lenB, headA, lenA);
        int i = 0;
        while(i < lenA - lenB) {
            headA = headA.next;
            i++;
        }
        while (i < lenA) {
            if ( headA == headB ) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            i++;
        }
        return null;
    }

    private int length(ListNode headA) {
        int count = 0;
        while(headA != null) {
            count++;
            headA = headA.next;
        }
        return count;
    }
}
