/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “L0412FizzBuzz”.
 */
public class L0412FizzBuzz {

	public static void main(String[] args) {
		// TODO 
		L0412FizzBuzz fizzBuzz = new L0412FizzBuzz();
		List<String> fizzBuzz2 = fizzBuzz.fizzBuzz(15);
		System.out.println(fizzBuzz2);
	}
	
	//4ms
	public List<String> fizzBuzz(int n) {
		String fizz = "Fizz";
		String buzz = "Buzz";
		String fizzBuzz = "L0412FizzBuzz";
		List<String> strs = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			boolean mod3 = i%3 == 0;
			boolean mod5 = i%5 == 0;
			if (mod3 && mod5) {
				strs.add(fizzBuzz);
			}else if (mod3) {
				strs.add(fizz);
			}else if (mod5){
				strs.add(buzz);
			}else {
				strs.add(String.valueOf(i));
			}
		}
        return strs;
    }
	//3ms
	public List<String> fizzBuzz2(int n) {
		String fizz = "Fizz";
		String buzz = "Buzz";
		String fizzBuzz = "L0412FizzBuzz";
		List<String> strs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			boolean mod3 = i%3 == 0;
			boolean mod5 = i%5 == 0;
			if (mod3 && mod5) {
				strs.add(fizzBuzz);
			}else if (mod3) {
				strs.add(fizz);
			}else if (mod5){
				strs.add(buzz);
			}else {
				strs.add(String.valueOf(i));
			}
		}
		return strs;
	}
}
