package com.code.leet;

public class L0036ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int i, int j) {
        if (board[i][j] == '.') {
            return true;
        }
        for (int k = j + 1; k < 9; k++) {
            if (board[i][j] == board[i][k] || board[i][j] == board[k][j]) {
                return false;
            }

        }
        for (int k = i; k < (i / 3) * 3 + 3; k++) {
            for (int l = (j / 3) * 3; l < (j / 3) * 3 + 3; l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (board[i][j] == board[k][l]) {
                    return false;
                }
            }
        }
        return true;
    }
}