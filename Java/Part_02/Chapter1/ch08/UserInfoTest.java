package ch08;

public class UserInfoTest {

	public static void main(String[] args) {

		UserInfo User_001 = new UserInfo(180,78,"남","Thomas",37);
		UserInfo User_002 = new UserInfo(170,64,"남","Kim",27);
		
		System.out.println(User_001.showUserInfo());
		System.out.println(User_002.showUserInfo());
	}	
}
