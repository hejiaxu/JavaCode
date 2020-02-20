package com.code.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a non-empty array of integers, return the k most frequent elements.


 */
public class L0347TopKFrequentElements {

    class Node {
        int val;
        int num;
        int pos;
        Node(int val, int num, int pos) {
            this.val = val;
            this.num = num;
            this.pos = pos;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Node[] heap = new Node[len];
        int pos = initHeap(nums, heap);
        List<Integer> r = new LinkedList <>();
        for (int i = 0; i < k; i++) {
            Node top = getTop(heap, --pos);
            r.add(top.val);
        }

        return r;
    }

    private int initHeap(int[] nums, Node[] heap) {
        Map<Integer, Node> map = new HashMap <>();
        int pos = 0;
        for (int i :
                nums) {
            Node node = map.get(i);

            if (node != null) {
                node.num++;
                shiftDownTop(heap, node.pos);
            } else {
                node = new Node(i, 1, pos);
                heap[pos] = node;
                map.put(i, node);
                pos++;
            }
        }
        return pos;
    }

    private void shiftDownTop(Node[] heap, int pos) {
        int down = pos;
        while(down > 0) {
            if ( heap[(down - 1) / 2].num < heap[down].num) {
                swap(heap, down, (down - 1) / 2);
                down = (down - 1) / 2;
            } else {
                break;
            }
        }
    }

    Node getTop(Node[] heap, int pos) {
        swap(heap, pos, 0);
        shiftTopDown(heap, pos);
        return heap[pos];
    }

    private void shiftTopDown(Node[] heap, int len) {
        int top = 0;
        while (top < len) {
            int left = 2 * top + 1;
            int right = 2 * top + 2;
            int next = len;
            if (left >= len && right >= len) {
                break;
            } else if (left < len && right < len) {
                if (heap[left].num > heap[right].num) {
                    next = left;
                } else {
                    next = right;
                }
            } else if (right >= len) {
                next = left;
            } else {
                next = right;
            }
            if (heap[next].num > heap[top].num) {
                swap(heap, top, next);
            } else {
                break;
            }
            top = next;
        }
    }

    private void swap(Node[] heap, int pos, int next) {
        Node tmp = heap[pos];
        heap[pos] = heap[next];
        heap[next] = tmp;

        heap[pos].pos = pos;
        heap[next].pos = next;
    }

    public static void main(String[] args) {

        int[] nums = {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        int k = 6;
        List <Integer> integers = new L0347TopKFrequentElements().topKFrequent(nums, k);
        for (Integer i :
                integers) {
            System.out.print(i);
        }
        //[-3,1,4,3,-7,-8]
        //[-3,-4,4,0,1,9]
    }

}
