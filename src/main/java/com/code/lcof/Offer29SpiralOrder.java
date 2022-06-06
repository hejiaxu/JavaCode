package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Offer29SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 2, 3, 5},
                {1, 16, 24, 25},
//                {3, 18, 30, 32},
                {5, 19, 31, 33},
        };
        int target = 30;
        int[] numberIn2DArray = new Offer29SpiralOrder().spiralOrder(matrix);
        for (int i : numberIn2DArray) {
            System.out.print(i + "-");
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;

        int[] r = new int[matrix[0].length * matrix.length];

        int count = 0;
        while (left <= right && up <= down) {
            for (int i = left; i <= right && up <= down; i++) {
                r[count++] = matrix[up][i];
            }
            up++;
            for (int i = up; i <= down && left <= right; i++) {
                r[count++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                r[count++] = matrix[down][i];
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                r[count++] = matrix[i][left];
            }
            left++;
        }

        return r;

    }
}
// 循环打印，记录剩余边界
