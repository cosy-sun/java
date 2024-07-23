package com.cosy.sun.algorithm.design.builderpartner;

public interface Car<T> {

	public void builderDoor();
	
	public void builderCarBody();
	
	public void builderTyre();
	
	public T getResult();
	
}
