package com.sun.design.cyrptoandzip;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyGeneratorTest {

	public static void main(String[] args) throws Exception{
//		BigInteger bigInteger = new BigInteger(1, key(56).getEncoded());
//		byte[] b =key(56).getEncoded();
//		System.out.println(bigInteger);
//		System.out.println(new BigInteger(b));
//		SecretKeySpec keyToByte = keyToByte(key(56));
//		byte[] cs = encry("sunzhensunzhenhuasunzhenhuasunzhenh"
//				+ "uasunzhenhuasunzhenhuasunzhenhuasunzhenhuasunzhenhuasunzhenhuasunzhen"
//				+ "huasunzhenhuasunzhenhuasunzhenhuahua", keyToByte);
//		System.out.println(new BigInteger(cs));
//		
//		String deEncry = deEncry(cs, keyToByte);
//		System.out.println("揭秘保温：" + deEncry);
		
		SecretKeySpec stringTOkey = stringTOkey("123456781234567812345678");
		byte[] encry = encry("我是孙振华", stringTOkey);
		System.out.println("密文；"+new BigInteger(encry));
		
		String deEncry = deEncry(encry, stringTOkey);
		System.out.println(deEncry);
		
		
		
	}
	
	@SuppressWarnings("unused")
	private static SecretKey  key(int longs) throws Exception{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
		keyGenerator.init(longs);
		
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey;
	}
	
	@SuppressWarnings("unused")
	private static SecretKeySpec keyToByte(SecretKey secretKey) throws Exception{
		byte[] secretKeyByte = secretKey.getEncoded();
		SecretKeySpec secKey = new SecretKeySpec(secretKeyByte, "DESede");
		return secKey;
	}
	
	private static byte[] encry(String str, SecretKeySpec s) throws Exception{
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, s);
		byte[] doFinal = cipher.doFinal(str.getBytes());
		
		return doFinal;
	}
	
	private static String deEncry(byte[] b, SecretKeySpec key) throws Exception{
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] doFinal = cipher.doFinal(b);
		return new String(doFinal);
		
	}
	
	private static SecretKeySpec stringTOkey(String DESede) {
		return new SecretKeySpec(DESede.getBytes(), "DESede");
	}
}
