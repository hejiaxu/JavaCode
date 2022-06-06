package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */
public class Offer12Exist {
    public static void main(String[] args) {

//        char[][] nums = new char[][]{
//                {3, 4, 5, 1, 2},
//                {3, 4, 5, 1, 2},
//                {3, 4, 5, 1, 2},
//        };
//        String s = "444512";
//        String s = "3";
        char[][] nums = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s = "ABCCED";
        boolean r = new Offer12Exist().exist(nums, s);
        System.out.println(r);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if (visited[i][j] == true || (pos < word.length() && board[i][j] != word.charAt(pos))) {
            return false;
        }

        if (pos >= word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int h = i + dir[0], w = j + dir[1];
            if (h >= 0 && h < board.length && w >= 0 && w < board[0].length && visited[h][w] == false) {
                if (dfs(board, h, w, visited, word, pos + 1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;

        return false;
    }

}
// review
