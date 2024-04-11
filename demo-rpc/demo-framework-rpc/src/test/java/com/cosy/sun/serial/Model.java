package com.cosy.sun.serial;

public class Model {
	private String a;
	private String b;

	public Model() {
		super();
	}

	public Model(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Model [a=" + a + ", b=" + b + "]";
	}

}