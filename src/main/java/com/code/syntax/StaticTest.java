/**
 * 
 */
package com.code.syntax;

/**
 * @title test1.java
 * @author Jiaxu
 * @date Apr 28, 2016
 * @description
 * @version 1.0
 */
public class StaticTest {
	public static void main(String[] args) { 
		staticFunction();
		System.out.println("b="+b);
		/*
			1
			2
			3
			a=110 b=0
			4
			b=112
		 */
	}
	
	static StaticTest st = new StaticTest();
	static {
		System.out.println("1");
	}
	{
		System.out.println(2);
	}
	
	/**
	 * 
	 */
	public StaticTest() {
		// TODO
		System.out.println("3");
		System.out.println("a="+a+" b="+b);
	}
	public static void staticFunction(){
		System.out.println(4);
	}
	
	int a=110;
	static int b= 112;
}
