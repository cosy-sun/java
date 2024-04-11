package com.cosy.sun.serial.adaptor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Component;

import com.cosy.sun.common.exception.SerialException;
import com.cosy.sun.serial.Serializable;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KryoSerialAdaptor implements Serializable {

	private final ThreadLocal<Kryo> threadLocal = ThreadLocal.withInitial(() -> {
		return new Kryo();
	});

	@Override
	public byte[] serialzer(Object object) {
		try (ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(); 
				Output output = new Output(byteOutput)) {
			Kryo kryo = threadLocal.get();
			kryo.register(object.getClass());
			kryo.writeClassAndObject(output, object);
			return output.toBytes();
		} catch (Exception e) {
			log.error("序列化异常", e);
			throw new SerialException("序列化异常", e);
		}

	}

	@Override
	public <E> E deSerialzer(byte[] bytes, Class<E> classs) {
		try (ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
				Input input = new Input(byteInput)) {
			Kryo kryo = threadLocal.get();
			kryo.register(classs);
			Object readObject = kryo.readClassAndObject(input);
			return classs.cast(readObject);
		} catch (Exception e) {
			log.error("反序列化异常", e);
			throw new SerialException("反序列化异常", e);
		}
	}

	public Kryo getKryo() {
		return threadLocal.get();
	}

}
