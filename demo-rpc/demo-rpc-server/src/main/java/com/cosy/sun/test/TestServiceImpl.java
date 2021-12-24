package com.cosy.sun.test;

import org.springframework.stereotype.Service;

import com.cosy.sun.api.rpc.DemoRpcApi;

@Service
public class TestServiceImpl implements DemoRpcApi {

	
	@Override
	public String test() {
		return "测试  test  rpc";
	}
	
}
