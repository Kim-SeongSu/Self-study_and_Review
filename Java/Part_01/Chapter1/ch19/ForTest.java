package ch19;

public class ForTest {

	public static void main(String[] args) {

		int count = 1;
		int sum = 0;
		
	
		// for(초기화식; 조건식; 증감식;){
		//   수행문;  }
		for(int i = 0; i < 10; i++, count++) {
			sum += count;
		}
		System.out.println(sum);
		
		// 이미 전에 값이 초기화 된 경우, 초기화식 생략 가능
		// 반복 수행에 대한 조건이 수행문 내부에 있는 경우, 조건식 생략 가능
		// 증감식에 대한 연산이 복잡하거나 다른 변수의 연산 결과값에 결정되는 경우, 증감식 생략 가능 -> 수행문 내부에 작성
		// 무한 반복하는 경우, for(;;){ ... }
		
		
		
		
		// 같은 식의 while문
		int num = 1;
		int total = 0;
		
		while( num <= 10) {
			total += num;
			num++;
		}
		System.out.println(total);
		
	}

}
