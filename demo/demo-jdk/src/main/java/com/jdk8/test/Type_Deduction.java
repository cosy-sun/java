package com.jdk8.test;


import org.junit.Test;

import com.jdk8.annotation_expand.Deduction;

public class Type_Deduction {

	@Test
	public void test() {
		Deduction<Long> d = new Deduction<>();
		Object defaultValue = Deduction.defaultValue();
		System.out.println(defaultValue);
		Long value = d.getValue(1L, null);
		System.out.println(value.getClass());
	}
	
}
