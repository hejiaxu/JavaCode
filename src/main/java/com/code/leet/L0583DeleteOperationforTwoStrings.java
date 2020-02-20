package com.code.leet;

/*
Given two words word1 and word2,
find the minimum number of steps required to make word1 and word2 the same,
 where in each step you can delete one character in either string.
 */
public class L0583DeleteOperationforTwoStrings {

    public int minDistance(String word1, String word2) {
        int min = 0;
        int[][] record = new int[word1.length() + 1][word2.length() + 1];
        record[0][0] = 0;
        for (int i = 0; i < word2.length(); i++) {
            record[0][i + 1] = i + 1;
        }
        for (int i = 0; i < word1.length(); i++) {
            record[i + 1][0] = i + 1;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    record[i + 1][j + 1] = record[i][j];
                } else {
                    record[i + 1][j + 1] = min(record[i + 1][j], record[i][j + 1]) + 1;
                }
            }
        }

        return record[word1.length()][word2.length()];
    }

    int min(int ... nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int i = new L0583DeleteOperationforTwoStrings().minDistance("abac", "acc");
        System.out.println(i);
    }
}
