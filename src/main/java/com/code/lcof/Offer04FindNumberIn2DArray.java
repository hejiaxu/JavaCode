package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 */
public class    Offer04FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 2, 3, 5},
                {1, 16, 24, 25},
                {3, 18, 30, 32},
                {5, 19, 31, 33},
        };
        int target = 30;
        boolean numberIn2DArray = new Offer04FindNumberIn2DArray().findNumberIn2DArray(matrix, target);
        System.out.println(numberIn2DArray);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        int w = 0, h = height - 1;
        while (w < width && h >= 0) {
            if (matrix[h][w] == target) {
                return true;
            } else if (matrix[h][w] > target) {
                h--;
            } else {
                w++;
            }
        }
        return false;
    }
}
// review

