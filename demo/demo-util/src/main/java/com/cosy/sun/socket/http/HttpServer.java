package com.cosy.sun.socket.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(10000);
		System.out.println("等待客户端的访问!");
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("客户端连接进来了!");
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			char[] c = new char[1024];
			bufferedReader.read(c);
			String str = new String(c);
			String[] split = str.split("\n");
			for (int i = 0; i < split.length; i++) {
				System.out.print(split[i]);
				parse(split[i],socket);
				System.out.println("-------------------------");
			}
			socket.close();
		}

	}

	private static void parse(String str, Socket socket) throws Exception {
		String[] strings = str.split(" ");
		switch (strings[0]) {
		case "GET":
			System.out.println("请求方式是get!");
			System.out.println("请求的资源路径是: "+strings[1]);
			if("/login".equals(strings[1])) {
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.print("login success!");
				printWriter.flush();
				printWriter.close();
			}
			String[] split = strings[2].split("/");
			System.out.println("协议名是: "+ split[0]);
			System.out.print("协议版本是: " + split[1]);
			break;
		case "POST":
			System.out.println("请求方式是post!");
			break;
		case "Host:":
			System.out.println("ip地址和端口号");
			break;
		case "User-Agent:":
			System.out.println("user-agent域");
			break;
		case "Accept:":
			System.out.println("客户接受的数据类型");
			break;
		case "Accept-Language:":
			System.out.println("accept-language域");
			break;
		case "Accept-Encoding:":
			System.out.println("Accept-Encoding域");
			break;
		case "Connection:":
			System.out.println("Connection域");
			break;
		case "Upgrade-Insecure-Requests:":
			System.out.println("");
		}
	}

}
