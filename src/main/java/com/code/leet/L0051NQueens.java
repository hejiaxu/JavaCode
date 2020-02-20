package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class L0051NQueens {

    public static void main(String[] args) {
        List<List<String>> lists = new L0051NQueens().solveNQueens(1);
        for (List<String> list: lists) {
            for (String  str: list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }


    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j] = '.';
            }
        }
        List<List<String>> r = new LinkedList<>();
        dfs(chars, n - 1, n, r);
        return r;
    }

    private void dfs(char[][] chars, int p, int n, List<List<String>> r) {
        if (p == -1) {
            List<String> item = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                item.add(new String(chars[i]));
            }
            r.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isAppropriate(i, p, n, chars)) {
                chars[p][i] = 'Q';
                dfs(chars, p - 1, n, r);
                chars[p][i] = '.';
            }
        }
    }

    private boolean isAppropriate(int i, int p, int n, char[][] chars) {
        for (int k = p + 1; k < n; k++) {
            if (chars[k][i] == 'Q') {
                return false;
            }
            if (i + k - p < n && chars[k][i + k - p] == 'Q') {
                return false;
            }
            if (i - k + p >= 0 && chars[k][i - k + p] == 'Q') {
                return false;
            }

        }
        return true;
    }
}
