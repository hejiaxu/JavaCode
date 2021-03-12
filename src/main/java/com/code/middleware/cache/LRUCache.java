package com.code.middleware.cache;

import java.util.HashMap;

/**
 * Created by hejiaxu on 2020/7/6
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity;

    Node head = new Node(0,0), tail = new Node(0, 0);
    {
        tail.next = head;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            if (node.next != null) {
                Node tmp = new Node(node.key, node.val);
                node.key = node.next.key;
                node.val = node.next.val;
                node.next = node.next.next;
                node = tmp;
            }
            tail.next.next = node;
            tail.next = node;
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.next != null) {
                Node tmp = new Node(node.key, node.val);
                node.key = node.next.key;
                node.val = node.next.val;
                node.next = node.next.next;
                node = tmp;
            }
            tail.next.next = node;
            tail.next = node;

        } else {
            Node next = new Node(key, value);
            map.put(key, next);
            tail.next.next = next;
            tail.next = next;

            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);
        int param_1 = obj.get(1);
        System.out.println(param_1);
        obj.put(1,2);
        param_1 = obj.get(1);
        System.out.println(param_1);
        obj.put(2,4);
        obj.put(3,4);
        obj.put(5,4);
        param_1 = obj.get(2);
        obj.put(6,4);

        System.out.println(param_1);
        param_1 = obj.get(2);
        System.out.println(param_1);
    }
    /**
     * 可以使用双向链表
     */
    public class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
