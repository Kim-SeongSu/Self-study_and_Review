package ch18;

import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input; 
		int sum = 0;
		
		/*
		 input = scanner.nextInt();
		 
		 while(input != 0){
		 
		  sum += input;
		  input = scanner.nextInt();  // 동일 코드가 중복된다
		  }
		 */

		do {
			input = scanner.nextInt();
			sum += input;
			
		}while(input != 0);

			
		System.out.println(sum);

	}

}
