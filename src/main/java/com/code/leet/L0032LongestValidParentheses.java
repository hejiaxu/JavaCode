package com.code.leet;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')',
 find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()",
 which has length = 4
 */
public class L0032LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - (stack.isEmpty() ? -1 : stack.peek()));
            } else {
                stack.push(i);
            }
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int max = 0;

        int numLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (numLeft > 0) {
                    numLeft--;
                    dp[i] = dp[i - 1] + 1;
                    int preLeftPos = i - dp[i] * 2;
                    if (preLeftPos > 0) {
                        dp[i] += dp[preLeftPos];
                    }
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            } else {
                numLeft++;
            }
        }
        return max * 2;
    }


    public static void main(String[] args) {

        String s = "()(())";
        int i = new L0032LongestValidParentheses().longestValidParentheses(s);
        System.out.println(i);

    }
}
