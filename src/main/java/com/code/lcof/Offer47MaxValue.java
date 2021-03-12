package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 */
public class Offer47MaxValue {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int s1 = new Offer47MaxValue().maxValue(arr);
        System.out.println(s1);
    }

    public int maxValue(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        int[][] r = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i > 0 && j > 0) {
                    r[i][j] = grid[i][j] + (r[i - 1][j] > r[i][j - 1] ? r[i - 1][j] : r[i][j - 1]);
                } else if (i > 0) {
                    r[i][j] = grid[i][j] + r[i - 1][j];
                } else if (j > 0) {
                    r[i][j] = grid[i][j] + r[i][j - 1];
                } else {
                    r[i][j] = grid[i][j];
                }
            }
        }

        return r[height - 1][width - 1];
    }
}
