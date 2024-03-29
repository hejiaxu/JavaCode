package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11MinArray {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 4, 5,7,8,9, 1, 2};
        int r = new Offer11MinArray().minArray2(nums);
        System.out.println(r);
    }

    public int minArray(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int recur(int[] numbers, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return numbers[l];
        }
        if (l + 2 < r) {
            return numbers[l] > numbers[r] ? numbers[r] : numbers[l];
        }
        int mid = (l + r) / 2;
        if (numbers[mid] > numbers[mid + 1]) {
            return numbers[mid + 1];
        } else if (numbers[mid] < numbers[mid - 1]) {
            return numbers[mid];
        } else if (numbers[l] < numbers[r]) {
            return recur(numbers, l, mid - 1);
        } else {
            return recur(numbers, mid + 1, r);

        }

    }
}

// review