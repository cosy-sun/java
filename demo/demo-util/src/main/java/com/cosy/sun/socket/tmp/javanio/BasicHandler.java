package com.cosy.sun.socket.tmp.javanio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class BasicHandler implements Runnable{

	
	private final static int MAXINT = 1024;
	private final static int MAXOUT = 1024;
	
	private SocketChannel sc;
	private SelectionKey key;
	
	ByteBuffer input = ByteBuffer.allocate(MAXINT);
	ByteBuffer output = ByteBuffer.allocate(MAXOUT);
	
	private StringBuilder builder = new StringBuilder();
	
	private static final int READ = 0, WRITE = 1, CLOSED = 2;
	private int state = READ;
	
	public BasicHandler(Selector select, SocketChannel sc) throws Exception {
		this.sc = sc;
		sc.configureBlocking(false);
		key = sc.register(select, READ);
		key.interestOps(SelectionKey.OP_READ);
		key.attach(this);
		select.wakeup();
	}
	
	public void run() {
		try {
			if (state == READ)
				read(); 
			else if (state == WRITE)
				send(); 
		} catch (IOException ex) {
			try {
				key.channel().close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private void send() throws IOException {
		output.flip();
		int n  = -1;
		if(output.hasRemaining()) {
			n = sc.write(output);
		}
		boolean b = false;
		if(n <= 0) {
			b = true;
		} else {
			output.clear();
			builder.delete(0, builder.length());
			b = false;
		}
		if (b) {
			key.channel().close();
		}else {
			state = READ;
			key.interestOps(SelectionKey.OP_READ);
		}
		
		
	}
	
	private void read() throws IOException {
		input.clear();
		int inputt = sc.read(input);
		if(inputIsComplete(inputt)) {
			process();
			key.interestOps(SelectionKey.OP_WRITE);
		}
		
	}
	
	private boolean inputIsComplete(int n) {
		if(n > 0) {
			input.flip();
			while(input.hasRemaining()) {
				byte b = input.get();
				if(b == 3) {
					state = CLOSED;
					return true;
				} else if (b == '\r') {
					
				} else if (b == '\n') {
					state = WRITE;
					return true;
				} else {
					builder.append((char)b);
				}
			}
		}
		return false;
	}
	
	private void process() {
		if(state == WRITE) {
			output.put(builder.toString().getBytes());
		}
	}
	
}
