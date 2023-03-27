package ch10;

public class ConstantTest {

	public static void main(String[] args) {
		
		final int MAX_NUM = 100;
		final int MIN_NUM = 10;
		
		// MAX_NUM = 20;  한번 지정된 상수를 다시 수정하면 오류발생
		// 수정이 필요한 경우, 처음 선언 부분에서 변경 후 컴파일 다시 해주면 끝!
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
	}

}
