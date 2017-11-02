package secure;

import javax.crypto.Cipher;


import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

public class AESCryptoTest {

	// 키비트 128비트 글자수 16자
	// "thisIsASecretKey";
	private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41,
			0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79 };

	public static String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			final String encryptedString = new BASE64Encoder().encode(cipher.doFinal(strToEncrypt.getBytes()));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			final String decryptedString = new String(
					cipher.doFinal(new BASE64Decoder()
							.decodeBuffer(strToDecrypt)));
			return decryptedString;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public static void main(String[] args) {
		String enc_res = encrypt("안녕");
		System.out.print(enc_res);
		System.out.print(decrypt(enc_res));

	}

}
