//package com.cosy.sun.jdk.socket.tcp;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//public class TcpClient {
//
//	public static void main(String[] args) {
//		Socket socket = null;
//		try {
//			socket = new Socket("172.20.64.115", 10000);
//			OutputStream outputStream = socket.getOutputStream();
//			String str = "client发送的数据";
//			outputStream.write(str.getBytes());
//
//			InputStream inputStream = socket.getInputStream();
//			byte[] bs = new byte[1024];
//			inputStream.read(bs);
//			String read = new String(bs);
//			System.out.println("return : "+ read);
//
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				socket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//	}
//
//}
