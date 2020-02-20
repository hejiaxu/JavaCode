package com.code.leet;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class L0004MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {2};
        double medianSortedArrays = new L0004MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = (nums1.length + nums2.length + 1) / 2;
        int median2 = (nums1.length + nums2.length + 2) / 2;
        return (findKthInTwoSortedArray(nums1, nums2, median) + findKthInTwoSortedArray(nums1, nums2, median2)) / 2.0;
    }

    private double findKthInTwoSortedArray(int[] nums1, int[] nums2, int k) {
        return recur(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
    }

    private double recur(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1 > end1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > end2) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }
        int half = k / 2;
        int left = start1 + half - 1 < end1 ? start1 + half - 1: end1;
        int right = start2 + half - 1 < end2 ? start2 + half - 1: end2;
        if (nums1[left] < nums2[right]) {
            return recur(nums1, left + 1, end1, nums2, start2, end2, k - left + start1 - 1);
        }
        return recur(nums1, start1, end1, nums2, right + 1, end2, k - right + start2 - 1);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        int a = (m+n+1)/2;
        int b = (m+n+2)/2;
        return (findKth(nums1, 0, m, nums2, 0, n, a)+ findKth(nums1, 0, m, nums2, 0, n, b))/2.0;
    }


    public int findKth(int []s,int sStart,int sEnd,int[]t,int tStart,int tEnd,int k){
        if (tEnd-tStart>sEnd-sStart) {
            return findKth(t, tStart, tEnd, s, sStart, sEnd, k);
        }
        if (tEnd-tStart==0) {
            return s[sStart+k-1];
        }
        if (k==1) {
            return Math.min(s[sStart], t[tStart]);
        }
        int ti=Math.min(tEnd-tStart, k/2);
        if (s[sStart+ti-1]>=t[tStart+ti-1]) {
            return findKth(s, sStart, sEnd, t, tStart+ti, tEnd, k-ti);
        }

        return findKth(s, sStart+ti, sEnd, t, tStart, tEnd, k-ti);
    }
}
