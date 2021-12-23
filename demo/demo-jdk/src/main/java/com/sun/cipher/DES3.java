package com.sun.cipher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

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

	public static void main(String... args) throws Exception {
		byte[] encode = encode("this is sunzhenhua", getSecretKey(key), alg1, encoding, iv);
		System.out.println(Base64.encodeBase64String(encode));
		byte[] decode = decode(Base64.decodeBase64(Base64.encodeBase64String(encode)), getSecretKey(key), alg1, encoding, iv);
		System.out.println(new String(decode));

		try (FileOutputStream out = new FileOutputStream(new File("E:\\encrypt.txt"));
				CipherInputStream cis = encrypt(getSecretKey(key), new FileInputStream(new File("E:\\txt.txt")), alg1, iv);) {
			byte[] buff = new byte[1024];
			int n = 0;
			while (-1 != (n = cis.read(buff))) {
				out.write(buff, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (FileOutputStream out = new FileOutputStream(new File("E:\\decrypt.txt"));
				CipherInputStream cis = decrypt(getSecretKey(key), new FileInputStream(new File("E:\\encrypt.txt")), alg1, iv);) {
			byte[] buff = new byte[1024];
			int n = 0;
			while (-1 != (n = cis.read(buff))) {
				out.write(buff, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (InputStream inputStream = new FileInputStream(new File("E:\\txt.txt"));
				FileOutputStream out = new FileOutputStream(new File("E:\\encrypt.txt"));
				CipherOutputStream cos = encrypt(getSecretKey(key), out, alg1, iv);
		) {
			byte[] buff = new byte[1024];
			int n = 0;
			while (-1 != (n = inputStream.read(buff))) {
				cos.write(buff, 0, n);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		try (FileOutputStream fos = new FileOutputStream(new File("E:\\decrypt.txt"));
				FileInputStream fis = new FileInputStream(new File("E:\\encrypt.txt"));
				CipherInputStream cis = decrypt(getSecretKey(key), fis, alg1, iv);

		) {
			byte[] b = new byte[1024];
			int n = 0;
			while (-1 != (n = cis.read(b))) {
				fos.write(b, 0, n);
				fos.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
