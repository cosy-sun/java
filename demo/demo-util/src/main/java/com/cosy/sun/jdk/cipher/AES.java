package com.cosy.sun.jdk.cipher;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

	private static final String encoding = "utf-8";
	private static final String algorithm = "AES";
	static String key = "1234567890123456";
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


	public static void main(String... args) throws Exception {
		String str = "this is sunzhenhua";
		byte[] encode = encode(str, getSecretKeyByFactory(key), algorithm, encoding, null);
		System.out.println(Base64.encodeBase64String(encode));
		byte[] decode = decode(Base64.decodeBase64(Base64.encodeBase64String(encode)), getSecretKeyByFactory(key), algorithm, encoding, null);
		System.out.println(new String(decode));

		try (FileOutputStream out = new FileOutputStream(new File("E:\\encrypt.txt"));
				CipherInputStream cis = encrypt(getSecretKey(key), new FileInputStream(new File("E:\\txt.txt")), algorithm, null);) {
			byte[] buff = new byte[1024];
			int n = 0;
			while (-1 != (n = cis.read(buff))) {
				out.write(buff, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileOutputStream out = new FileOutputStream(new File("E:\\decrypt.txt"));
				CipherInputStream cis = decrypt(getSecretKey(key), new FileInputStream(new File("E:\\encrypt.txt")), algorithm, null);) {
			byte[] buff = new byte[1024];
			int n = 0;
			while (-1 != (n = cis.read(buff))) {
				out.write(buff, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
