package com.cosy.sun.remote.netty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cosy.sun.serial.Serializable;
import com.cosy.sun.zip.Zip;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

@Component
public class EchoDecoder extends ByteToMessageDecoder {

	@Resource(name = "${rpc.policy.zip}")
	private Zip zip;
	
	@Resource(name = "${rpc.policy.serial}")
	private Serializable serial;
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		String type = readFromIn(ctx, in, String.class);
		Object body = readFromIn(ctx, in, Class.forName(type));
		out.add(body);
	}
	
	private <T> T readFromIn(ChannelHandlerContext ctx, ByteBuf in, Class<T> clazz) {
		if(in.readableBytes() < 4) {
			return null;
		}
		int typeLength = in.readInt();
		if(typeLength < 0) {
			ctx.close();
		}
		if(in.readableBytes() < typeLength) {
			in.resetReaderIndex();
			return null;
		}
		byte[] readByte = new byte[typeLength];
		in.readBytes(readByte);
		return serial.deSerialzer(zip.unzip(readByte), clazz);
	}

}
