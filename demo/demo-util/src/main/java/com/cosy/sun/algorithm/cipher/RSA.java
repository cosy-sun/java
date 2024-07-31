package com.cosy.sun.algorithm.cipher;

import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * rsa加密
 * 此类只支持获取一次公私钥
 * @author cosy-sun
 *
 */
public class RSA extends AbstractAlgorithm {

	private static final String alg = "RSA";

	private static Map<String, String> map = new HashMap<>();

	static {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化一堆密钥存到map中
	 * public = public key
	 * private = private key
	 * @throws Exception
	 */
	public static void init() throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance(alg);
		generator.initialize(1024, new SecureRandom());
		KeyPair keyPair = generator.generateKeyPair();
		RSAPrivateKey private1 = (RSAPrivateKey) keyPair.getPrivate();
		RSAPublicKey public1 = (RSAPublicKey) keyPair.getPublic();
		byte[] privateKeyEncode = Base64.encodeBase64(private1.getEncoded());
		byte[] publicKeyEncode = Base64.encodeBase64(public1.getEncoded());
		map.put("public", new String(publicKeyEncode));
		map.put("private", new String(privateKeyEncode));
	}

	/**
	 * x509编码公钥
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	private static RSAPublicKey getPublic(String publicKey) throws Exception {
		KeyFactory factory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
		return (RSAPublicKey) factory.generatePublic(spec);
	}

	/**
	 * pkcs8编码私钥
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	private static RSAPrivateKey getPrivate(String privateKey) throws Exception {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
		KeyFactory factory = KeyFactory.getInstance("RSA");
		return (RSAPrivateKey) factory.generatePrivate(spec);
	}

	/**
	 * 直接获取公钥
	 * @return
	 * @throws Exception
	 */
	public static Key getPublic() throws Exception {
		return getPublic(map.get("public"));
	}

	/**
	 * 直接获取私钥
	 * @return
	 * @throws Exception
	 */
	public static Key getPrivate() throws Exception {
		return getPrivate(map.get("private"));
	}

}
