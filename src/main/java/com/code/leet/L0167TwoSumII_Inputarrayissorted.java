package com.code.leet;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class L0167TwoSumII_Inputarrayissorted {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                break;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    //0ms
    public int[] twoSum2(int[] numbers, int target) {
        //high：寻找比target小，但是其右边比target大的坐标
        //low：寻找比target大，但是左边比target小的坐标
        int low = 0;
        int high = numbers.length-1;
        while(low < high) {
            if((numbers[low] + numbers[high]) > target) {
                int start = low+1;
                int end = high;
                while(start < end) {
                    int mid = (start+end)/2;
                    if((numbers[low] + numbers[mid]) > target) {
                        end = mid-1;
                    }else if((numbers[low] + numbers[mid]) < target) {
                        start = mid+1;
                    }else{
                        end = mid;
                        break;
                    }
                }
                if((numbers[low] + numbers[end]) > target) end--;
                high = end;
            }else if((numbers[low] + numbers[high]) < target) {
                int start = low;
                int end = high-1;
                while(start < end) {
                    int mid = (start+end)/2;
                    if((numbers[high] + numbers[mid]) > target) {
                        end = mid-1;
                    }else if((numbers[high] + numbers[mid]) < target) {
                        start = mid+1;
                    }else{
                        end = mid;
                        break;
                    }
                }
                if((numbers[end] + numbers[high]) < target) end++;
                low = end;
            }else{
                break;
            }
        }
        return new int[]{low+1, high+1};
    }

    //0ms
    public static int[] twoSum3(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(numbers[i]+numbers[j]!=target){
            if (numbers[i]+numbers[j]>target) {
                int l = i+1,r=j;
                while(l<r){
                    int  m=(l+r)/2;
                    if(numbers[i]+numbers[m]>target){
                        r=m;
                    }else if (numbers[i]+numbers[m]<target) {
                        l=m+1;
                    }else {
                        break;
                    }
                }
                j=r-1;
            }else {
                int l = i,r=j-1;
                while(l<r){
                    int  m=(l+r+1)/2;
                    if(numbers[j]+numbers[m]>target){
                        r=m-1;
                    }else if (numbers[j]+numbers[m]<target) {
                        l=m;
                    }else {
                        break;
                    }
                }
                i=l+1;
            }
        }
        return new int[]{i+1,j+1};
    }
}
