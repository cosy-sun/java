package com.cosy.sun.algorithm.design.cloneTest;

public abstract class BaseClone implements Cloneable {

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
