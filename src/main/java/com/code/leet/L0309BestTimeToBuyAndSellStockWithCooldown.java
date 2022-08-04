package com.code.leet;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

 */
public class L0309BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] ints = new int[] {1,2,3,0,2};
        int i = new L0309BestTimeToBuyAndSellStockWithCooldown().maxProfit(ints);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int[][] matrix = new int[prices.length][prices.length];
        // 计算只有一次买卖的最大收益
        for (int i = 0; i < prices.length - 1; i++) {
            int min = prices[i], max = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (min > prices[j]) {
                    min = prices[j];
                } else if (prices[j] - min > max) {
                    max = prices[j] - min;
                }
                matrix[i][j] = max;
            }

        }
        //
        int[] r = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            r[i] = matrix[0][i];
            for (int j = 1; j < i - 2; j++) {
                if (r[j] + matrix[j + 2][i] > r[i]) {
                    r[i] = r[j] + matrix[j + 2][i];
                }
                if (r[j - 1] + matrix[j + 1][i] > r[i]) {
                    r[i] = r[j - 1] + matrix[j + 1][i];
                }
            }
        }
        return r[prices.length - 1];
    }

}
