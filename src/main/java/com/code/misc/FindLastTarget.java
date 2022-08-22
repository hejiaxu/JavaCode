package com.code.misc;

/*
find the last position of target number in an ascending array
 */
public class FindLastTarget {
    public static void main(String[] args) {
//        int [] nums = new int[] {2,3,7,7,7,9};
        int [] nums = new int[] {1, 2};
//        int target = 7;
        int target = 1;
        int lastTarget = new FindLastTarget().findLastTarget(nums, target);
        System.out.println(lastTarget);
    }

    int findLastTarget2(int[] nums, int target) {
        return dfs(nums, target, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        else if (l == r) return nums[l] == target ? l : -1;
        if (nums[r] == target) return r;

        int mid = (l + r) / 2;
        if (nums[mid] > target) {
            return dfs(nums, target, l, mid - 1);
        } else if (nums[mid] < target) {
            return dfs(nums, target, mid + 1, r);
        } else {
            return dfs(nums, target, mid, r - 1);
        }
    }


    int findLastTarget(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r && nums[r]>= target) {
            int mid = (l + r) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r < nums.length & r >= 0 ? r : -1;
        
    }

}

// 二分法查找，注意相等的时候小心无限循环。可以前置判断最右等于target直接返回最优，则后面相等时，取mid和r-1即可
