package com.cosy.sun.jdk.newj.jdk8.lambda;

public class test {

	public static void main(String [] rags) {
//		Arrays.asList( "a", "b", "d" ).forEach( e -> {
//		    System.out.print( e );
//		} );
//		String separator = ",";
//		Arrays.asList( "a", "b", "d" ).forEach( 
//		    ( String e ) -> System.out.println( e + separator ) );
//		List<String> asList = Arrays.asList( "z", "b", "d" );
//		asList.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//			
//		});
//		asList.forEach(item -> System.out.println(item));
//		testa((int i) -> System.out.println("adbdsfew"));
		
//		testb((int i )-> {
//			System.out.println(i);
//		});
		
		testc((int i) -> {
			System.out.println("匿名内部类中的：" + i);
			return 10;
		});
		
		
	}
	
	public static void testa(TestInterface test) {
		test.test();
	}
	
	public static void testb(TestInterfaceone test) {
		int i= 0;
		test.test(i);
		
	}
	
	
	public static void testc(TestInterfaceTwo test) {
		int i = 89;
		int test2 = test.test(i);
		System.out.println("testc方法中：" +test2);
	}
	
	
}
