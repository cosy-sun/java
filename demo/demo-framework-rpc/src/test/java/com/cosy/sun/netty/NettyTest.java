package com.cosy.sun.netty;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

import com.cosy.sun.remote.model.RpcModel;
import com.cosy.sun.remote.model.RpcParam;
import com.cosy.sun.remote.netty.EchoClient;
import com.cosy.sun.remote.netty.EchoServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyTest {

	@Test
	public void testNettyServer() throws Exception {
		EchoServer echoServer = new EchoServer();
		echoServer.run(null);
	}
	
	@Test
	public void testNettyClient() {
		try {
			EchoClient echoClient = new EchoClient();
			RpcModel model = new RpcModel();
			RpcParam param = new RpcParam();
			
			param.setMethodName("rpc");
			param.setServerName("test-rpc");
			model.setId("123");
			model.setParam(param);
			LinkedBlockingQueue<Object> send = (LinkedBlockingQueue<Object>) echoClient.send(model);
			param.setMethodName("test");
			model.setId("456");
			model.setParam(param);
			LinkedBlockingQueue<Object> send1 = (LinkedBlockingQueue<Object>) echoClient.send(model);
			System.out.println(send.take());
			System.out.println(send1.take());
		} catch (Exception e) {
			log.info("", e);
		}
	}
	
	
}
