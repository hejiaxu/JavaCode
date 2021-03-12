package com.code.algr.shortestpath;

/**
 * Created by hejiaxu on 2021/2/9
 */
public class Dijkstra {
    public static void main(String[] args) {

        int[][] graph = new int[][] {
                {0, 2, 9, 1},
                {2, 0, 3, 4},
                {9, 3, 0, 2},
                {1, 4, 2, 0},
        };

        int i = new Dijkstra().shortestPath(graph, 4,0, 2);
        System.out.println(i);
    }

    int shortestPath(int[][] graph, int n, int l, int m) {
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == l - 1) {
                path[i] = 0;
            } else {
                path[i] = graph[l][i];
            }
        }

        while (true) {
            int node = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (node == -1 || graph[l][node] > graph[l][i])) {
                    node = i;
                }
            }
            if (node == -1) {
                break;
            }

            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                if (graph[node][i] < path[i] - path[node]) {
                    path[i] = path[node] + graph[node][i];
                }
            }
        }

        return path[m];
    }
}
