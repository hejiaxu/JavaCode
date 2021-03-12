package com.code.algr.shortestpath;

/**
 * Created by hejiaxu on 2021/1/29
 */
public class Floyd {

    public static void main(String[] args) {

        int[][] graph = new int[][] {
                {0, 2, 9, 1},
                {2, 0, 3, 4},
                {9, 3, 0, 2},
                {1, 4, 2, 0},
        };

        int i = new Floyd().floyd2(graph, 0, 2);
        System.out.println(i);
    }

    /**
     * 从i号顶点到j号顶点只经过前k号点的最短路程。
     * https://www.cnblogs.com/wangyuliang/p/9216365.html
     */
    int floyd(int[][] graph, int l, int m) {

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][k] < graph[i][j] - graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        return graph[l][m];
    }

    int floyd2(int[][] graph, int l, int m) {

        for (int k = 0; k < graph.length; k++) {
            if (graph[l][k] + graph[k][m] < graph[l][m]) {
                graph[l][m] = graph[l][k] + graph[k][m];
            }
        }

        return graph[l][m];
    }
}
