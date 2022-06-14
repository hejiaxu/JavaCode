/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 21, 2017
 * 
 */
public class L0050PowXN {
	public static void main(String[] args) {
		int a = -2147483648;
		int b = 0-a;
		System.out.println(b);
		System.out.println(0>a);
		System.out.println(0>-a);
		double myPow = myPow2(2, -3);
		
		System.out.println(myPow);
	}
	
	
	//28ms
	public static double myPow(double x, int m) {
        long n= m;
        		if (n==0) {
			return 1;
		}else if (n==1) {
			return x;
		}  
		boolean sign = false;
		if (n<0) {
			sign=true;
			n=-n;
		}
        double ex = 1;
        if (n%2==1) {
			ex=x;
		}
        double tmp = myPow(x, (int)(n/2));
        double r = tmp*tmp*ex;
        if (sign) {
			r=1/r;
		}
        return r;
    }
	//22ms
	public static double myPow2(double x, int n) {
		if (n==0) return 1;
		double ex = x;
		if (n%2==0)ex=1;
		else if (n<0)ex=1/x;
		double tmp = myPow(x, n/2);
		return tmp*tmp*ex;
	}
}

// 循环二分或者递归都可以实现
// 注意x可以为0,n可能为非正数
