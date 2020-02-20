/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 11, 2017
 * 
 */
public class L0169MajorityElement {

	public static void main(String[] args) {
		// TODO 

	}

	//34ms
	public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        return findKth(nums, mid);
    }

	private int findKth(int[] nums, int k) {
		return findKthSort(nums,0,nums.length-1,k);
	}

	private int findKthSort(int[] nums, int i, int j, int k) {
		int l = j, r = j;
		while(l > i){
			if (nums[l] < nums[i]) {
				swap(nums, l, r--);
			}
			l--;
		}
		swap(nums, l, r);
		if (r == k) {
			return nums[k];
		}else if (r < k) {
			return findKthSort(nums, r + 1, j, k);
		}else {
			return findKthSort(nums, i, r - 1, k);
		}
	}

	private void swap(int[] nums, int i, int r) {
		// TODO 
		int tmp = nums[i];
		nums[i] = nums[r];
		nums[r] = tmp;
	}
	
	//3ms
	 public int majorityElement2(int[] num) {

	        int major=num[0], count = 1;
	        for(int i=1; i < num.length;i++){
	            if(count == 0){
	                count++;
	                major = num[i];
	            }else if(major == num[i]){
	                count++;
	            }else count--;
	            
	        }
	        return major;
	    }
	 
	 //16ms
	 public int majorityElement3(int[] num) {

		    int ret = 0;

		    for (int i = 0; i < 32; i++) {

		        int ones = 0, zeros = 0;

		        for (int j = 0; j < num.length; j++) {
		            if ((num[j] & (1 << i)) != 0) {
		                ++ones;
		            }
		            else
		                ++zeros;
		        }
		        if (ones > zeros)
		            ret |= (1 << i);
		    }
		    
		    return ret;
		}
}
