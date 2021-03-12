package com.code.lcof;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 */
public class Offer57FindContinuousSequence {

    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        int[][] r = new Offer57FindContinuousSequence().findContinuousSequence(9);
        System.out.println(r);

    }

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        List<int[]> r = new LinkedList<>();
        int count = 3;
        while (left < right) {
            if (count == target) {
                int[] item = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    item[i - left] = i;
                }
                r.add(item);
                count -= left;
                left++;
            } else if (count < target) {
                right++;
                count += right;
            } else {
                count -= left;
                left++;
            }
        }

        return r.toArray(new int[][]{});
    }

}
