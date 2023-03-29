package ch07;

public class UserInfo {

	public String userId;
	public String userPassword;
	public String userName;
	public String userAddress;
	public String phoneNumber;

	// 생성자 오버로딩 : 같은 이름을 갖는 비어있는 생성자를 만들어 인스턴스 생성시 모든 매개변수가 들어있지 않는 경우
	// 기본 생성자(default constructor;  ex. UserInfo userLee = new UserInfo())로 추가할 수 있도록 따로 만든 생성자
	public UserInfo() {}
	
	public UserInfo(String userId, String userPassword, String userName) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
	}
	
	public String showUserInfo() {
		return "고객님의 아이디는 " + userId + "이고, 등록된 이름은 " + userName + "입니다.";
	}
}
