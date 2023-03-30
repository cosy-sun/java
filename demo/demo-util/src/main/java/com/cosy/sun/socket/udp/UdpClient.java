package com.cosy.sun.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		
		DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];
        String str = new String("发送到服务器");
        dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
        		InetAddress.getByName("localhost"), 3000);
        //发送一些数据包到服务器 , 如果服务器收到了将返回
        ds = new DatagramSocket();
        ds.send(dp);
        
        ds = new DatagramSocket(10001);
        dp = new DatagramPacket(buf, 1024);
        // 接收数据，放入数据包
        ds.receive(dp);
        // 从数据包中取出数据
        String info = new String(dp.getData(),0, dp.getLength());
        System.out.println("接收到的信息是：" + info);
		
	}
	
}
