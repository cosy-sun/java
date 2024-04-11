package com.cosy.sun.serial;

import java.util.Arrays;

import org.junit.Test;

import com.cosy.sun.serial.adaptor.KryoSerialAdaptor;
import com.cosy.sun.serial.adaptor.ProtostuffSerialAdaptor;

public class SerialTest {

	@Test
	public void testSerial() {
		KryoSerialAdaptor kryoSerialAdaptor = new KryoSerialAdaptor();
		Model model = new Model();
		model.setA("123");
		model.setB("234");
		byte[] serialzer = kryoSerialAdaptor.serialzer(model);
		System.out.println(Arrays.toString(serialzer));
		KryoSerialAdaptor kryoSerialAdaptor1 = new KryoSerialAdaptor();
		Model deSerialzer = kryoSerialAdaptor1.deSerialzer(serialzer, Model.class);
		System.out.println(deSerialzer.getA());
		System.out.println(deSerialzer.getB());
	}
	
	@Test
	public void testproto() {
		ProtostuffSerialAdaptor protostuffSerialAdaptor = new ProtostuffSerialAdaptor();
		Model model = new Model();
		model.setA("123");
		model.setB("234");
		byte[] serialzer = protostuffSerialAdaptor.serialzer(model);
		System.out.println(Arrays.toString(serialzer));
		Model deSerialzer = protostuffSerialAdaptor.deSerialzer(serialzer, Model.class);
		System.out.println(deSerialzer.getA());
		System.out.println(deSerialzer.getB());
	}
	
}
