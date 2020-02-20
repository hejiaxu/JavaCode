/**
 * 
 */
package com.code.leet;

/**
 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 */
public class L0507PerfectNumber {

	public static void main(String[] args) {
		// TODO 
		boolean checkPerfectNumber = checkPerfectNumber(28);
		System.out.println(checkPerfectNumber);
	}

	//13ms
	public static boolean checkPerfectNumber(int num) {
		if (num==1) {
			return false;
		}
		int result = 1;
		for(int i=2;i < Math.sqrt(num);i++){
			if (num%i==0) {
				result+=i+num/i;
			}
		}
		return result==num;
	}
}
