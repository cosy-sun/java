package com.cosy.sun.utils;

import org.junit.Test;

import com.cosy.sun.remote.model.HeartModel;
import com.cosy.sun.serial.adaptor.KryoSerialAdaptor;
import com.cosy.sun.zip.adaptor.JdkZipAdaptor;

public class ZipTest {

	@Test
	public void zip() {
		HeartModel echoClient = new HeartModel();
		JdkZipAdaptor zip = new JdkZipAdaptor();
		KryoSerialAdaptor ser = new KryoSerialAdaptor();
		byte[] serialzer = ser.serialzer(echoClient);
		byte[] zipByte = zip.zip(serialzer);
		byte[] unzip = zip.unzip(zipByte);
		HeartModel deSerialzer = ser.deSerialzer(unzip, HeartModel.class);
		System.out.println(deSerialzer);
	}
	
}
