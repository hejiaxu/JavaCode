package com.code.leet;

import java.util.HashMap;

/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 
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

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
// 通过map映射新老节点，然后遍历老节点指针，同时将map对应的节点赋值相同的指针。
