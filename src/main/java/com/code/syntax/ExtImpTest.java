/**
 * 
 */
package com.code.syntax;

/**
 * Jiaxu
 * Sep 28, 2016
 * 
 */
public class ExtImpTest {

	
	public static void main(String argv[]){
		ExtImpTest extImpTest = new ExtImpTest();
		I_A a = extImpTest.new C_A();
		I_B b = extImpTest.new C_B();
		C_A c_A = extImpTest.new C_C();
		I_A c_A2 = extImpTest.new C_C();
//		I_B c_A2 = extImpTest.new C_C(); //error
		C_B c_B = extImpTest.new C_D();  
	}
	
	public class C_A implements I_A,I_B{
		
	}
	public class C_C extends C_A implements I_A,I_B{
		
	}
	public class C_D extends C_B implements I_A,I_B{
		
	}
	
	public class C_B implements I_B{
		
	}
	
	
	public interface I_A {
		
	}		
	public interface I_B {
		
	}		
}
