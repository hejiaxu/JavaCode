package com.code.leet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hejiaxu on 2021/2/10
 * <p>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 */
public class L0505TheMazeII {
    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};

        int b = new L0505TheMazeII().shortestDistance(maze, start, destination);
        System.out.println(b);
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int height = maze.length;
        int width = maze[0].length;
        boolean[] visited = new boolean[height * width];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (destination[0] == poll[0] && destination[1] == poll[1]) {
                return poll[2];
            }
            if (visited[poll[0] + poll[1] * height]) {
                continue;
            }
            visited[poll[0] + poll[1] * height] = true;
            for (int[] dir : dirs) {
                int ph = poll[0];
                int pw = poll[1];

                // 撞墙转弯
                int step = 0;
                while (ph + dir[0] >= 0 && ph + dir[0] < height
                        && pw + dir[1] >= 0 && pw + dir[1] < width
                        && maze[ph + dir[0]][pw + dir[1]] == 0) {
                    ph = ph + dir[0];
                    pw = pw + dir[1];
                    step++;
                }
                if (step > 0) {
                    queue.offer(new int[]{ph, pw, poll[2] + step});
                }

                // 自由转弯
//                if (h >= 0 && h < height && w >= 0 && w < width && maze[h][w] == 0) {
//                    queue.offer(new int[] {h, w, poll[2] + 1});
//                }
            }

        }

        return -1;
    }
}
