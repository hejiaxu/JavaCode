package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Offer13MovingCount {
    public static void main(String[] args) {

        int m = 11, n = 8, k = 16;
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // 2

        int r = new Offer13MovingCount().movingCount(m, n, k);
        System.out.println(r);
    }

    int count = 0;

    public int movingCount(int m, int n, int k) {
        boolean[] visited = new boolean[m * n];

        dfs(0, m, 0, n, k, visited);
        return count;
    }

    private void dfs(int i, int m, int j, int n, int k, boolean[] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (visited[i * n + j] == true) {
            return;
        }
        visited[i * n + j] = true;
        if (sum(i) + sum(j) > k) {
            return;
        }
        count++;
        dfs(i + 1, m, j, n, k, visited);
        dfs(i - 1, m, j, n, k, visited);
        dfs(i, m, j + 1, n, k, visited);
        dfs(i, m, j - 1, n, k, visited);
    }

    private int sum(int n) {
        int r = 0;
        while (n != 0) {
            r += n % 10;
            n /= 10;
        }
        return r;
    }

    class UnionSearch {
        int[] arr;
        UnionSearch(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }
        int find(int x) {
            while (arr[x] != x) {
                x = arr[x];
            }
            return x;
        }

        boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }

        void connect(int x, int y) {
            arr[find(x)] = find(y);
        }
    }
}
// reviewed
