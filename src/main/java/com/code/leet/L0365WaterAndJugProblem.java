/**
 *
 */
package com.code.leet;

/**
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
 *
 * If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 *  
 *
 * Example 1:
 *
 * Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * Output: true
 * Explanation: The famous Die Hard example
 * Example 2:
 *
 * Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * Output: false
 * Example 3:
 *
 * Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * Output: true
 *
 */
public class L0365WaterAndJugProblem {

    public static void main(String[] args) {
        // TODO
        L0365WaterAndJugProblem l0365WaterAndJugProblem = new L0365WaterAndJugProblem();
//		boolean canMeasureWater = waterAndJugProblem.canMeasureWater(3, 5, 4);
        boolean canMeasureWater = l0365WaterAndJugProblem.canMeasureWater(104579, 104593, 12444);


        System.out.println(canMeasureWater);
    }

    // 0 ms
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        //case x or y is zero
        if (x == z || y == z || x + y == z) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// 计算x,y最大公约数 gcd, z必须小于xy的和且为gcd倍数
