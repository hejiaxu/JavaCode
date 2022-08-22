package com.code.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 

Example 1:


Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 *
 */
public class L0382LinkedListRandomNode {

    ArrayList<Integer> list;
    Random random;
    public L0382LinkedListRandomNode(ListNode head) {
        list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }


    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }




    public int getRandom2(ListNode head) {
        int result = head.val, i = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            i++;
            if (random.nextInt(i) == 0) {
                result = node.val;
            }
        }
        return result;
    }


}
