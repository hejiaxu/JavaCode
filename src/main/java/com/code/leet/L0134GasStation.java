package com.code.leet;

/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank
and it costs cost[i] of gas to travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
public class L0134GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2};
        int[] cost = {2, 1};
        int i = new L0134GasStation().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            gas[i] -= cost[i];
        }

        int p = 0;
        while (p < len) {
            int i = 0;
            int sum = 0;
            while (sum >= 0) {
                if (i == len) {
                    return p;
                }
                sum += gas[(p + i++) % len];
            }
            p += i;
        }
        return -1;
    }
}
