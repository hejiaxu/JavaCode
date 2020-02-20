/**
 * 
 */
package com.code.syntax;

/**
 * Jiaxu
 * Mar 17, 2017
 * 
 */
public class Equals {
	public static void main(String[] args) {
		String a = "aa";
		String b = "aa";
		String c = new String("aa");
		System.out.println(a.equals(b));//true
		System.out.println(a==b);//true
		System.out.println(a==c);//false
		System.out.println(a.equals(c));//true
	}
}
