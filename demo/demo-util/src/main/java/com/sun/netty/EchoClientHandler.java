package com.sun.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf bs = (ByteBuf)msg;
//		byte[] b = new byte[bs.readableBytes()];
//		bs.readBytes(b);
//		String string = new String(b);
		System.out.println(msg);
	}
	
	
	
}
