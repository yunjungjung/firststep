package com.itwill.inheritance06;

import java.util.Objects;

public class User {
	// field 
	private String id;
	private String password;
	
	// constructors
	public User() {}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		
	}
	
	// toString 재정의 -id와 password를 출력.
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}

	// hashCode 재정의 - id가 같은 User 객체는 같은 정수값이 리턴되도록.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// equals 재정의 - id만 같으면 같은 객체, 그렇지 않으면 다른 객체.
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //주소값이 같으면 같은 객체
			return true;
		if (obj == null) // 비교할 대상이 없을때 false.
			return false;
		if (getClass() != obj.getClass()) // 앞에 get은 user1  뒤에 있는 get은 use2를 호출
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
		
		
//  public boolean equals(Object obj) {
//    boolean result = false;
//    if (obj instanceof User && id ! = null) {
//        User other = (User) obj;
//        result = id.equals(other.id);
//	}
    }
}
     