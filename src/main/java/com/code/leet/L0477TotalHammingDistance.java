package com.code.leet;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */
public class L0477TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    one++;
                } else {
                    zero++;
                }
                nums[j] = nums[j] >> 1;

            }
            count += one * zero;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,14,2};
        int i = new L0477TotalHammingDistance().totalHammingDistance(nums);
        System.out.println(i);
        System.out.println(10 /3 * 3);
    }
}
