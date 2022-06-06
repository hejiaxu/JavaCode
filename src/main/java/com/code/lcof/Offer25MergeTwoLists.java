package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer25MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new Offer25MergeTwoLists().new ListNode(7);
        ListNode l2 = new Offer25MergeTwoLists().new ListNode(7);
        ListNode r = new Offer25MergeTwoLists().mergeTwoLists(l1, l2);
        System.out.println(r);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0), tail = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (pre.next == null) {
                    pre.next = l2;
                } else {
                    tail.next = l2;
                }
                break;
            } else if (l2 == null) {
                if (pre.next == null) {
                    pre.next = l1;
                } else {
                    tail.next = l1;
                }
                break;
            } else {
                if (l1.val <= l2.val) {
                    if (pre.next == null) {
                        pre.next = l1;
                        tail = l1;
                    } else {
                        tail.next = l1;
                        tail = l1;
                    }
                    l1 = l1.next;
                } else {
                    if (pre.next == null) {
                        pre.next = l2;
                        tail = l2;
                    } else {
                        tail.next = l2;
                        tail = l2;
                    }
                    l2 = l2.next;
                }
            }
        }

        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
// 新起一个链表尾追加,循环追加
// 当某个链表为空或者处理完
