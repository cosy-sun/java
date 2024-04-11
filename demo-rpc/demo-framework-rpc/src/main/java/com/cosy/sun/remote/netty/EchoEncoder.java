package com.cosy.sun.remote.netty;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cosy.sun.serial.Serializable;
import com.cosy.sun.zip.Zip;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@Component
public class EchoEncoder extends MessageToByteEncoder<Object> {

	@Resource(name = "${rpc.policy.zip}")
	private Zip zip;
	
	@Resource(name = "${rpc.policy.serial}")
	private Serializable serial;
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
		write(msg.getClass().getName(), out);
		write(msg, out);
	}
	
	private void write(Object in, ByteBuf out) {
		byte[] body = zip.zip(serial.serialzer(in));
		out.writeInt(body.length);
		out.writeBytes(body);
	}

}
