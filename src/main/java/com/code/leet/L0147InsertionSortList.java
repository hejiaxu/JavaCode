package com.code.leet;

/*
Sort a linked list using insertion sort.
 */
public class L0147InsertionSortList {

    public static void main(String[] args) {
        L0147InsertionSortList l0147InsertionSortList = new L0147InsertionSortList();
        ListNode head = l0147InsertionSortList.new ListNode(2);
        head.next = l0147InsertionSortList.new ListNode(1);
        head.next.next = l0147InsertionSortList.new ListNode(3);
        head.next.next.next = l0147InsertionSortList.new ListNode(1);
        ListNode listNode = l0147InsertionSortList.insertionSortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = new ListNode(0);
        while (head != null) {
            ListNode p = r;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode nextHead = head.next;
            head.next = p.next;
            p.next = head;
            head = nextHead;
        }
        return r.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
