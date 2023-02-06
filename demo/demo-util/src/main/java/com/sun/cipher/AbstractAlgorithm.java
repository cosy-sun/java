package com.sun.cipher;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

public abstract class AbstractAlgorithm {

	/**
	 * 输入流解密
	 * @param key
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static CipherInputStream decrypt(Key key, InputStream inputStream, String algorithm, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return new CipherInputStream(inputStream, cipher);
	}

	/**
	 * 输出流加密
	 * @param key
	 * @param outputStream
	 * @return
	 * @throws Exception
	 */
	public static CipherOutputStream encrypt(Key key, OutputStream outputStream, String algorithm, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return new CipherOutputStream(outputStream, cipher);
	}

	/**
	 * 输入流加密
	 * @param key
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static CipherInputStream encrypt(Key key, InputStream inputStream, String algorithm, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return new CipherInputStream(inputStream, cipher);
	}

	/**
	 * 输出流解密
	 * @param key
	 * @param outputStream
	 * @return
	 * @throws Exception
	 */
	public static CipherOutputStream decrypt(Key key, OutputStream outputStream, String algorithm, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return new CipherOutputStream(outputStream, cipher);
	}
	
	/**
	 * 加密字符串
	 * @param plainText
	 * @param key
	 * @param algorithm
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static byte[] encode(String plainText, Key key, String algorithm, String encoding, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return cipher.doFinal(plainText.getBytes(encoding));
	}
	
	/**
	 * 解密字符串
	 * @param plainText
	 * @param key
	 * @param algorithm
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode(byte[] plainText, Key key, String algorithm, String encoding, String iv) throws Exception {
		Cipher instance = Cipher.getInstance(algorithm);
		instance.init(Cipher.DECRYPT_MODE, key, iv == null ? null : new IvParameterSpec(iv.getBytes()));
		return instance.doFinal(plainText);
	}
	
}
