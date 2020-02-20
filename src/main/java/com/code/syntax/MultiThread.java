/**
 * 
 */
package com.code.syntax;

/**
 * Jiaxu
 * Nov 21, 2016
 * 
 */
public class MultiThread {
	public static void main(String[] argv) {
		MultiThread multiThread = new MultiThread();
		Thread_y thread_y0 = multiThread.new Thread_y();
		Thread_y thread_y1 = multiThread.new Thread_y();
		Thread_y thread_y2 = multiThread.new Thread_y();
//		thread_y0.start();
//		thread_y1.start();
//		thread_y2.start();
		Thread_x thread_x0 = multiThread.new Thread_x();
		Thread_x thread_x1 = multiThread.new Thread_x();
		Thread_x thread_x2 = multiThread.new Thread_x();
//		new Thread(thread_x1).start();
//		new Thread(thread_x2).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
		new Thread(thread_x0).start();
	}
	
	public class Thread_y extends Thread{
		int num = 0;
		@Override
		public void run() {
			// TODO 
			while(num < 10){
				num++;
				System.out.println(num);
				System.out.println("---");
			}
			super.run();
		}
	}
	
	public class Thread_x implements Runnable{
		int num = 0;
		@Override
		public void run() {
			// TODO 
//			System.out.println("---");
			num++; 
			while(num < 10){
				num++; 
				System.out.println(num);
			}
		}
		
	}
	
}
