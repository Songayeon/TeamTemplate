package secure;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LogIn {

	public static void main(String[] args) throws Exception {

		/*
		 * jdbc.driver = oracle.jdbc.driver.OracleDriver jdbc.url =
		 * jdbc:oracle:thin:@127.0.0.1:1521:xe jdbc.username = system
		 * jdbc.password = oracle
		 */

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "oracle");

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		//MessageDigest md5 = MessageDigest.getInstance("MD5"); 
		MessageDigest md5 = MessageDigest.getInstance("SHA-256"); //보안수준을 높임
		System.out.println("Input password : ");
		String str = sc.nextLine();

		md5.update(str.getBytes());		

		byte[] md5Byte = md5.digest();

		for (int i = 0; i < md5Byte.length; i++) {
			
			String md5char = Integer.toHexString(0xff & (char) md5Byte[i]);
			sb.append(md5char);
		}

		System.out.println("SHA1 Result : " + sb.toString());
		System.out.println("SHA1 Result : " + sb.toString().length());
//----------------------------
		// 저장된 비밀번호 MD 가져오기
		  String sql="select pw from cipher_mem";
		  
		  PreparedStatement pstmt= conn.prepareStatement(sql);
		  ResultSet rs= pstmt.executeQuery();
		  
		  if(rs.next()){
		   String savedPw= rs.getString("pw");//저장된 비밀번호 MD
		   //입력된 비밀번호 MD와 비교
		   if(savedPw.equals(sb.toString())){
		    System.out.println("인증성공");
		   }else{
		    System.out.println("인증실패");
		   }
		  

		}
	}
}
