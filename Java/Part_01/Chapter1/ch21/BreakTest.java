package ch21;

public class BreakTest {

	public static void main(String[] args) {

		int sum = 0;
		int num;
		
		for( num = 1; ; num++) { // num = 1; sum <= 100; num++ 로 하면 
								 // num이 15로 출력되기때문에 제어문 블록안에 조건을 만들어야한다.
			
			sum += num;
			if( sum >= 100)	break;
		}
		
		System.out.println(sum);
		System.out.println(num);

	}

}
