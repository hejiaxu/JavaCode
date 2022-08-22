/**
 *
 */
package com.code.leet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 */
public class L0015ThreeSum {

    public static void main(String[] args) {
        // TODO
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
        for (Iterator iterator = threeSum.iterator(); iterator.hasNext(); ) {
            List<Integer> list = (List<Integer>) iterator.next();
            for (Iterator iterator2 = list.iterator(); iterator2.hasNext(); ) {
                Integer integer = (Integer) iterator2.next();
                System.out.print(integer);
                System.out.print(",");
            }
            System.out.println();

        }
    }

    //81ms
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        int k = 0, r = nums.length;
        while (k < r - 2) {
            if (!(k > 0 && nums[k] == nums[k - 1])) {
                int target = -nums[k];
                int i = k + 1, j = r - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        List<Integer> item = Arrays.asList(nums[k], nums[i], nums[j]);
                        result.add(item);
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }

            k++;
        }
        return result;
    }

    //81ms
    public static List<List<Integer>> threeSum2(int[] nums, int t) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int k = 0, r = nums.length;
        while (k < r - 2) {
            if (!(k > 0 && nums[k] == nums[k - 1])) {
                int target = t - nums[k];
                int i = k + 1, j = r - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        List<Integer> item = Arrays.asList(nums[k], nums[i], nums[j]);
                        result.add(item);
                        ;
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }

            k++;
        }
        return result;
    }
}
