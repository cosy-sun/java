package com.cosy.sun.morethread.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test7 {

	public static void main(String[] args) {
		
//		LinkedBlockingDeque<Runnable> linked = new LinkedBlockingDeque<>(2);
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, linked);
//		
//		System.out.println(linked.size());
//		
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		System.out.println(pool.getPoolSize()+"    "+linked.size());

//		ArrayBlockingQueue<Runnable> arrayblock = new ArrayBlockingQueue<>(55);
//		System.out.println(arrayblock.size());
//		
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, arrayblock);
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		pool.execute(new RunnableMy());
//		
//		System.out.println(pool.getPoolSize() + "     " + arrayblock.size());
		SynchronousQueue<Runnable> syn = new SynchronousQueue<>();
		System.out.println(syn.size());
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, syn);
		pool.execute(new RunnableMy());
		pool.execute(new RunnableMy());
		pool.execute(new RunnableMy());
		pool.execute(new RunnableMy());
		
		System.out.println(pool.getPoolSize() + "     " + syn.size());
	}
	
}
