package com.code.lcof;

import java.util.Stack;

/**
 * Created by hejiaxu on 2021/2/19
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 */
public class Offer31ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};
//        int[] popped = new int[]{4, 3, 5, 2, 1};
        boolean r = new Offer31ValidateStackSequences().validateStackSequences(pushed, popped);
        System.out.println(r);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        } else if (pushed.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (j < popped.length) {
            if (stack.isEmpty()) {
                if (i < pushed.length) {
                    stack.push(pushed[i++]);
                } else {
                    break;
                }
            } else if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                if (i < pushed.length) {
                    stack.push(pushed[i++]);
                } else {
                    break;
                }
            }
        }
        return i == pushed.length && j == popped.length;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        } else if (pushed.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (j < popped.length || i < pushed.length) {
            if (j == popped.length) {
                break;
            } else if (i == pushed.length) {
                if (popped[j] == stack.peek()) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
            else if (popped[j] == pushed[i]) {
                j++;
                i++;
            } else if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            } else if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i++]);
            }
        }
        return stack.isEmpty() && i == pushed.length && j == popped.length;

    }

}
// 依次push过程中，相同则还原pop。可以放入stack之后比，也可以放之前比。
// 注意1.循环条件。2.数组长度和边界