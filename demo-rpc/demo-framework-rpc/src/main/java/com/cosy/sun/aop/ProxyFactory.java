package com.cosy.sun.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cosy.sun.anno.RpcClient;
import com.cosy.sun.remote.RpcSendRequest;
import com.cosy.sun.remote.model.RpcModel;
import com.cosy.sun.remote.model.RpcParam;
import com.cosy.sun.utils.UUIDUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProxyFactory implements InvocationHandler {

	@Resource(name = "${rpc.policy.tcp}")
	private RpcSendRequest rpcSendRequest;
	
	private String serverName;

	
	public <T> T getProxy(Class<T> clazz) {
		log.info("获取class: {}的代理类.", clazz.getName());
		T cast = clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, this));
		this.serverName = clazz.getAnnotation(RpcClient.class).value();
		return cast;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("执行 method{}, args{}", method.getName(), args);
		RpcModel model = new RpcModel();
		RpcParam param = new RpcParam();
		param.setServerName(serverName);
		param.setMethodName(method.getName());
		param.setParamTypes(method.getParameterTypes());
		param.setParamValues(method.getParameters());
		model.setId(UUIDUtils.uuid());
		model.setParam(param);
		Object send = rpcSendRequest.send(model);
		LinkedBlockingQueue<Object> queue = (LinkedBlockingQueue<Object>) send;
		Object poll = queue.take();
		return poll;
	}
	
	
	
}
