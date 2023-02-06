package com.jdk8.test;


import org.junit.Test;

import com.jdk8.annotation_repeatable.Szh;

public class Repeatable {

	@Test
	public void test() {
		
		Szh[] annotationsByType = cl.class.getAnnotationsByType(Szh.class);
		for(Szh annotation : annotationsByType) {
			System.out.println(annotation.value());
		}
		
	}
	
	@Szh("1")
	@Szh("2")
	public interface cl{
		
	}
	
}
