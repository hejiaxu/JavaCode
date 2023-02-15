package com.code.diy;

import java.util.Deque;
import java.util.LinkedList;

public class DIY_Arithmetic {

    int i = 0;
    int calculate2(char[] chars) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        while (i < chars.length) {
            char c = chars[i];
            i++;
            if (c == '-' || c == '+') {
                ops.offerLast(c);
            } else if (c == '(') {
                nums.offerLast(calculate2(chars));
            } else if (c == '*' || c == '/') {
                char c2 = chars[i];
                int num2 = nums.pollLast(), num1;
                i++;
                if (c2 == '(') {
                    num1 = calculate2(chars);
                } else {
                    num1 = c2 - '0';
                }
                if (c == '/') {
                    nums.offerLast(num2 / num1);
                } else {
                    nums.offerLast(num2 * num1);
                }
            } else if (c == ')') {
                break;
            } else {
                nums.offerLast(c - '0');
            }
        }

        while (!ops.isEmpty()) {
            char op = ops.pollFirst();
            int num1 = nums.pollFirst();
            int num2 = nums.pollFirst();
            if (op == '-') {
                nums.offerFirst(num1 - num2);
            } else {
                nums.offerFirst(num1 + num2);
            }
        }
        return nums.peekFirst();
    }

    public static void main(String[] args) {
        DIY_Arithmetic DIYArithmetic = new DIY_Arithmetic();
        String str = "1-9*2/((4-5)+4)-2";
        int calculate2 = DIYArithmetic.calculate2(str.toCharArray());
        System.out.println(calculate2);
    }
}
