package com.code.leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class L0023MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return msort(lists, 0, lists.length - 1);
    }

    private ListNode msort(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = (l + r) / 2;
        ListNode left = msort(lists, l, mid);
        ListNode right = msort(lists, mid + 1, r);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode r = new ListNode(0);
        ListNode last = r;
        while (left != null && right != null) {
            if (left.val < right.val) {
                last.next = left;
                last = last.next;
                left = left.next;
            } else {
                last.next = right;
                last = last.next;
                right = right.next;
            }
        }
        if (left != null) {
            last.next = left;
        }
        if (right != null) {
            last.next = right;
        }
        return r.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> set = new PriorityQueue<>(lists.length, new NodeComparator());
        ListNode r = null, tail = r;
        for (ListNode list : lists) {
            if (list != null) {
                set.offer(list);
            }
        }

        while (!set.isEmpty()) {
            ListNode tmp = set.poll();
            if (tmp.next != null) {
                set.add(tmp.next);
            }
            if (r == null) {
                r = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        return r;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class NodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            // TODO
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val < o2.val) {
                return -1;
            }
            return 0;
        }

    }
}
