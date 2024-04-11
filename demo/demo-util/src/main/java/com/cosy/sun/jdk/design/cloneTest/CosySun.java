package com.cosy.sun.jdk.design.cloneTest;

public abstract class CosySun implements Cloneable {

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			System.out.println("exception");
		}
		return o;
	}
	
}
