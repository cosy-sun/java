package com.cosy.sun.jdk.newj.jdk8.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ForkJoin_ {

	public void test() {
		Stream<Integer> limit = Stream.iterate(1, (x) -> {
			return x + 1;
		}).limit(10);
		limit.peek(this::peek1).filter(x -> x > 5).peek(this::peek2).filter(x -> x < 8).peek(this::peek3)
				.forEach(System.out::println);

	}

	public void test2() {
		Stream<Integer> limit = Stream.iterate(1, (x) -> {
			return x + 1;
		}).limit(100).parallel();
		limit.peek(this::peek1).filter(x -> x > 5).peek(this::peek2).filter(x -> x < 8).peek(this::peek3)
				.forEach(System.out::println);
		System.out.println(set.size());
		set.forEach(System.out::println);
	}

	private Set<String> set = new HashSet<>();

	public void peek1(int x) {
		System.out.println(Thread.currentThread().getName() + " peek1  " + x);
		set.add(Thread.currentThread().getName());
	}

	public void peek2(int x) {
		System.out.println(Thread.currentThread().getName() + " peek2  " + x);
		set.add(Thread.currentThread().getName());
	}

	public void peek3(int x) {
		System.out.println(Thread.currentThread().getName() + " peek3  " + x);
		set.add(Thread.currentThread().getName());
	}

}
