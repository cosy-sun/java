package com.cosy.sun.remote.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.exception.RpcException;
import com.cosy.sun.remote.RpcSendRequest;
import com.cosy.sun.remote.model.RpcModel;
import com.cosy.sun.remote.model.RpcParam;
import com.cosy.sun.server.register.ServerDiscovery;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Component
@Scope("singleton")
@Getter
@Slf4j
public class EchoClient implements RpcSendRequest {

	@Resource(name = "${rpc.policy.discovery}")
	private ServerDiscovery serverDiscovery;

	@Autowired
	private EchoClientHandler echoClientHandler;
	
	@Autowired
	private EchoEncoder encoder;
	
	@Autowired
	private EchoDecoder decoder;

	private Bootstrap bootstrap;

	private final ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();

	private final ConcurrentHashMap<String, LinkedBlockingQueue<Object>> resMap = new ConcurrentHashMap<>();

	public EchoClient() {
		this.bootstrap = 
				new Bootstrap()
				.group(new NioEventLoopGroup())
				.channel(NioSocketChannel.class)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.handler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast(new IdleStateHandler(0, 30, 0, TimeUnit.SECONDS));
						ch.pipeline().addLast(encoder);
						ch.pipeline().addLast(decoder);
						ch.pipeline().addLast(echoClientHandler);
					}
				});
	}

	public Channel getChannel(InetSocketAddress addr) {
		Channel channel = channelMap.get(addr.toString());
		if (channel == null) {
			LinkedBlockingQueue<Channel> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
			this.bootstrap
				.remoteAddress(addr)
				.connect()
				.addListener((ChannelFutureListener) future -> {
					if (future.isSuccess()) {
						linkedBlockingQueue.add(future.channel());
					} else {
						throw new RpcException("连接异常");
					}
				}).channel();
				try {
					channelMap.put(addr.toString(), channel = linkedBlockingQueue.take());
				} catch (InterruptedException e) {
					log.error("", e);
				}
		}
		return channel;
	}

	@Override
	public Object send(RpcModel req) {
		String serverName = ((RpcParam) req.getParam()).getServerName();
		InetSocketAddress service = serverDiscovery.getService(serverName);
		Channel channel = getChannel(service);
		LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
		resMap.put(req.getId(), linkedBlockingQueue);
		if (channel.isActive()) {
			channel.writeAndFlush(req);
		}
		return linkedBlockingQueue;
	}

}
