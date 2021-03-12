package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 */
public class Offer24ReverseList {
    public static void main(String[] args) {
        ListNode head = new Offer24ReverseList().new ListNode(7);
        ListNode r = new Offer24ReverseList().reverseList(head);
        System.out.println(r);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0), left, pos = head;

        while (pos != null) {
            left = pos.next;
            pos.next = pre.next;
            pre.next = pos;
            pos = left;
        }

        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
