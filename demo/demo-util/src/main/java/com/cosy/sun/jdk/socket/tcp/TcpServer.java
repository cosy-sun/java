package com.cosy.sun.jdk.socket.tcp;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket accept = null;
		try {
			//监听端口10000
			serverSocket = new ServerSocket(10000);
			while (true) {
				//等待客户端访问
				accept = serverSocket.accept();
				System.out.println("TcpClient进来了");
				//获取socket的输入流,读取client传进来的数据
				InputStream inputStream = accept.getInputStream();
				int available = inputStream.available();
				byte[] b = new byte[available];
				inputStream.read(b);
				System.out.println("client输入进来的数据是:" + b);
				
				//处理完client传入的数据之后,再返回相应给client
				PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
				printWriter.write("return something !");
				System.out.println("return something !");
				printWriter.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				accept.close();
				serverSocket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
