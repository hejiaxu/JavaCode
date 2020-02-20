package com.code.leet;

/*

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

 */
public class L0518CoinChange2 {

    public int coinChange(int[] coins, int amount) {
        int[] record = new int[amount + 1];
        record[0] = 1;
        for (int j = 0; j < coins.length; j++) {

            for (int i = 1; i <= amount; i++) {
                if (i >= coins[j]) {
                    record[i] += record[i - coins[j]];
                }
            }

        }

        return record[amount];
    }


    public static void main(String[] args) {
//        int[] coins = {186,419,83,408};
//        int amount = 6249;
        int[] coins = {1, 2, 5};
        int amount = 5;
        int i = new L0518CoinChange2().coinChange(coins, amount);
        System.out.println(i);
//        System.out.println((float)4749/5888);
    }
}
