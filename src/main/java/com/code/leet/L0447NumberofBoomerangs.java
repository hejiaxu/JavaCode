package com.code.leet;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs.
You may assume that
n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

 */
public class L0447NumberofBoomerangs {
    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        int r = 0;
        HashMap<Long, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    long distance = getDistance(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for (int l: map.values()) {
                r += l * (l - 1);
            }
            map.clear();
        }
        return  r;

    }

    private long getDistance(int[] point1, int[] point2) {
        long x = point1[0] - point2[0];
        long y = point1[1] - point2[1];
        return x * x + y * y;
    }

}
