package ch07;

public class UserInfoTest {

	public static void main(String[] args) {

		// default constructor(기본 생성자)사용해 각각의 변수를 입력받은 경우
		UserInfo userLee = new UserInfo();
		userLee.userId = "a12345";
		userLee.userPassword = "zxcvbn12345";
		userLee.userName = "Lee";
		userLee.phoneNumber = "01034556699";
		userLee.userAddress = "Seoul, Korea";

		System.out.println(userLee.showUserInfo());
		
		
		// 매개변수를 직접 입력받아 생성한 경우
		UserInfo userKim = new UserInfo("b12345", "09876mnbvc", "Kim");
		System.out.println(userKim.showUserInfo());
		
	}

}
