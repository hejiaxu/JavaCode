/**
 * 
 */
package com.code.leet;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *  
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 * 
 */
public class L0371SumOfTwoIntegers {

	public static void main(String[] args) {
		// TODO 
		int sum = getSum(2,3);
		System.out.println(sum);
	}
	//0 ms
	public static int getSum(int a, int b) {
        if(b==0)return a;
        return getSum(a^b,(a&b)*2);
    }
	
	//0ms
	 public int getSum2(int a, int b) {
	    while ((a & b) != 0x00) {//check carry bit
	        final int x = (a & b) << 1;//same bit has carry
	        final int y = (a ^ b);     //different bit
	        a = x;
	        b = y;
	    }
	    return a | b;   
	 }
}

