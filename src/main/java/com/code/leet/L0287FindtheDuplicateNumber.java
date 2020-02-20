package com.code.leet;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class L0287FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 2, 1};
        int duplicate = new L0287FindtheDuplicateNumber().findDuplicate3(nums);
        System.out.println(duplicate);
    }

    //1000ms
    public int findDuplicate(int[] nums) {
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 0;
            while(nums[j] - 1 != j) {
                if (nums[j] - 1 != i && nums[nums[j] - 1] == nums[i]) {
                    return nums[i];
                } else {
                    j = nums[j] - 1;
                    if (count++ > nums.length || j == i) {
                        break;
                    }
                }
            }
        }
        return dup;
    }

    //TLE
    public int findDuplicate2(int[] nums) {
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = nums[slow] - 1;
            while(nums[slow] - 1 != slow ) {
                if (nums[slow] - 1 != i && nums[nums[slow] - 1] == nums[i]) {
                    return nums[i];
                } else {
                    if (slow == fast) {
                        break;
                    }
                    slow = nums[slow] - 1;
                    fast = nums[fast] - 1;
                    fast = nums[fast] - 1;
                }
            }
        }
        return dup;
    }

    //it can be a dup sublist without a loop
    public int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
