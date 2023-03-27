package ch11;

public class OperatorTest {

	public static void main(String[] args) {
		
		int gameScore = 150;
		int lastScore = ++gameScore;
		
		System.out.println(lastScore);		
		System.out.println(gameScore);
		// gameScore와 lastScore 모두 +1된 값으로 저장
		
		
		int gameScore2 = 150;
		int lastScore2 = gameScore2++;
		
		System.out.println(lastScore2);
		System.out.println(gameScore2);
		// gameScore2는 그대로(이번 스테이트먼트 까지만), lastScore2만 증가한 값으로 저장
		
		// 변수2 = ++변수1 : 변수1 증가 후, 변수2로 지정 
		// 변수2 = 변수1++ : 변수2에 변수1 지정 후, 변수1 증가
	}

}
