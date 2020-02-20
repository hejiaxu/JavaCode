package com.code.leet;

public class L0037SudokuSolver {
    public void solveSudoku(char[][] board) {
        p(board);
        dfs(board);
        p(board);
    }

    private void p(char[][] board) {
        int len = 9;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public boolean dfs(char[][] board) {
        int len = 9;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {

                        if ( check(board, i, j, k) ) {
                            board[i][j] = k;
                            if ( dfs(board) ) {
                                return true;
                            }
                            board[i][j] = '.';
                        }


                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int i, int j, char num) {
        for (int k = 0; k < 9; k++) {
            if ( board[i][k] == num || board[k][j] == num) {
                return false;
            }
        }

        for (int k = i - i % 3; k < i - i % 3 + 3; k++) {
            for (int l = j - j % 3; l < j - j % 3 + 3; l++) {
                if ( board[k][l] == num ) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] argvs) {
        String[] ar = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] chs = new char[9][9];
        for (int i = 0; i < 9; i++) {
            chs[i] = ar[i].toCharArray();
        }
        new L0037SudokuSolver().solveSudoku(chs);
    }
}
