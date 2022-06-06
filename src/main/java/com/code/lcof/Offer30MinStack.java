package com.code.lcof;

import java.util.Stack;

/**
 * Created by hejiaxu on 2021/2/21
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 */
public class Offer30MinStack {

    public static void main(String[] args) {
        Offer30MinStack s = new Offer30MinStack();
        s.push(0);
        s.push(1);
        s.push(0);
        s.min();
        s.pop();
        s.min();
        System.out.println();
    }

    Stack<Integer> a = new Stack<>(), b = new Stack<>();

    /**
     * 为了保证能多次插入是也能正确，等于最小值也需要入栈
     */
    public void push(int x) {
        a.push(x);
        if (b.isEmpty() || x <= b.peek()) {
            b.push(x);
        }
    }

    public void pop() {
        if(a.pop().equals(b.peek()))
            b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}

// 用一个栈记录最小值,最小栈，小于等于最小的放在最上面
// 第一个元素时最小栈为空
