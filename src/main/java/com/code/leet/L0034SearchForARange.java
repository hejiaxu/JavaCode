package com.code.leet;

/*
Given an array of integers sorted in ascending order,
find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class L0034SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int ll = 0;
        int lr = nums.length - 1;
        while(ll <= lr && nums[ll] <= target) {
            int lmid = (ll + lr) / 2;
            if (nums[lmid] >= target) {
                lr = lmid - 1;
            } else {
                ll = lmid + 1;
            }
        }

        int rl = 0;
        int rr = nums.length - 1;
        while(rl <= rr && nums[rr] >= target) {
            int rmid = (rl + rr) / 2;
            if (nums[rmid] <= target) {
                rl = rmid + 1;
            } else {
                rr = rmid - 1;
            }
        }

        if(nums.length > 0 && ll < nums.length && rr >= 0 && nums[ll] == target) {
            result[0] = ll;
            result[1] = rr;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1};
        int[] nums = {1,2};
        int target = 1;
        int[] ints = new L0034SearchForARange().searchRange(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
