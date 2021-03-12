package com.code.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hejiaxu on 2021/1/14
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class L0743NetworkDelayTime {
    public static void main(String[] args) {
//        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times = new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
//        int n = 4, k = 2;
        int n = 5, k = 3;
        int i = new L0743NetworkDelayTime().networkDelayTime1(times, n, k);
        System.out.println(i);
    }

    /**
     *
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        long[][] graph = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

        /** 需要中转的值放在最前面 */
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > graph[i][l] + graph[l][j]) {
                        graph[i][j] = graph[i][l] + graph[l][j];
                    }
                }
            }
        }

        long max = 0;
        for (int i = 0; i < n; i++) {
            if (max < graph[k - 1][i]) {
                max = graph[k - 1][i];
            }
        }
        if (max >= Integer.MAX_VALUE) {
            return -1;
        }
        return (int) max;
    }

    Map<Integer, Integer> dist;

    public int networkDelayTime1(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(K, 0);
        boolean[] seen = new boolean[N + 1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info : graph.get(candNode))
                    dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}
