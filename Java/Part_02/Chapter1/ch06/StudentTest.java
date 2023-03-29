package ch06;

public class StudentTest {

	public static void main(String[] args) {

		// Student studentLee = new Student(); 생성자 안에 매개변수가 없으므로 오류!
		
		Student studentKim = new Student("김성수",2015018005,4);
		
		System.out.println(studentKim.showStudentInfo());
	}

}
