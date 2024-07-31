package com.cosy.sun.jdk.morethread.completionservice;

public class Run {

//	public static void main(String[] args) {
//		List<Callable<String>> callableList = new ArrayList<>();
//		for(int i=0;i<5;i++) {
//			callableList.add(new MyCallable("username" + (i+1), 10000));
//		}
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
//				new LinkedBlockingDeque<Runnable>());
//		CompletionService<String> csref = new ExecutorCompletionService<>(executor);
//		for(int i=0;i<5;i++) {
//			csref.submit(callableList.get(i));
//		}
//		for(int i=0;i<5;i++) {
//			System.out.println("等待带引第" + (i + 1) + "个返回值");
//			try {
//				System.out.println(csref.take().get());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//	@SuppressWarnings("all")
//	public static void main(String[] args) {
//		ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//		CompletionService csref = new ExecutorCompletionService<>(threadPool);
//		csref.submit(new Callable<String>() {
//
//			@Override
//			public String call() throws Exception {
//				Thread.sleep(3000);
//				System.out.println("3秒到了");
//				return "szh 3秒";
//			}
//		});
//
//		try {
//			Thread.sleep(5000);
//
//			System.out.println(csref.poll());
//			System.out.println(csref.poll().get());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
