package com.code.leet;

import java.util.HashMap;

/*
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class L0138CopyListwithRandomPointer {
    public static void main(String[] args) {
        L0138CopyListwithRandomPointer l0138CopyListwithRandomPointer = new L0138CopyListwithRandomPointer();
        RandomListNode randomListNode1 = l0138CopyListwithRandomPointer.new RandomListNode(1);
        randomListNode1.next = l0138CopyListwithRandomPointer.new RandomListNode(2);
        randomListNode1.next.next = l0138CopyListwithRandomPointer.new RandomListNode(2);
        randomListNode1.next.next.next = l0138CopyListwithRandomPointer.new RandomListNode(2);
        RandomListNode randomListNode = l0138CopyListwithRandomPointer.copyRandomList(randomListNode1);

    }
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tmp = head;
        while (tmp != null) {
            map.put(tmp, new RandomListNode(head.label));
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            RandomListNode node = map.get(tmp);
            if (tmp.next != null) {
                node.next = map.get(tmp.next);
            }
            if (tmp.random != null) {
                node.random = map.get(tmp.random);
            }
            tmp = tmp.next;
        }

        return map.get(head);
    }
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
