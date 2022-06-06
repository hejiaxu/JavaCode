package com.code.lcof;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hejiaxu on 2021/2/19
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 *
 * 限制：
 *
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 */
public class Offer41MedianFinder {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 6, 7, 2, 0};
        Offer41MedianFinder c = new Offer41MedianFinder();
        c.addNum(1);
        c.addNum(2);
        double strings = c.findMedian();
        System.out.println(strings);
    }


    int[] arr = new int[5000];
    int pos = 0;

    public void addNum(int num) {
        for (int i = 0; i < pos; i++) {
            if (num < arr[i]) {
                int tmp = num;
                num = arr[i];
                arr[i] = tmp;
            }
        }
        arr[pos++] = num;
    }

    public double findMedian() {
        if (pos == 0) return 0;
        return (arr[(pos - 1) / 2] + arr[pos / 2]) / 2.0;
    }

    Queue<Integer> left = new PriorityQueue<>();
    Queue<Integer> right = new PriorityQueue<>((x, y) -> (y - x));
    public void addNum1(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian1() {
        return left.size() == right.size() ? (left.peek() + right.peek()) / 2.0: left.peek();
    }


}

// 方案1.两个有优先级队列.谁少往谁放。方案2.找第k大数找两次