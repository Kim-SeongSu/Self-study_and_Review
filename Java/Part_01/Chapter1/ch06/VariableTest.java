package ch06;

public class VariableTest {
	public static void main(String[] args) {
		
		byte bnum = -128; // -128 ~ 127까지만 표현 가능 (128은 오류남)
		
		System.out.println(bnum);
		
		// int num = 12345678900; 너무 길어서 안됨
		long lNum = 12345678900L; // 대문자 L을 숫자 마지막에 넣어서 헷갈리지 않도록 하자
		System.out.println(lNum);
	}

}
