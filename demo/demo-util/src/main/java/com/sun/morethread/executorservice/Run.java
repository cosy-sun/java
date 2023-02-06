package com.sun.morethread.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {

	public static void main(String[] args) throws Exception, Exception {
//		try {
//			
//		List<Callable<String>> list = new ArrayList<>();
//		list.add(new MyCallable1());
//		list.add(new MyCallable1());
//		
//		ExecutorService service = Executors.newCachedThreadPool();
//		String object = (String) service.invokeAny(list, 1, TimeUnit.MILLISECONDS);
//		System.out.println("======" + object);
//		System.out.println("zzzzzzzzzzzzzzz");
//		}catch(InterruptedException e) {
//			
//			System.out.println("InterruptedException catch");
//			e.printStackTrace();
//		}catch(ExecutionException e) {
//			System.out.println("ExceutionException catch");
//			e.printStackTrace();
//		}catch(TimeoutException e) {
//			System.out.println("timeoutException catch");
//			e.printStackTrace();
//		}
		try {
			List<Callable<String>> lsit = new ArrayList<>();
			lsit.add(new Callablee());
			lsit.add(new callablee1());
			
			ExecutorService pool = Executors.newCachedThreadPool();
			List<Future<String>> list = pool.invokeAll(lsit);
			for(int i=0; i<list.size(); i++) {
				System.out.println("result: "+list.get(i).get()+System.currentTimeMillis());
			}
		}catch(InterruptedException e) {
			System.out.println("进入InterruptedException catch中");
			e.printStackTrace();
		}catch(ExecutionException e) {
			System.out.println("进入ExceutionException catch中");
		}
	}
}
