package com.cosy.sun.remote;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.exception.RpcException;
import com.cosy.sun.remote.model.RpcModel;
import com.cosy.sun.remote.model.RpcParam;
import com.cosy.sun.server.operator.ServerOperator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RpcHandlerRequest {

	@Autowired
	private ServerOperator serverOperator;
	
	public Object handle(RpcModel req) { 
		Object server = serverOperator.getServer(((RpcParam) req.getParam()).getServerName());
		return invoke(server, req);
	}
	
	public Object invoke(Object server, RpcModel req)  {
		try {
			Method method = server.getClass().getMethod(((RpcParam) req.getParam()).getMethodName(), 
					((RpcParam) req.getParam()).getParamTypes());
			Object invoke = method.invoke(server, ((RpcParam) req.getParam()).getParamValues());
			return invoke;
		} catch (Exception e) {
			log.error("处理异常", e);
			throw new RpcException(e);
		}
	}
	
}
