package com.cosy.sun.jdk8.annotation_expand;

public class Deduction<T> {

	@SuppressWarnings("unchecked")
	public static<T> T defaultValue() {
		return (T) "defaultValue";
	}
	
	public T getValue(T value, T defaultValue) {
		return (value != null)? value : defaultValue; 
	}
	
}
