package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 */
public class Offer06ReversePrint {
    public static void main(String[] args) {
        ListNode head = new Offer06ReversePrint().new ListNode(1);
        int[] r = new Offer06ReversePrint().reversePrint(head);
        System.out.println(r);
    }

    public int[] reversePrint(ListNode head) {
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        int[] r = new int[size];

        tmp = head;
        for (int i = size - 1; i >= 0; i--) {
            r[i] = tmp.val;
            tmp = tmp.next;
        }
        return r;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
