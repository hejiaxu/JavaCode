package com.code.leet;

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 */
public class L0063UniquePathsII {

    public static void main(String[] args) {
        // TODO
//		int[][] obstacleGrid = {{0,0}};
        int[][] obstacleGrid = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        L0063UniquePathsII l0063UniquePathsII = new L0063UniquePathsII();
        int uniquePathsWithObstacles = l0063UniquePathsII.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(uniquePathsWithObstacles);

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null
                || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] tmp = new int[m];
        tmp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                tmp[0] = 0;
            }
            for (int j = 1; j < m; j++) {
                tmp[j] += tmp[j - 1];
                if (obstacleGrid[j][i] == 1) {
                    tmp[j] = 0;
                }
            }
        }
        return tmp[m - 1];
    }
}
