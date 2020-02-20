/**
 * 
 */
package com.code.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class L0225ImplementStackusingQueues {

	public static void main(String[] args) {
		// TODO 

	}
	 /** Initialize your data structure here. */
    public L0225ImplementStackusingQueues() {
        queue1= new LinkedList<>();
        queue2= new LinkedList<>();
    }
    Queue<Integer> queue1,queue2;
    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue1.isEmpty()) {
			queue1.offer(x);
		}else{
			queue2.offer(x);
		}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int top = -1;
        if (!queue1.isEmpty()) {
			while (!queue1.isEmpty()) {
				top = queue1.poll();
				if(queue1.isEmpty())break;
				queue2.offer(top);
			}
		}else{
			while (!queue2.isEmpty()) {
				top = queue2.poll();
				if(queue2.isEmpty())break;
				queue1.offer(top);
			}
		}
        return top;
    }
    
    /** Get the top element. */
    public int top() {
    	int top = -1;
        if (!queue1.isEmpty()) {
			while (!queue1.isEmpty()) {
				top = queue1.poll();
				queue2.offer(top);
			}
		}else{
			while (!queue2.isEmpty()) {
				top = queue2.poll();
				queue1.offer(top);
			}
		}
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
        	return true;
        }
        return  false;
    }
}
