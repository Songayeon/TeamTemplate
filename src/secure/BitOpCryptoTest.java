package secure;

public class BitOpCryptoTest {

	public static void main(String[] args) {

		int i=10; //원 데이터 → 암호화(키 필수)
		int j=12; // 키 역활 + 연산방식(다양한 알고리즘이 필요)
		  
		  
		  System.out.println(i+"의 이진수 = " + Integer.toBinaryString(i));
		  System.out.println(j+"의 이진수 = " + Integer.toBinaryString(j));
		  
		  
		  // 비트 OR 연산 (두 비트중에 하나라도 1이면 연산결과는 1)
		  System.out.println("비트 OR 연산:" + (i | j));
		  
		  // 비트 AND 연산 (두 비트가 모두 1이면 연산결과는 1)
		  System.out.println("비트 AND 연산:" + (i & j));
		  
		  //비트 XOR(각 비트가 다른 수를 가지는 경우 연산결과는 1) : 배타적OR
		  int enc=i ^ j; //i 는 암호화시킬 데이터 , j는 암호화 키
		  System.out.println("비트 XOR:"+ enc); //암호데이터
		  
		  int dec= enc ^ j;// 암호데이터를 복호화
		  System.out.println("비트 XOR 복호화: "+dec);

	}
}
