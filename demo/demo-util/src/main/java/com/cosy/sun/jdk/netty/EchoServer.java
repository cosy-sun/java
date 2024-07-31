package com.cosy.sun.jdk.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class EchoServer implements Runnable {

	private static final int PORT = 11111;

//	public static void main(String[] args) {
//		new EchoServer().run();
//	}

	public void run() {
		System.out.println("启动服务");
		try {
			new ServerBootstrap()
				.group(new NioEventLoopGroup())
				.channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(PORT))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new IdleStateHandler(10, 0, 0, TimeUnit.SECONDS));
						ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(100000, 0, 4, 0, 4));
						ch.pipeline().addLast(new LengthFieldPrepender(4));
						ch.pipeline().addLast(new EchoServerHandler());
					}
				})
				.bind().sync().channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
