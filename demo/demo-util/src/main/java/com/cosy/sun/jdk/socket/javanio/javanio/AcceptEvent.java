package com.cosy.sun.jdk.socket.javanio.javanio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AcceptEvent implements Runnable{

	private ServerSocketChannel serverSocket;
	private Selector selector;
	
	public AcceptEvent(Selector selector, ServerSocketChannel serverSocket) {
		this.selector = selector;
		this.serverSocket = serverSocket;
	}
	
	public void run( ) {
		try {
			SocketChannel sc = serverSocket.accept(); // 接收连接，非阻塞模式下，没有连接直接返回 null
			if (sc != null) {
				// 把提示发到界面
				sc.write(ByteBuffer.wrap("Implementation of Reactor Design Partten by tonwu.net\r\nreactor> ".getBytes()));
				System.out.println("Accept and handler - " + sc.socket().getLocalSocketAddress());
				new BasicHandler(selector, sc); // 单线程处理连接
//				new MultithreadHandler(selector, sc); // 线程池处理连接
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
