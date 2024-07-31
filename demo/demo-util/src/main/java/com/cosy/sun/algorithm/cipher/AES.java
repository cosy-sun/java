package com.cosy.sun.algorithm.cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * AES加密
 * 密钥长度是128, 192, 256bit
 * 对应            16,  24,  32 字节
 * @author cosy-sun
 *
 */
public class AES extends AbstractAlgorithm {

	public static final String encoding = "utf-8";
	public static final String algorithm = "AES";
	public static String key = "1234567890123456";
	/**
	 * 根据字符串生成密钥, 位数不足补充位数
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Key getSecretKeyByFactory(String key) throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance(algorithm);
		generator.init(new SecureRandom(key.getBytes()));
		SecretKey generateKey = generator.generateKey();
		SecretKeySpec secretKeySpec = new SecretKeySpec(generateKey.getEncoded(), algorithm);
		return secretKeySpec;
	}

	/**
	 * 如果使用此方法生成密钥, 需要指定位数, 16, 24, 32 字节
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Key getSecretKey(String key) throws Exception {
		return new SecretKeySpec(key.getBytes(), algorithm);
	}

}
