package com.cosy.sun.remote.netty;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosy.sun.remote.model.HeartModel;
import com.cosy.sun.remote.model.RpcModel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter{

	@Autowired
	private EchoClient client;
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.info("", cause);
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			log.info("接收到服务器返回的响应:{}", msg.toString());
			if(msg instanceof HeartModel) {
				log.info("hert check: {}", msg);
				return ;
			}
			RpcModel model = (RpcModel) msg;
			client.getResMap().get(model.getId()).add(model.getParam());
		} finally {
			ReferenceCountUtil.release(msg);
		}
		
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleState state = ((IdleStateEvent) evt).state();
			if(state == IdleState.WRITER_IDLE) {
				Channel channel = client.getChannel((InetSocketAddress) ctx.channel().remoteAddress());
				channel.writeAndFlush(new HeartModel());
			}
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}
	
}
