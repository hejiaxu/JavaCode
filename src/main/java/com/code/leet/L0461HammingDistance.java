package com.code.leet;


/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
 */
public class L0461HammingDistance {

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            count += x & 1;
            x = x >> 1;
        }
        return count;
    }
}
