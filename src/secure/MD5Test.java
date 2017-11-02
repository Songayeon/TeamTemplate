package secure;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Scanner;

public class MD5Test {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		System.out.print("Input String : ");

		Scanner sc = new Scanner(System.in);
		String str = "";
		str = sc.nextLine();

		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); // 최대 32자리 수

			byte[] md5Byte = null;
			// 원메세지 추가
			md5.update(str.getBytes());
			
			// 2-29 에서 설명
			byte[] seed = { 1, 2, 3, 4 };//SEED 값
			//String salt = "1234"; 
			//예측할 수 없는 랜덤값 - 메세지에 덭붙여서 digest할때 해커가 풀어내기 힘들게 함.
			//방법1. - 매번 setSEED 를 변경한다.
			//방법2. - 
			
			
			//SecureRandom // 보안문자 만들때의 랜덤 함수 = 보안랜덤 문자
			SecureRandom random = new SecureRandom();
			long nextLong = random.nextLong();
			String salt = String.valueOf(nextLong);
			
			// salt 추가
			md5.update(salt.getBytes());
			//해쉬값(다이제스트=전자서명(비번,이메일,이름...)) 구하기
			md5Byte = md5.digest();
			
			// 문자열 깨짐
			System.out.println("-->"+new String(md5Byte)); //바이트배열을 단순히 String 으로 쓰면 글자가 깨짐
			//암호화로 사용이 힘듬. 코드를 인코딩을 해야 사용이 될 수 있음.
			//SEED 가 같으면 같은 값이 나옴.
			
			
			// 16진수 배치 출력(각 바이트를 문자형으로 ff와 앤드비트 연산)
			for (int i = 0; i < md5Byte.length; i++) {
				String md5char = Integer.toHexString(0xff & (char)md5Byte[i]);
				sb.append(md5char);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("MD5 Result : " + sb.toString());
		System.out.println("MD5 Result : " + sb.toString().length());

	}

}
