package ch09;

public class SubjectTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(001, "Lee");
		studentLee.setKoreanSubject("국어", 100);
		studentLee.setMathSubject("수학", 95);

		Student studentKim = new Student(002, "Kim");
		studentKim.setKoreanSubject("국어", 60);
		studentKim.setMathSubject("수학", 45);
		
		studentLee.showStudentScore();
		studentKim.showStudentScore();

	}
}
