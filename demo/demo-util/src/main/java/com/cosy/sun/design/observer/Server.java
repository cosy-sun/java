package com.cosy.sun.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Server implements Observerable{

	private List<Observer> list = new ArrayList<>();
	
	private String message = null;
	
	@Override
	public void register(Observer o) {
		list.add(o);
	}

	@Override
	public void remove(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < list.size(); i ++) {
			Observer observer = list.get(i);
			observer.update(message);
		}
	}
	
	public void setInformation(String message) {
		this.message = message;
		notifyObserver();
	}

}
