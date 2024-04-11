package com.cosy.sun.remote;

import com.cosy.sun.remote.model.RpcModel;

public interface RpcSendRequest {

	public Object send(RpcModel req);
	
}
