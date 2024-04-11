package com.cosy.sun.utils;

import com.cosy.sun.anno.RpcClient;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Ignore
public class AnnotationScannerTest {

	@Test
	public void testScan() throws ClassNotFoundException, IOException {
		List<Class<?>> doScan = AnnotationScannerUtils.doScan(Arrays.asList(RpcClient.class), new String[] {"com"});
		for(Class c : doScan) {
			System.out.println(c.getSimpleName());
		}
	}
	
	@Test
	public void getAnnotation() {
		Class<?> superclass = RpcClient.class.getSuperclass();
		Class<?>[] interfaces = RpcClient.class.getInterfaces();
	}
	
}
