package com.cosy.sun.design.invocationproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {

	private T target;
	
	public StuInvocationHandler(T target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("执行方法 ： "+ method.getName());
		long a = 0L;
		System.out.println(a = System.currentTimeMillis());
		Object result = method.invoke(target, args);
		System.out.println(System.currentTimeMillis() - a);
		return result;
	}

	
	
}
