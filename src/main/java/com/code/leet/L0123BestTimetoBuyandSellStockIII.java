package com.code.leet;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).
 */
public class L0123BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] prices = {2,1,2,1,0,0,1};
        int i = new L0123BestTimetoBuyandSellStockIII().maxProfit(prices);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                                // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1 - i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);            // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }



    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[] leftProfit = new int[len + 1];
        int[] righProfit = new int[len + 1];
        int r = 0;
        leftProfit[0] = 0;
        int min = prices[0];
        for (int i = 0; i < len; i++) {
            if (prices[i] > min) {
                leftProfit[i + 1] = leftProfit[i] > prices[i] - min ? leftProfit[i] : prices[i] - min;
            } else {
                leftProfit[i + 1] = leftProfit[i];
                min = prices[i];
            }
        }
        righProfit[len] = 0;
        int max = prices[len - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] < max) {
                righProfit[i] = righProfit[i + 1] > max - prices[i] ? righProfit[i + 1] : max - prices[i];
            } else {
                max = prices[i];
                leftProfit[i] = leftProfit[i + 1];
            }
        }
        for (int i = 0; i < len; i++) {
            int val = righProfit[i] + leftProfit[i];
            r = r > val ? r : val;
        }
        return r;
    }
}
