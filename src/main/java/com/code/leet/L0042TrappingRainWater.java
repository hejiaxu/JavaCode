package com.code.leet;

import java.util.Stack;

public class L0042TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = {2, 1, 0, 2};
        int trap = new L0042TrappingRainWater().trap2(heights);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int max = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                Integer pop = stack.pop();
                Integer peek = stack.isEmpty()? pop : stack.peek();
                max += (Math.min(height[peek], height[i]) - height[pop]) * (i - peek - 1);
            }

        }
        return max;
    }

    public int trap2(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int lMaxHeight = 0;
        int rMaxHeight = 0;
        while (l < r) {
            if (height[l] > lMaxHeight) {
                lMaxHeight = height[l];
            }
            if (height[r] > rMaxHeight) {
                rMaxHeight = height[r];
            }
            if (height[l] < height[r]) {
                max += Math.min(lMaxHeight, rMaxHeight) - height[l++];
            } else {
                max += Math.min(lMaxHeight, rMaxHeight) - height[r--];
            }
        }
        return max;
    }
}
