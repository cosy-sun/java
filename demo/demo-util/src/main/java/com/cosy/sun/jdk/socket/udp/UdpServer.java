package com.cosy.sun.jdk.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = null;
		//监听端口3000
		datagramSocket = new DatagramSocket(3000);
		DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
		//将接受到的消息芳在datagrampacket数据包中,
		datagramSocket.receive(dp);
		//从数据包中获取到数据,可以使用不同的方法获取到不同的数据
		byte[] data = dp.getData();
		String string = new String(data, 0, data.length);
		System.out.println("接受到客户端的信息: "+string);
		//将此字符串返回给客户端
		String str = "打包一些东西返回给客户端";
		//构造方法中的端口号和地址,具体确定了将数据发送到什么地方
		DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length,
				InetAddress.getByName("localhost"), 10001);
		//发送数据包
		datagramSocket.send(datagramPacket);
	}

}
