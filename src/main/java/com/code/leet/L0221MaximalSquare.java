package com.code.leet;

/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class L0221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int up = 0;
                    if (i != 0) {
                        up = dp[i - 1][j];
                    }
                    int left = 0;
                    if (j != 0) {
                        left = dp[i][j - 1];
                    }
                    int upLeft = 0;
                    if (i != 0 && j != 0) {
                        upLeft = dp[i - 1][j - 1];
                    }
                    dp[i][j] = Math.min(Math.min(up, left), upLeft) + 1;

                }
                max = Math.max(max, dp[i][j]);

            }
        }
        return max * max;
    }
}

// f(m,n)为包括当前位置的最大面积，f(m,n) = min(f(m-1,n-1),f(m,n-1),f(m-1,n)) + 1, r = max f(m,n)
