package com.cosy.sun.remote.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cosy.sun.config.ServerConfigProperties;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EchoServer implements ApplicationRunner {

	@Autowired
	private ServerConfigProperties config;
	
	@Autowired
	private EchoServerHandler echoServerHandler;
	
	@Autowired
	private EchoEncoder encoder;
	
	@Autowired
	private EchoDecoder decoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			new ServerBootstrap()
				.group(new NioEventLoopGroup())
				.channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(config.getPort()))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new IdleStateHandler(40, 0, 0, TimeUnit.SECONDS));
						ch.pipeline().addLast(encoder);
						ch.pipeline().addLast(decoder);
						ch.pipeline().addLast(echoServerHandler);
					}
				})
				.bind()
				.sync()
				.channel()
				.closeFuture()
				.sync();
		} catch (Exception e) {
			log.error("启动异常", e);
		}
	}

}
