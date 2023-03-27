package ch21;

public class ContinueTest {

	public static void main(String[] args) {

		int num;
		for( num = 1; num <= 100; num++) {
			
			if( (num % 3) != 0) continue; // 3의 배수가 아닌경우는 다음 블록 조건으로 진행
			
			System.out.println(num);
			
		}

	}

}