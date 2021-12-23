package com.sun.morethread.executorservice;

import java.util.concurrent.Callable;

public class MyCallable1 implements Callable<String> {

	public String call() throws InterruptedException {

		System.out.println("Mycallable1 begin " + System.currentTimeMillis());
		for (int i = 0; i < 193456; i++) {
			Math.random();
			Math.random();
			Math.random();
		}
		System.out.println("Mycallable1 end" + System.currentTimeMillis());
		return "Mycallable1";
	}

}

class Mycallable1A implements Callable<String> {
	public String call() throws InterruptedException {
		try {
			
		System.out.println("Mcallable1A begin " + System.currentTimeMillis());
		for (int i = 0; i < 103456; i++) {
			Math.random();
			Math.random();
			Math.random();
		}
		if(true){
			System.out.println("抛出异常中断了,Mycallable1A");
			throw new NullPointerException();
		}
		System.out.println("Mycallable1A end" + System.currentTimeMillis());
		}catch(Exception e) {
			System.out.println("将异常抛出到最顶层!");
			throw e;
		}
		return "Mycallable1A";
	}
}

class Mycallable1B implements Callable<String> {
	public String call() throws InterruptedException {
		try {
			
		System.out.println("Mcallable1B begin " + System.currentTimeMillis());
		for (int i = 0; i < 103456; i++) {
			Math.random();
			Math.random();
			Math.random();
		}
		if(true){
			System.out.println("抛出异常中断了,Mycallable1A");
			throw new NullPointerException();
		}
		System.out.println("Mycallable1B end" + System.currentTimeMillis());
		}catch(Exception e) {
			System.out.println("将异常抛出到最顶层!");
			throw e;
		}
		return "Mycallable1B";
	}
}

class Mycallable2 implements Callable<String> {
	public String call() throws InterruptedException {
		System.out.println("Mycallable2 begin " + System.currentTimeMillis());
		for (int i = 0; i < 22345; i++) {
			Math.random();
			Math.random();
			Math.random();
		}
		System.out.println("Mycallable2 end" + System.currentTimeMillis());
		return "Mycallable2";
	}
}

class Mycallable22 implements Callable<String> {
	public String call() throws InterruptedException {
		System.out.println("Mycallable2 begin " + System.currentTimeMillis());
		for (int i = 0; i < 22345; i++) {
			if (Thread.currentThread().isInterrupted() == false) {

				Math.random();
				Math.random();
				Math.random();
			} else {
				System.out.println("Mycallable22异常中断了");
				throw new InterruptedException();
			}
		}
		System.out.println("Mycallable2 end" + System.currentTimeMillis());
		return "Mycallable22";
	}
}

class Mycallable33 implements Callable<String> {
	public String call() throws InterruptedException {
		try {
			
		System.out.println("Mycallable33 begin " + System.currentTimeMillis());
		for (int i = 0; i < 22324; i++) {
			if (Thread.currentThread().isInterrupted() == false) {

				Math.random();
				Math.random();
				Math.random();
			} else {
				System.out.println("Mycallable22异常中断了");
				throw new InterruptedException();
			}
		}
		}catch(Exception e) {
			System.out.println("抛出异常,并且被捕获");
			e.printStackTrace();
		}
		return "return mycallable33";
	}
}
