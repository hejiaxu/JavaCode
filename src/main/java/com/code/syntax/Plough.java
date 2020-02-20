/**
 * 
 */
package com.code.syntax;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @title Plough.java
 * @author Jiaxu
 * @date Apr 28, 2016
 * @description
 * @version 1.0
 */
public class Plough {

	public static void main(String[] args) {
		int b;
		StringBuffer sb = new StringBuffer("输入字符为");
		try {
			System.out.println("Please Input:");
			while((b = System.in.read()) != '\n'){
			 sb.append((char)b);
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO 
			System.out.println(e.toString());
		}
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	}
}
