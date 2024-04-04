package com.itwill.ver01;

// 연락처 데이터를 표현하는 클래스.
public class Contact {
	// 필드
	private String name;
	private String phone;
	private String email;
	
	// 생성자
	public Contact() {}
	
	// 아큐먼트를 가진 생성자
	public Contact(String name, String phone, String email) {
		this(); // 기본 생성자 호출
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	//메서드 
	public String getNme() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return this.email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	
	// 연락처 정보(이름, 전화번호, 이메일)을 문자열로 리턴하는 메서드
	public String toString() {
		return "Contact(name=" + this.name
				+ ", phone=" + this.phone
				+ ", email=" + this.email
				+ ")";
		
	}
}
