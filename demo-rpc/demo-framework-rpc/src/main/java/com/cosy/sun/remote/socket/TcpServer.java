package com.cosy.sun.remote.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cosy.sun.config.ServerConfigProperties;
import com.cosy.sun.remote.RpcHandlerRequest;
import com.cosy.sun.remote.model.RpcModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TcpServer implements ApplicationRunner {

	@Autowired
	private ServerConfigProperties config;

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	@Autowired
	private RpcHandlerRequest rpcHandlerRequest;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("开启serverSocket, 端口号:{}", config.getPort());
		try (ServerSocket serverSocket = new ServerSocket(config.getPort());) {
			Socket socket = null;
			while ((socket = serverSocket.accept()) != null) {
				// 获取socket的输入流,读取client传进来的数据
				executor.submit(new HandlerReq(socket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class HandlerReq implements Runnable {

		private Socket socket;

		HandlerReq(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try (ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());) {
				Object readObject = dis.readObject();
				Object handle = rpcHandlerRequest.handle((RpcModel)readObject);
				dos.writeObject(handle);
				dos.flush();
			} catch (Exception e) {
				log.error("", e);
			}
		}

	}

}
