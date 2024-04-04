package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// TODO Subject, Student 클래스 객체 생성
		
		//기본생성자를 사용해서 Subject 타입의 객체 생성
		// 첫번쨰 방법
		Student st1 = new Student();
		
		st1.id = 100;
		st1.name = "오쌤";
		st1.subject.korean = 70;
		st1.subject.english = 80;
		st1.subject.math = 90;
		st1.subject.science = 100;
		
		// 두번째 방법
//		Subject subject1 = new Subject();
//		System.out.println("국어: " + subject1.korean);
//		System.out.println("영어: " + subject1.english);
//		System.out.println("수학: " + subject1.math);
//		System.out.println("과학:" + subject1.science);
//		System.out.println("총점: " + subject1.getTotal());
//		System.out.println("평균:" + subject1.getMean());
		
		//아규먼트를 갖는 생성자를 사용해서 Subject 타입의 객체를 생성
		//Subject subject2 = new Subject(100, 90, 50, 80);
		//subject2.info();

		// 메서드 호출 결과 테스트.
		st1.info();
	}

}
