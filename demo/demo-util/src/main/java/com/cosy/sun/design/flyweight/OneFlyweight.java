package com.cosy.sun.design.flyweight;

public class OneFlyweight implements FlyWeight{

	private String key;
	
	public OneFlyweight(String key) {
		this.key = key;
	}
	
	@Override
	public void operator(Unshared unshared) {
		
		System.out.println(key + "执行！");
		System.out.println(unshared.getInfo() + "不执行！");
		System.out.println(this);
		
	}

}
