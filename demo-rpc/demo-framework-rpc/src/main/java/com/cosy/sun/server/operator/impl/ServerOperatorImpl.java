package com.cosy.sun.server.operator.impl;

import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.exception.NullServiceException;
import com.cosy.sun.server.operator.ServerOperator;
import com.cosy.sun.server.register.ServerRegister;


@Component
public class ServerOperatorImpl implements ServerOperator {

	private static final ConcurrentHashMap<String, Class<?>> map = new ConcurrentHashMap<>();
	
	@Autowired
	private ConfigurableListableBeanFactory context;
	
	@Resource(name = "${rpc.policy.zk}")
	private ServerRegister serverRegister;

	@Override
	public void addServer(String serviceName, String addr, Class<?> clazz, String zkAddr) {
		serverRegister.register(serviceName, addr, zkAddr);
		map.put(serviceName, clazz);
		
	}
	
	@Override
	public void deleteServer(String serviceName) {
		
	}
	
	@Override
	public Object getServer(String serviceName) {
		Class<?> clazz = map.get(serviceName);
		if(clazz == null) {
			throw new NullServiceException("no service " + serviceName);
		}
		Object bean = context.getBean(clazz);
		return bean;
	}
	
}
