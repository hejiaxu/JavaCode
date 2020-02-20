package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/*
Follow up for N-Queens problem.

Now, instead outputting board configurations,
return the total number of distinct solutions.
 */
public class L0052NQueensII {
    public static void main(String[] args) {
        int i = new L0052NQueensII().totalNQueens(1);
        System.out.println(i);
    }
    public int totalNQueens(int n) {
        char[][] chars = new char[n][n];
        return dfs(chars, n - 1, n);
    }

    private int dfs(char[][] chars, int p, int n) {
        if (p == -1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isAppropriate(i, p, n, chars)) {
                chars[p][i] = 'Q';
                count += dfs(chars, p - 1, n);
                chars[p][i] = '.';
            }
        }
        return count;
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
