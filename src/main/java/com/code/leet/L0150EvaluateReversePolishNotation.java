package com.code.leet;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class L0150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = new L0150EvaluateReversePolishNotation().evalRPN(tokens);
        System.out.println(i);
    }
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                int num2 = num.pop();
                int num1 = num.pop();
                int num3 = num1 + num2;
                num.push(num3);
            } else if (str.equals("-")) {
                int num2 = num.pop();
                int num1 = num.pop();
                int num3 = num1 - num2;
                num.push(num3);
            } else if (str.equals("*")) {
                int num2 = num.pop();
                int num1 = num.pop();
                int num3 = num1 * num2;
                num.push(num3);
            } else if (str.equals("/")) {
                int num2 = num.pop();
                int num1 = num.pop();
                int num3 = num1 / num2;
                num.push(num3);
            } else {
                num.push(Integer.parseInt(str));
            }
        }
        return num.pop();
    }
}
