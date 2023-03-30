package com.cosy.sun.design.builderpartner;

public interface Car<T> {

	public void builderDoor();
	
	public void builderCarBody();
	
	public void builderTyre();
	
	public T getResult();
	
}
