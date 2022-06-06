package com.code.lcof;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hejiaxu on 2021/2/19
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 */
public class Offer59MaxQueue {

    public static void main(String[] args) {
        Offer59MaxQueue c = new Offer59MaxQueue();
        c.push_back(1);
        System.out.println(c.max_value());
        System.out.println(c.pop_front());
        c.push_back(3);
        c.push_back(5);
        c.push_back(2);
        System.out.println(c.max_value());
        System.out.println(c.pop_front());
        c.push_back(1);
        c.push_back(8);
        System.out.println(c.max_value());
        System.out.println(c.pop_front());
    }


    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int poll = queue.poll();
        if (!deque.isEmpty() && deque.peekFirst() == poll) {
            deque.pollFirst();
        }

        return poll;
    }

}
