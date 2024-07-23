package com.cosy.sun.algorithm.design.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

	
	private Map<String, OneFlyweight> flyweights = new HashMap<>();
	
	public FlyWeightFactory(String name) {
		System.out.println(name +  "被创建");
	}
	
	public FlyWeight getFlyweight(String key)  {
		OneFlyweight oneFlyweight = flyweights.get(key);
		if(oneFlyweight == null) {
			oneFlyweight = new OneFlyweight(key);
			flyweights.put(key, oneFlyweight);
		}
		return oneFlyweight;
	}
	
}
