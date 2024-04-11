package com.itwill.file06;

import java.io.Serializable;

public class Student {
	private int id;
	private String name;
	private Score score;
	
	// 생성자, 
	public Student() {}
	
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public Student(int id, String name, int java, int web, int spring) {
		this.id = id;
		this.name = name;
		this.score = new Score(java, web, spring);
		
	}
	
	//getter/setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNAME(String name) {
		this.name = name;
	}
	
	public Score getScore() {
		return score;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}

	//	//toString 만들기.
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	

}
