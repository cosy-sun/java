package com.cosy.sun.jdk.design.builderpartner;

public interface Car<T> {

	public void builderDoor();
	
	public void builderCarBody();
	
	public void builderTyre();
	
	public T getResult();
	
}
