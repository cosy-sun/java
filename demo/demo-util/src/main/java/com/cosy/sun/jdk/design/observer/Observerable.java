package com.cosy.sun.jdk.design.observer;

public interface Observerable {

	public void register(Observer o);
	public void remove(Observer o);
	public void notifyObserver();
	
}
