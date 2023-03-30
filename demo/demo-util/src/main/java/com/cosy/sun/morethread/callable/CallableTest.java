package com.cosy.sun.morethread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public class CallableT implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(5* 1000);
			return Thread.currentThread().getName();
		}
		
	}
	
	//@Test
	public void testCallable() throws Exception {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		Future<String> submit = newSingleThreadExecutor.submit(new CallableT());
		Future<String> submit2 = newSingleThreadExecutor.submit(new CallableT());
		String string = submit.get();
		String string2 = submit2.get();
		System.out.println(string + "----" + string2);
		System.out.println("直接过来了");
		
	}
	
}
