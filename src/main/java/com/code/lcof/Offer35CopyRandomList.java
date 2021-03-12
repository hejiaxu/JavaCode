package com.code.lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hejiaxu on 2021/2/19
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 * <p>
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Offer35CopyRandomList {
    public static void main(String[] args) {
        Node a = new Offer35CopyRandomList().new Node(0);
        Node r = new Offer35CopyRandomList().copyRandomList(a);
        System.out.println(r);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> cache = new HashMap<>();
        Node nHead = new Node(head.val);
        cache.put(head, nHead);
        Node tmp = head, nTmp = nHead;
        while (tmp != null) {
            if (tmp.next != null) {
                if (cache.containsKey(tmp.next)) {
                    nTmp.next = cache.get(tmp.next);
                } else {
                    nTmp.next = new Node(tmp.next.val);
                    cache.put(tmp.next, nTmp.next);
                }
            }
            if (tmp.random != null) {
                if (cache.containsKey(tmp.random)) {
                    nTmp.random = cache.get(tmp.random);
                } else {
                    nTmp.random = new Node(tmp.random.val);
                    cache.put(tmp.random, nTmp.random);
                }
            }
            tmp = tmp.next;
            nTmp = nTmp.next;
        }

        return nHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
