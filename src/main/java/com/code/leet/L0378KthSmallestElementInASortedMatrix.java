package com.code.leet;

//Given a n x n matrix where each of the rows and columns are sorted in ascendin
//g order, find the kth smallest element in the matrix.
//
//
//Note that it is the kth smallest element in the sorted order, not the kth dist
//inct element.
//
//
// Example:
//
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.
//
//
//
// Note:
//You may assume k is always valid, 1 ≤ k ≤ n2. Related Topics Binary Search Heap

/**
 * Created by hejiaxu on 2020/11/23
 */
public class L0378KthSmallestElementInASortedMatrix {

    /**
     * 暴力排序 n^2*logK
     * 归并 n*logK
     * 二分法 n * logK
     */
    public int kthSmallest(int[][] matrix, int k) {
        int width = matrix[0].length;
        int height = matrix.length;
        if (height * width < k) return -1;
        int l = matrix[0][0], r = matrix[height - 1][width - 1];
        while (l < r) {
            int nth = 0;
            int mid = (l + r) / 2;
            int column = 0;
            for (int i = height - 1; i >= 0; i--) {
                while (column < width && matrix[i][column] <= mid) {
                    column++;
                }
                nth += column;
            }
            if (nth < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
