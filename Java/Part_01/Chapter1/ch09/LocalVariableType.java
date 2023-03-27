package ch09;

public class LocalVariableType {
	
	public static void main(String[] args) {
		
		// var은 variable의 약자
		var i = 10;        // int
		var j = 10.0;      // double
		var str = "test"; // string  명확히 구분되는 경우, 자동적으로 자료형 없이 (지역)변수 사용 가능! (Java 10이상부터)
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		
		var str2 = str;
		System.out.println(str2);
		
		
	}
}
