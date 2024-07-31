package com.cosy.sun.jdk.socket.javanio.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable{

	public static void main(String[] args) throws Exception {
		new Thread(new Reactor()).start();
	}
	
	private Selector selector;
	private final ServerSocketChannel serverSocket;
	private final int port = 12345;
	private SelectionKey register;
	public Reactor() throws Exception {
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		serverSocket.socket().bind(new InetSocketAddress(port));
		serverSocket.configureBlocking(false);
		register = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		register.attach(new AcceptEvent(selector, serverSocket));
		System.out.println("监听端口：" + this.port);
	}
	
	@Override
	public void run() {
		while(true) {
			 try {
				selector.select();
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while(iterator.hasNext()) {
					SelectionKey next = iterator.next();
					dispatch(next);
				}
				selectedKeys.clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
	}

	private void dispatch(SelectionKey key) {
		Runnable r = (Runnable)key.attachment();
		if(r!=null) r.run();
	}
	
}
