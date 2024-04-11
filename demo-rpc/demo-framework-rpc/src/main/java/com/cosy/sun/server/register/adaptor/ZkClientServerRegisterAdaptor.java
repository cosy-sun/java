package com.cosy.sun.server.register.adaptor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cosy.sun.server.register.ServerRegister;

@Component
@Scope("singleton")
public class ZkClientServerRegisterAdaptor implements ServerRegister {

	@Override
	public void register(String serviceName, String addr, String zkAddr) {
		
	}


}
