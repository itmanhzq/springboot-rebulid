package com.fenlibao.xinwang.util;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;


/**
 * @author Flynn
 * 签名验签类
 */
public class SignatureUtil {

	private static final String RSA = "RSA";

	private static final Charset DEFAULT_CHARSET = Charset.forName("utf-8");


	public static PrivateKey getRsaPkcs8PrivateKey(byte[] encodedKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			String data)
			throws GeneralSecurityException {
		return sign(algorithm, privateKey, data, DEFAULT_CHARSET);
	}



	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			String data, Charset charset)
			throws GeneralSecurityException {
		return sign(algorithm, privateKey, data.getBytes(charset));
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			byte[] data) throws GeneralSecurityException {
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		try {
			return sign(algorithm, privateKey, input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
		}
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			InputStream data) throws GeneralSecurityException,
			IOException {

		Signature signature = Signature.getInstance(algorithm
				.getSignAlgorithm());

		signature.initSign(privateKey);
		doUpdate(signature, data);

		return signature.sign();
	}

	private static void doUpdate(Signature signature, InputStream input)
			throws IOException, SignatureException {

		byte[] buf = new byte[4096];

		int c = 0;
		do {
			c = input.read(buf);

			if (c > 0) {
				signature.update(buf, 0, c);
			}
		} while (c != -1);
	}

}
