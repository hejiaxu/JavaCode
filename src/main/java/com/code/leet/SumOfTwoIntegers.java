/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Aug 29, 2016
 * 
 */
public class SumOfTwoIntegers {

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
