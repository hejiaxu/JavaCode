package com.code.lcof;

import java.util.Stack;

/**
 * Created by hejiaxu on 2021/2/19
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class Offer09CQueue {
    public static void main(String[] args) {
    }

    Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();

    public Offer09CQueue() {

    }

    public void appendTail(int value) {
        appendTail(stack1, stack2, value);
    }

    private void appendTail(Stack<Integer> stack1, Stack<Integer> stack2, int value) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(value);
        } else if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(value);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } else {
            appendTail(stack2, stack1, value);
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        } else if (stack1.isEmpty()) {
            return stack2.pop();
        } else {
            return stack1.pop();
        }
    }
}
