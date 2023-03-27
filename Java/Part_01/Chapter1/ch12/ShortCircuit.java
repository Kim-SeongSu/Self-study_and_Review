package ch12;

public class ShortCircuit {

	public static void main(String[] args) {
		
		int num1 = 10;
		int i = 2;
		
		boolean value = ((num1 += 10) < 10) && ((i += 2) < 10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		
		// 논리 곱의 첫 조건의 결과가 false이므로 두번째 조건의 결과와 상관없이 연산이 끝난다
		
		
		value = ((num1 = num1 + 10 ) < 10) || ( ( i = i + 2 ) < 10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		
		// 논리 합의 연산 결과 첫 조건은 false였기에 두번째 연산의 결과까지 알아야하므로 두번째 조건까지 진행
	}

}
