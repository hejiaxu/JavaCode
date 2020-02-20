/**
 * 
 */
package com.code.syntax;

/**
 * @title DynamicTest.java
 * @author Jiaxu
 * @date Apr 28, 2016
 * @description
 * @version 1.0
 */
public class DynamicTest {

		public static void main(String[] args) {
//			A a = new B();
//			System.out.println(a.a);
			A a = new B();
			System.out.println(a.a);
			a.display();
		}

		static class A {
			public int a = 10;

			public A() {
				a = 11;
				display();
			}

			public void display() {
				System.out.println("i am in A a=" + a);
			}
		}

		static class B extends A {
			int a = 20;

			public B() {
				a = 21;
				display();
			}

			public void display() {
				System.out.println("i am in B a=" + a);

			}
		}

}
