package com.code.leet;
/*
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 

Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/validate-stack-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Stack;

public class L0946ValidateStackSequences {

    // 1.push进栈，
    // 2.栈顶与pop相同则出栈
    // 3.全部处理完则是正确顺序
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int pushPos = 0, popPos = 0;
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();
        while (pushPos < length && popPos < length) {
            if (stack.isEmpty() || stack.peek() != popped[popPos]) {
                stack.push(pushed[pushPos++]);
            }  else {
                stack.pop();
                popPos++;
            }
        }
        while (popPos < length && stack.isEmpty() && stack.peek() == popped[popPos]) {
            stack.pop();
            popPos++;
        }

        return pushPos == length && popPos == length;
    }
}
