package ch13;

public class BitTest {

	public static void main(String[] args) {
		int num1 = 5;  	// 00000101
		int num2 = 10; 	// 00001010
				
		System.out.println(num1 | num2);  // 00001111 15
		System.out.println(num1 & num2);  // 00000000 0
		System.out.println(num1 ^ num2);  // 00001111 15
		System.out.println(~num1);        // 11111010
		
		System.out.println(num1 << 2);    // 00001010 10
		System.out.println(num1);
		System.out.println(num1 <<= 2);   // 00010100 20
		System.out.println(num1);
		// <<한 수만큼 2^n 제곱만큼 증가
		// >>는 반대로 2^(-n) 제곱만큼 감소 : 나눗셈 몫
		
		System.out.println(num1 >>> 5);
		
	}

}
