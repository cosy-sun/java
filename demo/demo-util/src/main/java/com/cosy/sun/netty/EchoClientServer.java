package com.cosy.sun.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import com.cosy.sun.netty.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

public class EchoClientServer {

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 11111;

	public static void main(String[] args) {
		new EchoClientServer()
			.start();
	}

	private void start() {
		try {
		ChannelFuture sync = new Bootstrap()
			.group(new NioEventLoopGroup())
			.channel(NioSocketChannel.class)
			.remoteAddress(new InetSocketAddress(HOST, PORT))
			.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS));
					ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(100000, 0, 4, 0, 4));
					ch.pipeline().addLast(new LengthFieldPrepender(4));
					ch.pipeline().addLast(new EchoClientHandler());
				}
			}).connect().sync();
		Channel channel = sync.channel();
		channel.writeAndFlush(Unpooled.copiedBuffer("请求数据".getBytes("UTF-8")));
		sync.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
