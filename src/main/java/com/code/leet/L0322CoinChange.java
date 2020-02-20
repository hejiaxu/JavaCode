package com.code.leet;

/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class L0322CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] record = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            record[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    record[i] = 1;
                } else if (i > coins[j] && record[i - coins[j]] > 0) {

                    if (record[i] <= 0 || record[i - coins[j]] + 1 < record[i]) {
                        record[i] = record[i - coins[j]] + 1;
                    }
                }
            }

        }

        return record[amount];
    }
//        return coinChangeRecur(coins, amount);
    private int coinChangeRecur(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        int r = -1;
        for (int i = coins.length - 1; i >= 0 ; i--) {
            if (amount - coins[i] >= 0 ) {
                System.out.println(coins[i]);
                int r1 = coinChangeRecur(coins, amount - coins[i]);
                if (r1 >= 0 && (r == -1 || r1 < r - 1)) {
                    r = r1 + 1;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int i = new L0322CoinChange().coinChange(coins, amount);
        System.out.println(i);
//        System.out.println((float)4749/5888);
    }
}
