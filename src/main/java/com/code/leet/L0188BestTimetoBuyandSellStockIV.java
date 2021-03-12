package com.code.leet;

import java.util.Arrays;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class L0188BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 1, 0, 0, 1};
        int k = 2;
        int i = new L0188BestTimetoBuyandSellStockIV().maxProfit(k, prices);
        System.out.println(i);
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        }
        return sell[k];
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int r = 0;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] > min) {
                r = Math.max(prices[i] - min, r);
            } else {
                min = prices[i];
            }
        }
        return r;
    }

    public int maxProfit3(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) return 0;
        int[][] dp = new int[2][k];
        //dp[0][j] stores maximum profit acheived by atmost k transaction without having stocks
        //dp[1][j] stores maximum profit acheived by atmost k transaction with having stocks
        Arrays.fill(dp[1], Integer.MIN_VALUE);

        for (int price : prices) {
            dp[0][0] = Math.max(dp[0][0], dp[1][0] + price);
            dp[1][0] = Math.max(dp[1][0], -price);
            for (int trans = 1; trans < k; trans++) {
                dp[0][trans] = Math.max(dp[0][trans], dp[1][trans] + price);//cash
                dp[1][trans] = Math.max(dp[1][trans], dp[0][trans - 1] - price);//hold
            }
        }

        return dp[0][k - 1];
    }
}
