package com.code.leet;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*

Given two Queues Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These Queues A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 */
public class L0760FindAnagramMappings {
    public static void main(String[] args) {

        int[] A = {12, 50, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 50};
        int[] ints = new L0760FindAnagramMappings().anagramMappings(A, B);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }

    public int[] anagramMappings(int[] A, int[] B) {
        int length = A.length;
        int[] r = new int[length];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                Queue<Integer> integers = new LinkedList<>();
                integers.offer(i);
                map.put(B[i], integers);
            }
        }
        for (int i = 0; i < length; i++) {
            Queue<Integer> integers = map.get(A[i]);
            Integer poll = integers.poll();
            r[i] = poll;
        }
        return r;
    }

}
