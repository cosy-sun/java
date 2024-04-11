package com.cosy.sun.api.rpc;

import com.cosy.sun.anno.RpcClient;

@RpcClient("${cosysun.server.api}")
public interface DemoRpcApi {

	public String test();
	
}
