package com.cosy.sun.jdk.design.cyrptoandzip;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DesedeTest {

	//密钥算法
	private static final String KEY_ALGORITHM = "DESEde";
	
	//
	@SuppressWarnings("unused")
	private static final String mode = "DESEde/ECB/PKCS5Padding";
	
	private static byte[] initKey(String str) throws Exception{
		KeyGenerator generator = KeyGenerator.getInstance(KEY_ALGORITHM);
		generator.init(168);
		SecretKey generateKey = generator.generateKey();
		return generateKey.getEncoded();
	}
	
	private static Key toKey(byte[] b) throws Exception{
		
		DESedeKeySpec dks = new DESedeKeySpec(b);
		SecretKeyFactory instance = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey scretKey = instance.generateSecret(dks);
		return scretKey;
	}
	
	@SuppressWarnings("unused")
	private static byte[] encry(byte[] data, byte[] key) throws Exception{
		Key k=toKey(key);
		//实例化
		Cipher cipher=Cipher.getInstance(KEY_ALGORITHM);
		//初始化，设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, k);
		//执行操作
		return cipher.doFinal(data);
	}
	public static void main(String[] args) throws Exception{
		String str = "sunzhenhua";
		byte[] key = DesedeTest.initKey(str);
		System.out.println(new String(key));
	}
}
