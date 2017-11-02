package secure;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// SHA-256 로 입력값을 cipher_mem 테이블에 저장
public class MemReg {

	public static void main(String[] args) throws Exception {

		/*
		 * jdbc.driver = oracle.jdbc.driver.OracleDriver jdbc.url =
		 * jdbc:oracle:thin:@127.0.0.1:1521:xe jdbc.username = system
		 * jdbc.password = oracle
		 */

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "oracle");

		StringBuffer sb = new StringBuffer();
		System.out.print("Input String : ");
		Scanner sc = new Scanner(System.in);
		String str = "";

		str = sc.nextLine();

		try {
			MessageDigest md5 = MessageDigest.getInstance("SHA-256");

			byte[] md5Byte = null;
			// 메세지 추가
			md5.update(str.getBytes());			
			
			// //해쉬값(다이제스트) 구하기
			md5Byte = md5.digest();
			// 16진수 배치 출력(각 바이트를 문자형으로 ff와 앤드비트연산)
			for (int i = 0; i < md5Byte.length; i++) {

				String md5char = Integer.toHexString(0xff & (char) md5Byte[i]);

				sb.append(md5char);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("MD5 Result : " + sb.toString());
		System.out.println("MD5 Result : " + sb.toString().length());

		String sql = "insert into cipher_mem values(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sb.toString());
		pstmt.executeUpdate();
		System.out.println("저장완료");
	}
}
