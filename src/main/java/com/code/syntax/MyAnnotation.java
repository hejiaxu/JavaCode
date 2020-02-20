/**
 * 
 */
package com.code.syntax;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Jiaxu
 * Nov 15, 2016
 * 
 */
public class MyAnnotation {
	@MyTargetSOURCE
	public void doSomething() {
		System.out.println("source");
	}
	@MyTargetRUNTIME
	public void doSomething2() {
		System.out.println("runtime");
	}
	@MyTargetCLASS
	public void doSomething3() {
		System.out.println("CLASS");
	}
	@Override
	public void doSomething4() {
		System.out.println("Override");
	}
	public static void main(String[] args) {
		MyAnnotation annotation = new MyAnnotation();
		annotation.doSomething();
		annotation.doSomething2();
		annotation.doSomething3();
		annotation.doSomething4();
		try {
			Method method = MyAnnotation.class.getMethod("doSomething", null);
			Method method2 = MyAnnotation.class.getMethod("doSomething2", null);
			Method method3 = MyAnnotation.class.getMethod("doSomething3", null);
			Method method4 = MyAnnotation.class.getMethod("doSomething4", null);
			
			Method method5 = MyAnnotation.class.getMethod("doSomething",null);  
			if(method.isAnnotationPresent(MyTargetSOURCE.class))//如果doSomething方法上存在注解@MyTarget，则为true  
			{  
				System.out.println(method.getAnnotation(MyTargetSOURCE.class));  
			}
			if(method2.isAnnotationPresent(MyTargetRUNTIME.class))//如果doSomething方法上存在注解@MyTarget，则为true  
			{  
				System.out.println(method.getAnnotation(MyTargetRUNTIME.class));  
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO 
			e.printStackTrace();
		}
	}
	@Retention(RetentionPolicy.RUNTIME)  
	public @interface MyTargetRUNTIME{
		
	}
	@Retention(RetentionPolicy.SOURCE)  
	public @interface MyTargetSOURCE{
		
	}
	@Retention(RetentionPolicy.CLASS)  
	public @interface MyTargetCLASS{
		
	}
	
	
	@Retention(RetentionPolicy.SOURCE )  
	public @interface Override{
		
	}
	  
	@Retention(RetentionPolicy.SOURCE )  
	public @interface SuppressWarnings{
		
	}
	  
	@Retention(RetentionPolicy.RUNTIME )  
	public @interface Deprecated{
		
	}
	
	@Retention(RetentionPolicy.RUNTIME)  
	public @interface MyAnnotation2  
	{  
	 String hello() default "gege";  
	  String world();  
	  int[] array() default { 2, 4, 5, 6 };  	
	  TestAnnotation lannotation() default @TestAnnotation(value = "");  
	  Class style() default String.class;  
	} 
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestAnnotation{

		String value();
		
	}
}
