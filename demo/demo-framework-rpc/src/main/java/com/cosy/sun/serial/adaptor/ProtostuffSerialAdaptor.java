package com.cosy.sun.serial.adaptor;

import org.springframework.stereotype.Component;

import com.cosy.sun.serial.Serializable;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProtostuffSerialAdaptor implements Serializable {

	@SuppressWarnings("unchecked")
	@Override
	public byte[] serialzer(Object object) {
		log.info("序列化{}", object.toString());
		LinkedBuffer allocate = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		@SuppressWarnings("rawtypes")
		Schema schema = RuntimeSchema.getSchema(object.getClass());
		return ProtostuffIOUtil.toByteArray(object, schema, allocate);
	}

	@Override
	public <T> T deSerialzer(byte[] bytes, Class<T> classs) {
		log.info("反序列化{}", classs.getSimpleName());
		Schema<T> schema = RuntimeSchema.getSchema(classs);
		T newMessage = schema.newMessage();
		ProtostuffIOUtil.mergeFrom(bytes, newMessage, schema);
		return newMessage;
	}

	

}
