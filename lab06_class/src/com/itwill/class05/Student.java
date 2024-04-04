package com.itwill.class05;

public class Student {
    // field
    int id; // 학생 번호
    String name; // 학생 이름
    Subject subject; // 수강 과목
    
    // TODO 생성자: (1)기본 생성자. 
    // 타입 기본값: boolean=false, 정수-0, 실수-0.0, 참조타입-null
    public Student() {}
    
    //  (2)아규먼트를 갖는 생성자.
    public Student
    (int id, String name, Subject subject) {
    	this.id = id;
    	this.name = name;
    	this.subject = subject;
    }
    // TODO 메서드: 학생의 정보(번호, 이름, 각 과목의 점수, 총점, 평균)를 출력.
    public void info() {
    	System.out.println("-------학생 정보-------");
    	System.out.println("번호: " + id);
    	System.out.println("이름: " + name);
    	if (subject != null) {
            subject.info();
//    	System.out.println("국어 점수: " + subject.korean);
//    	System.out.println("영어 점수: " + subject.english);
//    	System.out.println("수학 점수: " + subject.math);
//    	System.out.println("과학 점수: " + subject.science);
//    	System.out.println("총점: " + subject.getTotal());
//    	System.out.println("평균: " + subject.getMean());
    } else {
        System.out.println("Subject: null");
    }
    }
}