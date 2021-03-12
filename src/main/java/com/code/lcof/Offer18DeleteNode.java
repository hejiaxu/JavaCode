package com.code.lcof;

import com.code.leet.L0024SwapNodesinPairs;

/**
 * Created by hejiaxu on 2021/2/19
 *输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Offer18DeleteNode {
    public static void main(String[] args) {
        ListNode head = new Offer18DeleteNode().new ListNode(7);
        int n = 7;
        ListNode r = new Offer18DeleteNode().deleteNode(head, n);
        System.out.println(r);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
