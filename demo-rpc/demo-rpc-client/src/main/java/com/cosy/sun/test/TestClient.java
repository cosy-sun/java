package com.cosy.sun.test;

import org.springframework.stereotype.Component;

import com.cosy.sun.api.rpc.DemoRpcApi;

@Component
public class TestClient {

	private DemoRpcApi testService;
	
	public void testService() {
		String test = testService.test();
		System.out.println(test);
	}
	
}
