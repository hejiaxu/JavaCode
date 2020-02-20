/**
 * 
 */
package com.code.leet;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class L0026DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO 
		int divide = new L0026DivideTwoIntegers().divide(103,3);
//		int divide = new L0026DivideTwoIntegers().divide(-2147483648,-1);
//		int divide = new L0026DivideTwoIntegers().divide(2147483647,1);
//		int divide = new L0026DivideTwoIntegers().divide4(2147483647,3);
		System.out.println(divide);
	}

	
	//41ms
	public int divide(int dividend, int divisor) {
		long dd =dividend,dr = divisor;
		if (dr == 0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		boolean sign = false;
		if (dd < 0) {
			sign = !sign;
			dd = 0 - dd;
		}
		if (dr < 0) {
			sign =! sign;
			dr= 0 - dr;
		}
		result = divide(dd, dr);
		if (sign) {
			result = 0 - result;
		}
		if (result>Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		return (int)result;
	}

	public long divide(long dividend, long divisor) {
		long sum = 0, tmp=1, tmpDivisor=divisor;
		if (dividend<tmpDivisor) {
			return 0;
		}else if (dividend < tmpDivisor + tmpDivisor) {
			return 1;
		}else {
			while((tmpDivisor << 1) < dividend){
				tmpDivisor = tmpDivisor << 1;
				tmp = tmp << 1;
			}

			while(tmpDivisor >= divisor){
				if (dividend >= tmpDivisor) {
					sum += tmp;
					dividend -= tmpDivisor;
				}else{
					tmpDivisor = (tmpDivisor >> 1);
					tmp = (tmp >> 1);
				}
			}
			return sum;
		}                                                                                                                                                                                                                        
	}
}
