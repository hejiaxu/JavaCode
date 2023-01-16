package com.code.leet;

import java.math.BigInteger;

/*
You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.

Return the string that represents the kth largest integer in nums.

Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.



Example 1:

Input: nums = ["3","6","7","10"], k = 4
Output: "3"
Explanation:
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4th largest integer in nums is "3".
Example 2:

Input: nums = ["2","21","12","1"], k = 3
Output: "2"
Explanation:
The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
The 3rd largest integer in nums is "2".
Example 3:

Input: nums = ["0","0"], k = 2
Output: "0"
Explanation:
The numbers in nums sorted in non-decreasing order are ["0","0"].
The 2nd largest integer in nums is "0".


Constraints:

1 <= k <= nums.length <= 104
1 <= nums[i].length <= 100
nums[i] consists of only digits.
nums[i] will not have any leading zeros.
 */
public class L1985FindTheKthLargestIntegerInTheArray {

    public static void main(String[] args) {
        String[] nums = {"3", "6", "7", "10"};
        String s = new L1985FindTheKthLargestIntegerInTheArray().kthLargestNumber(nums, 4);
        System.out.printf(s);
    }

    // timeout
    public String kthLargestNumber(String[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return null;
        }
        return qsort(nums, 0, nums.length - 1, k);
    }

    private String qsort(String[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        String p = nums[l];
        int lPointer = l + 1, rPointer = r;
        while (lPointer <= rPointer && rPointer > l) {
            if (nums[lPointer].length() > nums[l].length()) {
                lPointer++;
            } else if (nums[rPointer].length() < nums[l].length() || (nums[rPointer].length() == nums[l].length() && nums[rPointer].compareTo(p) < 0)) {
                rPointer--;
            } else if (nums[lPointer].length() == nums[l].length() && nums[lPointer].compareTo(p) > 0) {
                lPointer++;
            } else {
                String tmp = nums[lPointer];
                nums[lPointer] = nums[rPointer];
                nums[rPointer] = tmp;
                lPointer++;
                rPointer--;
            }
        }

        String tmp = nums[l];
        nums[l] = nums[rPointer];
        nums[rPointer] = tmp;

        if (rPointer - l + 1 == k) {
            return nums[rPointer];
        } else if (rPointer - l + 1 > k) {
            return qsort(nums, l, rPointer - 1, k);
        } else {
            return qsort(nums, rPointer + 1, r, k + l - rPointer - 1);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo + 1; j <= hi; j++)
                if (nums[j] < nums[lo])
                    swap(nums, j, ++i);
            swap(nums, lo, i);
            if (k == i) {
                return nums[i];
            } else if (k < i) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }
        return -1;
    }

    //交换两个元素的值
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

}
