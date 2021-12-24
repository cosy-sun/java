package com.cosy.sun.remote.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cosy.sun.remote.RpcSendRequest;
import com.cosy.sun.remote.model.RpcModel;
import com.cosy.sun.remote.model.RpcParam;
import com.cosy.sun.server.register.ServerDiscovery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TcpClient implements RpcSendRequest {

	@Resource(name = "${rpc.policy.discovery}")
	private ServerDiscovery serverDiscovery;
	
	@Override
	public Object send(RpcModel req) {
		log.info("通过socket发送请求:{}", req.toString());
		InetSocketAddress service = serverDiscovery.getService(((RpcParam) req.getParam()).getServerName());
		try (Socket socket = new Socket(service.getAddress(), service.getPort());
				ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());) {
			dos.writeObject(req);
			dos.flush();
			return dis.readObject();
		} catch (UnknownHostException e) {
			log.error("", e);
		} catch (IOException e) {
			log.error("", e);
		} catch (ClassNotFoundException e) {
			log.error("", e);
		}
		return null;
	}
}
