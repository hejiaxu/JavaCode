package com.code.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hejiaxu on 2021/1/12
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class L0054SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{1, 2, 3}};
        int[][] matrix3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(String.join(",", Stream.of(spiralOrder(matrix1)).map(Object::toString).collect(Collectors.toList())));
        System.out.println(String.join(",", Stream.of(spiralOrder(matrix2)).map(Object::toString).collect(Collectors.toList())));
        System.out.println(String.join(",", Stream.of(spiralOrder(matrix3)).map(Object::toString).collect(Collectors.toList())));
    }
    // 123
    // 456
    // 789
    // 789

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new LinkedList<>();
        if (matrix.length <= 0) return r;
        int left = 0, up = 0, right = matrix[0].length - 1, down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                r.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                r.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left && down > up; i--) {
                r.add(matrix[down][i]);
            }
            for (int i = down - 1; i > up && right > left; i--) {
                r.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        return r;
    }
}
