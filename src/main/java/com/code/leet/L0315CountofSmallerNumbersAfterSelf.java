package com.code.leet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

 */

public class L0315CountofSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        // TODO
        L0315CountofSmallerNumbersAfterSelf bean = new L0315CountofSmallerNumbersAfterSelf();
        int[] nums = new int[]{5, 2, 6, 1};
        int[] nums2 = new int[]{-1, -2};
		List<Integer> countSmaller = bean.countSmaller(nums);
		for (Integer integer : countSmaller) {
			System.out.print(integer);
		}
        System.out.println();
        List<Integer> countSmaller2 = bean.countSmaller2(nums2);
        for (Integer integer : countSmaller2) {
            System.out.print(integer);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j-1]) {

                }
            }
        }

        List<Integer> asList = Arrays.asList(tmp);
        return asList;
    }


    //8ms
    int[] count;
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        int[] tmpIndexs = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
            tmpIndexs[i] = i;
        }
        mergesort(nums, indexes, tmpIndexs, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] indexes,int[] tmpIndexs, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, tmpIndexs, indexes, start, mid);
        mergesort(nums, tmpIndexs, indexes, mid + 1, end);

        merge(nums, indexes, tmpIndexs, start, end);
    }
    private void merge(int[] nums, int[] indexs, int[] tmpIndexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;

        int tmp_index = start;
        while(left_index <= mid && right_index <= end){
            if(nums[tmpIndexes[right_index]] < nums[tmpIndexes[left_index]]){
                indexs[tmp_index] = tmpIndexes[right_index];
                rightcount++;
                right_index++;
            }else{
                indexs[tmp_index] = tmpIndexes[left_index];
                count[tmpIndexes[left_index]] += rightcount;
                left_index++;
            }
            tmp_index++;
        }
        while(left_index <= mid){
            indexs[tmp_index] = tmpIndexes[left_index];
            count[tmpIndexes[left_index]] += rightcount;
            left_index++;
            tmp_index++;
        }
        while(right_index <= end){
            indexs[tmp_index++] = tmpIndexes[right_index++];
        }
    }
}
