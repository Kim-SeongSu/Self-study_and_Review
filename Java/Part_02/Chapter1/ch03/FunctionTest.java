package ch03;

public class FunctionTest {
	
	// 매개변수도 있고 반환값도 있는 함수
	public static int addNum(int num1, int num2) {
		
		int result;
		result = num1 + num2;
		return result;
	}
	
	// 매개변수는 있지만 반환값이 없는 함수
	public static void sayHello(String greeting) {
		
		System.out.println(greeting);
	}
	
	// 매개변수도 반환값도 없는 함수
	public static int calcSum() {
		
		int sum = 0;
		int i;
		
		for(i = 0; i <= 100; i++) {
			
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2 = 20;
		
		int total = addNum(n1,n2);
		System.out.println(total);
		
		sayHello("안녕하세요!");
		
		total = calcSum();
		System.out.println(total);
	}
}
