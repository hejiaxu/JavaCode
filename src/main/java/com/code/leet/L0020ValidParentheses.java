package com.code.leet;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

The brackets must close in the correct order,
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
public class L0020ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack <>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if ( stack.empty() ) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (c == ')' && pop != '('
                        || (c == ']' && pop != '[')
                        || (c == '}' && pop != '{')) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[[]]{}";
        boolean valid = new L0020ValidParentheses().isValid(s);
        System.out.println(valid);
    }
}
