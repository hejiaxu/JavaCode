package com.code.leet;

import java.util.HashMap;

/*
https://leetcode.com/problems/lru-cache/tabs/description
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1. put(key, value) - Set or insert the value if the key is not already present.
  When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.
 */
public class L0146LRUCache {
    int capacity;
    HashMap<Integer,Node> hashMap;
    Node head;
    Node tail;

    public L0146LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    private class Node {
        int val;
        int key;
        Node next;
        Node pre;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            cutNode(node);
            node2Tail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            cutNode(node);
            node2Tail(node);
            node.val = value;
        } else if (hashMap.size() == capacity) {
            Node node = head.next;
            hashMap.remove(node.key);
            hashMap.put(key, node);
            cutNode(node);
            node2Tail(node);
            node.val = value;
            node.key = key;
        } else {
            Node node = new Node(key, value);
            hashMap.put(key, node);
            node2Tail(node);
        }

    }

    private void node2Tail(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void cutNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        L0146LRUCache lruCache0146 = new L0146LRUCache(1);
        String[] opt = {"LRUCache","put","get"};
        String a = "[[[1],[2,1],[2]]";
        a = a.replace("]","");
        a = a.replace("[","");

        String [] b = a.split(",");
        int count = 0;
        for (String str:opt) {
            if (str.equals("put")) {
                int o1 = Integer.parseInt(b[count]);
                count++;
                int o2 = Integer.parseInt(b[count]);
                count++;

                lruCache0146.put(o1,o2);
                System.out.print("null,");
            } else {

                int o1 = Integer.parseInt(b[count]);
                count++;
                int r = lruCache0146.get(o1);
                if (r == 14) {
                    System.out.print(r);
                }
                System.out.print(r);
                System.out.print(",");
            }
        }
        System.out.println(a);
        System.out.println(b[1]);
        System.out.println("Hello World!");
    }
}
