package ch04;

public class BinaryTest {

	public static void main(String[] args) {

		int num = 10;
		int bNum = 0B1010; // binary num  0B는 2진수(binary)라는 식별자 알파벳 o아님
		int oNum = 012;  // 8진수 0가 식별자 
		int xNum = 0XA;  // 16진수  0X가 식별자
		
		System.out.println(num);
		System.out.println(bNum);
		System.out.println(oNum);
		System.out.println(xNum);
	}

}
