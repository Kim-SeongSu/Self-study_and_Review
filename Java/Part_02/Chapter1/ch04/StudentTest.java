package ch04;

public class StudentTest {

	public static void main(String[] args) {
		// 사용할 class(데이터 타입)  변수명 = new 키워드 함수()  << 생성자
		Student studentLee = new Student();
		// 'Student'라는 class를 기반으로 생성된 새로운 객체를 '인스턴스'라고 한다
		// (new Student())생성자로 생성된 인스턴스를 지시하는 'studentLee'라는 참조변수
		
		// 인스턴스에 정보 대입
		studentLee.studentId = 12345;
		studentLee.setStudentName("Lee");
		studentLee.address = "서울 강남구";
		
		studentLee.showStudentInfo();
		
		
		
		
		Student studentKim = new Student();
		studentKim.studentId = 54321;
		studentKim.setStudentName("Kim");
		studentKim.address = "경기 수원시";
		
		studentKim.showStudentInfo();
		
		
		System.out.println(studentKim);
		// ch04.Student@7a3d45bd
		// class 풀네임(package.class)@참조 값(reference value)
		
	}

}
