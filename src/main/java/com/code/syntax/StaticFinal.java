/**
 * 
 */
package com.code.syntax;

/**
 * Jiaxu
 * Mar 17, 2017
 * 
 */
public class StaticFinal {
	public static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		sb.append("aaa");
		System.out.println(sb.toString());
		sb.append("vdvsv");
		System.out.println(sb.toString());
	}
}
