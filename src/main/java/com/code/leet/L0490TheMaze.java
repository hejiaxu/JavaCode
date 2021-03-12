package com.code.leet;

/**
 * Created by hejiaxu on 2021/2/10
 *
 There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 */
public class L0490TheMaze {

    /**
     *
     */
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};

        boolean b = new L0490TheMaze().hasPath1(maze, start, destination);
        System.out.println(b);
    }

    /**
     * 并查集
     */
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        UnionFind unionFind = new UnionFind(new int[maze.length * maze[0].length]);

        int height = maze.length;
        if (height == 0) {
            return false;
        }
        int width = maze[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 0) {
                    if (i > 0 && maze[i - 1][j] == 0) {
                        unionFind.union(i + j * i, i + j * i - j - 1);
                    }

                    if (j > 0 && maze[i][j - 1] == 0) {
                        unionFind.union(i + j * i, i + j * i - i);
                    }
                }
            }
        }

        return unionFind.isConnect(start[0] + start[0] * start[1], destination[0] + destination[0] * destination[1]);
    }

    class UnionFind {
        int[] item;

        UnionFind(int[] arr) {
            item = arr;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        int find(int x) {
            while (item[x] != x) {
                x = item[x];
            }
            return x;
        }

        boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            item[find(x)] = find(y);
        }

    }


    /**
     * dfs
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int height = maze.length;
        if (height == 0) {
            return false;
        }
        int width = maze[0].length;


        boolean[][] visited = new boolean[height][width];

        return dfs(maze, visited, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;

        int[][] next = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int l = start[0] + next[i][0];
            int m = start[1] + next[i][1];

            if (l > 0 && l < maze.length && m > 0 && m < maze[0].length && !visited[l][m] && maze[l][m] == 0) {
                boolean result = dfs(maze, visited, new int[]{l, m}, destination);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

}
