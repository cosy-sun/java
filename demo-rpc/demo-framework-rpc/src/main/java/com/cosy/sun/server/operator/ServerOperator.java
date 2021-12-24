package com.cosy.sun.server.operator;

public interface ServerOperator {

	public void deleteServer(String serviceName);
	
	public Object getServer(String serviceName);

	public void addServer(String serviceName, String addr, Class<?> clazz, String zkAddr);
	
}
