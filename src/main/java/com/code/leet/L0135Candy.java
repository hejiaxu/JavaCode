package com.code.leet;

import java.util.Arrays;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

 */
public class L0135Candy {
    public static void main(String[] args) {
        int[] ratings = {2, 1};
        int candy = new L0135Candy().candy(ratings);
        System.out.println(candy);
    }
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i++) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i] > candies[i + 1] + 1 ? candies[i] : candies[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
