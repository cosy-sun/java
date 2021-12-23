package com.cosy.sun.remote.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosy.sun.remote.RpcHandlerRequest;
import com.cosy.sun.remote.model.HeartModel;
import com.cosy.sun.remote.model.RpcModel;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Autowired
	private RpcHandlerRequest handler;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			log.info("接收到数据:{}", msg);
			if(msg instanceof HeartModel) {
				ctx.writeAndFlush(new HeartModel());
				return ;
			}
			RpcModel req = (RpcModel) msg;
			Object handle = handler.handle(req);
			RpcModel rpcModel = new RpcModel();
			rpcModel.setId(req.getId());
			rpcModel.setParam(handle);
			ctx.writeAndFlush(rpcModel);
		} catch (Exception e) {
			log.info("", e);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleState state = ((IdleStateEvent) evt).state();
			if (state == IdleState.READER_IDLE) {
				log.info("read_idle , so close");
				ctx.close();
			}
		}
		super.userEventTriggered(ctx, evt);
	}

}
