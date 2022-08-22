package com.code.interview;

/*
A majority element is an element that makes up more than half of the items in an array. Given a integers array, find the majority element. If there is no majority element, return -1. Do this in O(N) time and O(1) space.

Example 1:

Input: [1,2,5,9,5,9,5,5,5]
Output: 5
 

Example 2:

Input: [3,2]
Output: -1
 

Example 3:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class LCCI1710FindMajorityElement {
    public int majorityElement(int[] nums) {
        int result = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            }
        }

        return count * 2 > nums.length ? result : -1;
    }

}
//Boyer-Moore 投票算法的基本思想是：在每一轮投票过程中，从数组中删除两个不同的元素，直到投票过程无法继续，此时数组为空或者数组中剩下的元素都相等。

