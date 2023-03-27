package ch16;

import java.util.Scanner;

public class SwitchCaseTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		/*
		int day;
		
		switch(month){
		
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
			case 2: 
				day = 28;
				break;
			default:
				day = 0;
				System.out.println("존재하지 않는 달 입니다.");
				*/
		
		// Java 14 이상 가능(구문이 아닌 식으로도 사용할 수 있어졌다.)
		int day = switch(month) {
		case 1,3,5,7,8,10,12 ->{
			yield 31; // yield을 통해 return값을 입력받을 수 있다
		}
		case 4,6,9,11 -> {
			yield 30;
		}
		case 2 ->{
			yield 28;
		}
		default ->{ // if문의 else 같은 역할
			yield 0;
		}
		};// 구문이 아닌 식으로 받았기때문에 여기에 ;를 붙여줘야한다.
		System.out.println(month + "월은 " + day + "일입니다.");
	}

}
