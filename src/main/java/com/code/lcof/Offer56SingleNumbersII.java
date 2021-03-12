package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 */
public class Offer56SingleNumbersII {
    public static void main(String[] args) {
        int[] nums = {3,-2,3,3};
        int r = new Offer56SingleNumbersII().singleNumber(nums);
        System.out.println(r);
    }

    /**
     * 1. 按为统计
     * 2. 按照出现次数取模
     * 3. 通过long处理溢出情况
     */
    public int singleNumber(int[] nums) {
        long r = 0;
        for (long pos = 1; pos <= Integer.MAX_VALUE + 1L; pos <<= 1) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & pos) > 0) {
                    count++;
                }
            }
            if (count % 3 > 0) {
                r += pos;
            }
        }
        return (int)r;
    }
}
