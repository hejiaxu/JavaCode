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
        int[] prices = {2,1,2,1,0,0,1};
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
            for (int j = k; j > 0 ; j--) {
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
}
