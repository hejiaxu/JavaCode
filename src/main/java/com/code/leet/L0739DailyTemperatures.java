package com.code.leet;

import javafx.util.Pair;

import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */
public class L0739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Stack<Integer> s= new Stack<>();
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[i - 1]) {
                r[i - 1] = 1;
            } else {
                s.push(i - 1);
            }
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                Integer pos = s.pop();
                r[pos] = i - pos;
            }
        }
        return r;
    }
}

// 使用栈记录当前还没有记录的位置，当遇到大于栈顶时，以此出栈记录
