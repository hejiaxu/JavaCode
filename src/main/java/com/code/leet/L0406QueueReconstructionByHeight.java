package com.code.leet;

import java.util.Arrays;

/*
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

 

Example 1:

Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
Example 2:

Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 

Constraints:

1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
It is guaranteed that the queue can be reconstructed.

 */
public class L0406QueueReconstructionByHeight {
    //Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
    //Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = people.length - 1; i >= 0; i--) {
            int pos = people[i][1];
            for (int j = i; j < i + pos; j++) {
                swap(people, j, j + 1);
            }
        }
        return people;
    }

    private void swap(int[][] people, int i, int j) {
        int k = people[i][0], v = people[i][1];
        people[i][0] = people[j][0];
        people[i][1] = people[j][1];
        people[j][0] = k;
        people[j][1] = v;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};

        new L0406QueueReconstructionByHeight().reconstructQueue(p);
        System.out.println();
    }
}
// 1.按照第一数字递增，第二个数字递减排序，再从后向左，将数字右移第二个数字的位数即可。