package com.code.lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by hejiaxu on 2021/2/19
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Offer59MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        int[] r = new Offer59MaxSlidingWindow().maxSlidingWindow(nums, 1);

        System.out.println(r[0]);
        System.out.println(r[1]);
    }


    Deque<Integer> deque = new LinkedList<>();

    /**
     * 1.通过双端队列保存当前最大值的序列
     * 2.小于前一个值的入队
     * 3.大于队尾的则队尾出队，直到队列为空或者队尾大于当前值
     * 4.记录过程中每个最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k == 0) {
            return new int[]{};
        }
        int[] r = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                addDeque(nums[i]);
            } else {
                rebuildDeque(nums[i - k], nums[i]);
            }

            if (i >= k - 1) {
                r[i - k + 1] = deque.peekFirst();
            }
        }
        return r;
    }

    private void rebuildDeque(int first, int last) {
        if (!deque.isEmpty() && deque.peekFirst() == first) {
            deque.pollFirst();
        }
        addDeque(last);
    }


    private void addDeque(int num) {
        while (!deque.isEmpty() && num > deque.peekLast()) {
            deque.pollLast();
        }
        deque.addLast(num);
    }

}
