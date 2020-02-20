package com.code.leet;

import java.util.Vector;

/*
Given a positive integer n,
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class L0279PerfectSquares {

    public static void main(String[] args) {
        int i = new L0279PerfectSquares().numSquares2(12);
        System.out.println(i);
    }
    public int numSquares(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int sqrt = (int)Math.sqrt(i + 1);
            if (sqrt * sqrt == i + 1) {
                arr[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    int num = arr[j] + arr[i - j - 1];
                    if (num < min) {
                        min = num;
                    }
                }
                arr[i] = min;
            }
        }
        return arr[n - 1];
    }

    // cntPerfectSquares[i] = the least number of perfect square numbers
    // which sum to i. Since cntPerfectSquares is a static vector, if
    // cntPerfectSquares.size() > n, we have already calculated the result
    // during previous function calls and we can just return the result now.
    static Vector<Integer> cntPerfectSquares = new Vector<>();
    static {
        cntPerfectSquares.add(0);
    }
    public int numSquares2(int n) {
        if (n <= 0)
        {
            return 0;
        }
        // While cntPerfectSquares.size() <= n, we need to incrementally
        // calculate the next result until we get the result for n.
        while (cntPerfectSquares.size() <= n)
        {
            int m = cntPerfectSquares.size();
            int cntSquares = Integer.MAX_VALUE;
            for (int i = 1; i*i <= m; i++)
            {
                cntSquares = Math.min(cntSquares, cntPerfectSquares.get(m - i*i) + 1);
            }

            cntPerfectSquares.add(cntSquares);
        }

        return cntPerfectSquares.get(n);
    }


}
