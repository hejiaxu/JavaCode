package com.code.leet;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2.
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 */
public class L0045JumpGameII {

    public int jump(int[] nums) {
        int i = 0;
        int step = 0;
        int length = nums.length;
        while(i < length - 1) {
            int j = nums[i];
            int next = i + 1;
            for (int k = 1; k <= j && k < length - i; k++) {
                if (i + k == length - 1) {
                    next = i + k;
                    break;
                }
                if (nums[i + k] + k + i >= nums[next] + next) {
                    next = i + k;
                }
            }

            i = next;

            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 3, 1, 1, 1};
        int jump = new L0045JumpGameII().jump(nums);
        System.out.println(jump);
    }
}
