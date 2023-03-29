package ch09;

public class Student {

	int studentId;
	String studentName;
	
	// 클래스형으로 '참조 자료형' 변수 생성
	Subject korean;
	Subject math;
	
	Student(int studentId, String studentName){
		this.studentId = studentId;
		this.studentName = studentName;
		
		
		// 꼭 여기에 만들 필요는 없지만 참조 자료형을 사용하기 전에 꼭 생성해야한다!
		korean = new Subject();
		math = new Subject();
	}
	
	public void setKoreanSubject(String name, int score) {
		korean.subjectName = name;
		korean.score = score;
	}
	
	public void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}
	
	public void showStudentScore() {
		int total = korean.score + math.score;
		System.out.println(studentName +  " 학생의 총점은 " + total + "점 입니다." );
	}
}
