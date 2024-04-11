package com.itwill.file06;

public class Score {
	// field
	private int java;
	private int web;
	private int spring;
	
	// 생성자,
	public Score() {}
	
	public Score(int java, int web, int spring) {
		this.java = java;
		this.web = web;
		this.spring = spring;
	}

	//getter/setter
	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getWeb() {
		return web;
	}

	public void setWeb(int web) {
		this.web = web;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	//toString 만들기.
	@Override
	public String toString() {
		return "Score [java=" + java + ", web=" + web + ", spring=" + spring + "]";
	}
	

}
