package ch08;

public class UserInfo {

	public int UserHeight;
	public int UserWeight;
	public String UserSex;
	public String UserName;
	public int UserAge;
	
	
	public UserInfo(int UserHeight, int UserWeight, String UserSex, String UserName, int UserAge) {
		this.UserHeight = UserHeight;
		this.UserWeight = UserWeight;
		this.UserSex = UserSex;
		this.UserName = UserName;
		this.UserAge = UserAge;
	}
	
	public String showUserInfo(){
		return "키가 "+ UserHeight +" 이고 몸무게가 " + UserWeight + " 킬로인 " + UserSex+ "성이 있습니다. 이름은 " +UserName+ " 이고 나이는 "+ UserAge+ "세입니다.";
	}
}
