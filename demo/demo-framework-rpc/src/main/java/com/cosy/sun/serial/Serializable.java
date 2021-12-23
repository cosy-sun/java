package com.cosy.sun.serial;

public interface Serializable {

	public byte[] serialzer(Object object);

	public <T> T deSerialzer(byte[] bytes, Class<T> classs);
	
}
