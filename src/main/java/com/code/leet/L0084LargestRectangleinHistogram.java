package com.code.leet;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height
where the width of each bar is 1,
find the area of largest rectangle in the histogram.
 */
public class L0084LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack <>();
        int max = 0;
        int i = 0;
        while(i < heights.length || !stack.empty()) {
            if (!stack.empty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                max = Math.max(max, (i - (stack.isEmpty() ? -1 : stack.peek() + 1)) * heights[stack.pop()]);
            } else {
                stack.push(i++);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = new L0084LargestRectangleinHistogram().largestRectangleArea(heights);
        System.out.println(i);
    }
}
