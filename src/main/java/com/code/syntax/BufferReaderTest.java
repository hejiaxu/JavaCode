/**
 * 
 */
package com.code.syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title test.java
 * @author Jiaxu
 * @date Jun 6, 2016
 * @description
 * @version 1.0
 */
public class BufferReaderTest {
	public static void main(String[] args) {
//		System.out.println(Float.parseFloat("1217.38"));
//
//        System.out.println(Float.compare(0, (float) 0.0));
//        System.out.println(1.5>2);
		long airTime = 86400000;
		System.out.println(airTime%(24*3600));
		long hh = airTime%(24*3600)/3600;
		long mm = airTime%3600/60;
		System.out.println(hh);
		System.out.println(mm);
		int a=0;
		a+=4071.5;
		a+=4071.5;
		a+=5485.26;
		a+=6394.26;
		a+=21474.27;
		a+=5485.26;
		a+=4071.5;
		a+=8526.34;
		a+=4071.5;
		a+=6835.26;
		a+=6572.51;
		System.out.println(a);
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			String line = null;
			while((line = bufferedReader.readLine()) != "exit")
				System.out.println(line);
		} catch (IOException e) {
			// TODO 
			e.printStackTrace();
		}
		
	}
}
