package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드 / 변하지 않는 값
	private int age; // 읽기/쓰기 필드 / 변하는 값
	
	// constructor
	public Person(String name, int age) {
		    this.name = name;
		    this.age =  age;
		} 
	
	// method
		// getter 메서드
	public  String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	// setter 메서드
	public void setAge(int age) {
			this.age = age;
	}

}
