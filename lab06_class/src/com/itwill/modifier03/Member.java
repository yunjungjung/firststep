package com.itwill.modifier03;

public class Member {
	private String memberId; // 읽기 전용 필드
	private String memberPassword; // 읽기/쓰기 필드
	
	// constructor
	public Member(String memberId, String memberPassword) {
		if (memberId !=null && memberPassword != null) {
		    this.memberId = memberId;
		    this.memberPassword = memberPassword;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// method
	// getter 메서드/ 아규먼트 필요 ㅇ (리턴값 필요 ㅇ)
	public String getMemberId() {
		return this.memberId;
	}
	
	public String getMemberPassword() {
		return this.memberPassword;
	}

	// setter 메서드/ 아규먼트 필요 x (리턴값 필요 x)
	public void setMemberPassword(String password) {
		if (password != null) 
			this.memberPassword = password;
	}
}