package com.cosy.sun.algorithm.cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 3DES加密
 * DES的密钥长度是8字节,
 * 3DES的密钥长度是3*8字节
 * 通常使用16字节的密钥
 * @author cosy-sun
 *
 */
public class DES3 extends AbstractAlgorithm {

	private static final String encoding = "utf-8";
	private static final String alg = "DESede";
	private static final String alg1 = "DESede/CBC/PKCS5Padding";
	private static final String iv = "01234567";
	static String key = "sunzh123sunzh123sunzh123";
	/**
	 * 根据字符串生成密钥, 位数不足补充位数
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Key getSecretKeyByFactory(String key) throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance(alg);
		generator.init(new SecureRandom(key.getBytes()));
		SecretKey generateKey = generator.generateKey();
		SecretKeySpec secretKeySpec = new SecretKeySpec(generateKey.getEncoded(), alg);
		return secretKeySpec;
	}

	/**
	 * 使用此方法需要使用16字节或者24字节的密码
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Key getSecretKey(String key) throws Exception {
		return new SecretKeySpec(key.getBytes(), alg);
	}

}
