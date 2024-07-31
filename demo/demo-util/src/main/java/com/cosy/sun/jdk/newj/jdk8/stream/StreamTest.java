//package com.cosy.sun.jdk.newj.jdk8.stream;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.Random;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//
//public class StreamTest {
//
//	/**
//	 * 函数式接口可以有两个方法，但是只有一个方法是本接口的，另外一个或者几个是object中的public方法
//	 *
//	 * @author cosy-sun
//	 *
//	 */
//	@FunctionalInterface
//	interface szh {
//		int sss();
//
//		public boolean equals(Object obj);
//	}
//
//	public void testa() {
//		boolean matches = Pattern.matches("", "aaaaa[");
//		System.out.println(matches);
//	}
//
//	public void parallel() {
//		Stream<Integer> stream = Stream.iterate(1, (x)-> x+1).limit(10);
//
//		stream.peek(this::peek1).filter(x -> x > 5)
//		.peek(this::peek2).filter(x -> x < 8)
//		.peek(this::peek3)
//		.forEach(System.out::println);
//		System.out.println("__________________________");
//		Stream<Integer> parallel = Stream.iterate(1, (x) -> x+1).limit(10).parallel();
//		parallel.peek(this::peek1).filter(x -> x > 5)
//        .peek(this::peek2).filter(x -> x < 8)
//        .peek(this::peek3)
//        .forEach(System.out::println);
//
//
//
//	}
//
//	public void peek1(int x) {
//        System.out.println(Thread.currentThread().getName() + ":->peek1->" + x);
//    }
//
//    public void peek2(int x) {
//        System.out.println(Thread.currentThread().getName() + ":->peek2->" + x);
//    }
//
//    public void peek3(int x) {
//        System.out.println(Thread.currentThread().getName() + ":->final result->" + x);
//    }
//
//	public void createStream() {
//
//		// 创建空的stram流
//		Stream<Object> empty = Stream.empty();
//		System.out.println(empty);
//
//		System.out.println("--------------------------");
//
//		// 通过集合创建
//		List<String> asList = Arrays.asList(new String[] { "1", "2" });
//		Stream<String> stream = asList.stream();
//		stream.forEach((String s) -> {
//			System.out.print(s);
//
//		});
//		System.out.println("\r--------------------------");
//
//		// 通过数组创建stream流
//		int[] int_array = { 0, 1, 2 };
//		IntStream stream2 = Arrays.stream(int_array);
//
//		stream2.forEach((s) -> {
//			System.out.println(s);
//		});
//
//		System.out.println("------------------------------");
//
//		// 创建无限流
//		Stream<String> limit = Stream.generate(() -> {
//			return "number_" + new Random().nextInt();
//		}).limit(5);
//		limit.forEach((String s) -> {
//			System.out.println(s);
//		});
//
//		System.out.println("-------------------------------");
//
//		// 创建有规律的无限流
//		Stream<Integer> limit2 = Stream.iterate(0, (x) -> {
//			return x + 1;
//		}).limit(10);
//		limit2.forEach((Integer x) -> {
//			System.out.print(x.toString() + "\t");
//		});
//		Stream.iterate(0, x -> x).limit(10).forEach(System.out::println);
//
//		// 创建并行流
//		Stream<String> parallelStream = asList.parallelStream();
//		System.out.println(parallelStream);
//	}
//
//	public void useStream() {
//
//		// 转换流
//		String[] sss = new String[] { "abc", "feawe", "DFWEEFFF" };
//		Stream<String> map = Arrays.stream(sss).map((String x) -> {
//			return x.toLowerCase();
//		});
//		map.forEach(System.out::println);
//		System.out.println("------------");
//		// 过滤流
//		Arrays.stream(sss).filter((String s) -> {
//			return s != "abc";
//		}).forEach(System.out::println);
//		System.out.println("----------------");
//
//		// 拆解流
//		String[] a = { "aaaa", "bbbb", "cccc" };
//
//		String[] b = { "dddd", "eeee", "ffff" };
//
//		Stream<String[]> of = Stream.of(a, b);
//		Stream<String> flatMap = of.flatMap(Arrays::stream);
//		flatMap.forEach(System.out::println);
//
//		System.out.println("--------------------");
//		// 对流进行排序
//		Stream<String> sorted = Arrays.stream(sss).sorted((String s1, String s2) -> {
//			return s1.compareTo(s2);
//		});
//		sorted.forEach(System.out::println);
//
//		System.out.println("-------------");
//
//		// 对流按照长度排序
//		Arrays.stream(sss).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
//
//		System.out.println("-----------------");
//		Arrays.stream(sss).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
//
//	}
//
//	public void useStreamAnd() {
//		Stream.iterate(0, x -> x + 1).skip(2).limit(10).forEach(System.out::println);
//	}
//
//	public void testtest() {
//		String[] arr1 = new String[] { "a", "b", "c", "d", "e" };
//		String[] arr2 = new String[] { "e", "f", "g", "h", "i" };
//		String[] arr3 = new String[] { "j", "k", "l", "m", "n" };
//		Stream<String> stream = Arrays.stream(arr1);
//		Stream<String> stream2 = Arrays.stream(arr2);
//		Stream<String> concat = Stream.concat(stream, stream2);
//		Stream<String> concat2 = Stream.concat(concat, Arrays.stream(arr3));
//		concat2.forEach(System.out::println);
//
//	}
//
//	public void testMaxAndMin() {
//		String[] arr = new String[] { "a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg" };
//
//		// 获取流中最大的和最小的
//		Stream.of(arr).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
//		Stream.of(arr).min(Comparator.comparing(String::length)).ifPresent(System.out::println);
//
//		// 计算流中的数量
//		long count = Stream.of(arr).count();
//		System.out.println(count);
//
//		Stream<String> parallel = Stream.of(arr).parallel();
//		Optional<String> sorted = parallel.filter(x -> x.startsWith("abcd")).findAny();
//		String string = sorted.get();
//		System.out.println(string);
//
//		boolean anyMatch = Stream.of(arr).anyMatch(x -> x.startsWith("a"));
//		System.out.println(anyMatch);
//	}
//
//	public void test() {
//
//		class Student {
//			private String string;
//			private int i;
//			public Student(String string, int i) {
//				this.string = string; this.i = i;
//			}
//			public String toString() {
//				return string+"---"+i;
//			}
//			public int get() {
//				return i;
//			}
//			public String getKey() {
//				return string + this.hashCode();
//			}
//		}
//
//		Student[] students = new Student[100];
//		for (int i = 0; i < 30; i++) {
//			Student student = new Student("user", i);
//			students[i] = student;
//		}
//		for (int i = 30; i < 60; i++) {
//			Student student = new Student("user" + i, i);
//			students[i] = student;
//		}
//		for (int i = 60; i < 100; i++) {
//			Student student = new Student("user" + i, i);
//			students[i] = student;
//		}
//
////		Stream<Student> stream = Arrays.stream(students);
////		List<Student> list = Arrays.stream(students).collect(Collectors.toList());
////		list.forEach(System.out :: println);
////
////		Set<Student> collect = Arrays.stream(students).collect(Collectors.toSet());
////		collect.forEach(System.out :: println);
////
////		Object[] array = Arrays.stream(students).toArray();
////		for(Object o: array) {
////			System.out.println(o);
////		}
////
//
//		Map<String, Integer> collect = Arrays.stream(students).collect(Collectors.toMap(Student :: getKey, Student :: get, (x, y) -> {
//			System.out.println(x + "      " + y);
//			return y;
//		}));
//		collect.forEach((x, y) -> {
//			System.out.println(x + "    " + y);
//		});
//		System.out.println(collect.keySet().size());
////		IntSummaryStatistics collect2 = Arrays.stream(students).collect(Collectors.summarizingInt(Student :: get));
////		System.out.println(collect2.getAverage());
////		System.out.println(collect2.getCount());
////		System.out.println(collect2.getMax());
////		System.out.println(collect2.getMin());
////		Map<String, List<Student>> collect = Arrays.stream(students).collect(Collectors.groupingBy(Student :: getString));
////		collect.forEach((String x, List<Student> y) ->{
////			y.forEach((Student student) -> System.out.println(x + "    _    " +student));
////		});
//
//
////		Map<Boolean, List<Student>> collect2 = Arrays.stream(students).collect(Collectors.partitioningBy((Student student)->student.get() >50));
////		collect2.forEach((x,y)-> {
////			y.forEach((Student student) -> {
////				System.out.println(x + "____" + student.getString());
////			});
////		});
//
////		Arrays.stream(students).collect(Collectors.groupingBy(Student :: getString, Collectors.toSet()))
////		.forEach((String s, Set<Student> y) -> {
////			y.forEach((Student student) -> {
////				System.out.println(s + "________" + student);
////			});
////		})
////		;
//
//
//	}
//
//}
