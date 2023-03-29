package ch10;

public class BirthDayTest {

	public static void main(String[] args) {

		BirthDay date = new BirthDay();
		
		date.setYear(2019);
		date.setMonth(12);
		date.setDay(30);
		
		// Birthday 클래스의 변수들을 private로 설정하지 않으면
		// date.month = 100; 처럼 멤버 변수의 오류를 객체가 오입력 받을 수 있는 상황이 발생할 수 있게된다
		// private로 제한하고 set메서드로 제한하고, get메서드로 가져오는(read only) 방식으로 오류를 방지할 수 있다
		
		date.showDate();
	}

}
