//package com.cosy.sun.jdk.newj.jdk8.stream;
//
//import java.time.Duration;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.OptionalLong;
//import java.util.concurrent.*;
//import java.util.stream.LongStream;
//
//public class ForkJoin {
//
//	public void test1() {
//		String s = "szh";
//		int d = 10;
//		String format = String.format("111%s", s);
//		String a = String.format("%10d", d);
//		System.out.println(format);
//		System.out.println(a);
//	}
//
//	public void testThread() throws Exception {
//
//		class thread implements Callable<Long> {
//			private long start ;
//			private long end;
//			public thread(long start, long end) {
//				this.start = start;
//				this.end = end;
//			}
//			@Override
//			public Long call() throws Exception {
//				long i, sum = 0;
//				for (i = this.start; i<end; i++ ) {
//					sum += i;
//				}
//				return sum;
//			}
//		}
//		ExecutorService threadPool = Executors.newFixedThreadPool(12);
//		Instant start = Instant.now();
//		int threadNum = 12;
//		long aaa = 12000000000000L/12L;
//		List<Future<Long>> futurelist = new ArrayList<>();
//		for(long i =1; i<=threadNum; i++ ) {
//			System.out.println(i*aaa-aaa + "   " + i*aaa);
//			Future<Long> submit = threadPool.submit(new thread(i*aaa-aaa, i*aaa));
//			futurelist.add(submit);
//			System.out.println("单个县城"+submit.get());
//		}
//		int sum = 0;
//		for(Future<Long> future : futurelist) {
//			Long s = future.get();
//			sum +=s;
//		}
//		Instant end = Instant.now();
//		System.out.println(Duration.between(start, end).toMillis());
//		System.out.println(sum);
//
//
//
//	}
//
//	public void test() {
//		Instant before = Instant.now();
//		long sum = 0;
//		for(long i = 0; i < 100000000000L; i ++) {
//			sum += i;
//		}
//		System.out.println(sum);
//		Instant after = Instant.now();
//		System.out.println(Duration.between(before, after).toMillis());
//	}
//
//	public void testForkJoin() {
//
//
//		class ForkJoinTest extends RecursiveTask<Long> {
//
//			/**
//			 *
//			 */
//			private static final long serialVersionUID = -1489324931910161942L;
//			private long start;
//			private long end;
//			private long midd = 100000L;
//
//			public ForkJoinTest(long start, long end) {
//				this.start = start;
//				this.end= end;
//			}
//
//			@Override
//			protected Long compute() {
//				if(end - start > midd) {
//					long sum = 0L;
//					for (long i = start; i <= end; i++) {
//						sum += i;
//					}
//					return sum;
//				} else {
//					long mid = (end - start) / 2;
//					ForkJoinTest left = new ForkJoinTest(start, mid);
//					ForkJoinTest right = new ForkJoinTest(mid + 1, end);
//					left.fork();
//					right.fork();
//					return left.join() + right.join();
//				}
//			}
//
//		}
//
//		Instant start = Instant.now();
//		ForkJoinTask<Long> forkJoinTask = new ForkJoinTest(0L, 12000000000000L);
//		ForkJoinPool forkJoinPool = new ForkJoinPool();
//		Long t = forkJoinPool.invoke(forkJoinTask);
//		System.out.println(t);
//		Instant end = Instant.now();
//		System.out.println("一百亿求和耗费的时间为： " + Duration.between(start, end).toMillis());
//
//
//	}
//
//	public void testStream() {
//		Instant start = Instant.now();
//		//使用StreamAPI
//		OptionalLong result = LongStream.rangeClosed(0L, 100000000000L)
//		          .parallel()
//		          .reduce(Long::sum);
//		System.out.println(result.getAsLong());
//		Instant end = Instant.now();
//		System.out.println("1百亿求和耗费的时间为: " + Duration.between(start, end).toMillis());
//	}
//
//}
