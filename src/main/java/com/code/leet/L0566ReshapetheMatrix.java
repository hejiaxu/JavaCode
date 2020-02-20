package com.code.leet;

public class L0566ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if ( r * c != row * column || c == column) return nums;
        int[][] result = new int[r][c];
        for (int i = 0; i < row * column; i++) {
            result[i / c][i % c] = nums[i / column][i % column];
        }
        return result;
    }
    
    public static void main(String[] args) {

        int[][] nums = {{1,2},{3,4}};
        int[][] ints = new L0566ReshapetheMatrix().matrixReshape(nums, 1, 4);
    }
}
