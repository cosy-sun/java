package com.cosy.sun.jdk.design.flyweight;

public class Unshared {

	private String info;
	
	public Unshared(String info) {
		this.info = info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return this.info;
	}
}
