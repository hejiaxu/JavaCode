package com.code.lcof;

import java.util.Arrays;

/**
 * Created by hejiaxu on 2021/2/19
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 */
public class Offer61IsStraight {

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5};
        boolean r = new Offer61IsStraight().isStraight(nums);

        System.out.println(r);
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 2;
        while (l <= r) {
            if (nums[r] == nums[r + 1] - 1) {
                r--;
            } else if (nums[l] == 0) {
                l++;
                nums[r + 1]--;
            } else {
                break;
            }
        }

        return l > r;
    }

}
