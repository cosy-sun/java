//package com.cosy.sun.algorithm.design.invocationproxy;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//
//public class MainTest {
//
//	public static void main(String[] args) throws Exception {
//
//		//最简单的直接生成动态代理类实例
//		Student stu = new Student("sunzhenhua");
//		StuInvocationHandler<Person> stuInvocation = new StuInvocationHandler<Person>(stu);
//		Object instance = Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] {Person.class}, stuInvocation);
//		((Person)instance).giveMoney(234);
//
//
//
//
//		//先生成代理类，在生成构造函数，在生成实例
//		Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class<?>[] {Person.class});
//		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
//		Object newInstance = constructor.newInstance(stuInvocation);
//		((Person)newInstance).giveMoney(1234);
//
//	}
//
//}
