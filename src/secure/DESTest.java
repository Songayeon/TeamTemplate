package secure;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESTest {

	public static void main(String[] args) throws Exception {

		// 비밀키 생성 , 키비트 8자 12345678 = 64비트로 1234567는 예외
		SecretKey key = new SecretKeySpec("12345678".getBytes
		(), "DES");
		// 암복호화객체 Cipher 생성
		Cipher c = Cipher.getInstance("DES");
		// 키로 암호객체(Cipher) 초기화
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] dataArray = "안녕".getBytes();
		// doFinal() : Encrypt or Decrypt
		byte[] encryptedArray = c.doFinal(dataArray);
		// Encode bytes to base64 to get a string(바이트배열을 아스키문자열로 출력하기 위함)
		// BASE64는 8bit의 데이터(바이트=바이너리)들(바이트배열) 를 6bit의 크기로 표현
		// ASCII 영역의 문자들로만 이루어진 일련의 문자열로 바꾸는 인코딩 ASCII 영역의 문자들로만 이루어진 일련의 문 자열로
		// 바꾸는 인코딩

		String enc_res = new sun.misc.BASE64Encoder().encode(encryptedArray);
		System.out.print(enc_res);
		//----------------------------

		SecretKey key2 = new SecretKeySpec	("12345678".getBytes(), "DES");
		Cipher dcipher = Cipher.getInstance("DES");
		// Create the ciphers
		dcipher.init(Cipher.DECRYPT_MODE, key2);
		byte[] decryptedArray = new sun.misc.BASE64Decoder().decodeBuffer(enc_res);
		// Decrypt
		dataArray = dcipher.doFinal(decryptedArray);
		// Decode using utf-8
		String dec_res = new String(dataArray);
		System.out.print(dec_res);

	}

}
