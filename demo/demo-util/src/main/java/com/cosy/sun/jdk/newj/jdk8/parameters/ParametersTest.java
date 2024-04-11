package com.cosy.sun.jdk.newj.jdk8.parameters;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ParametersTest {

	public static void main(String[] args) throws Exception {
		Method method = ParametersTest.class.getMethod("test", String.class, String.class, int.class);
		Parameter[] parameters = method.getParameters();
		Arrays.asList(parameters).forEach((Parameter p) -> {
			System.out.println(p.getName());
		}); 
	}
	
	public void test(String a, String b, int a1) {
		
	}
	
}
