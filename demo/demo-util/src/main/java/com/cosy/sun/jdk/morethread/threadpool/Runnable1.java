package com.cosy.sun.jdk.morethread.threadpool;

public class Runnable1 implements Runnable{

	@Override
	public void run() {

		try {
			for(int i=0;i<Integer.MAX_VALUE/50;i++) {
				@SuppressWarnings("unused")
				String s = new String();
				Math.random();
				Math.random()
				;
				Math.random();
				Math.random();
				if(Thread.currentThread().isInterrupted() == true) {
					System.out.println("interrupted!");
					throw new InterruptedException();
				}
				
			}
			System.out.println("success");
		} catch (InterruptedException e) {
			System.out.println("进入catch中断线程"+Thread.currentThread().getName());
			e.printStackTrace();
		}
		
	}

}
