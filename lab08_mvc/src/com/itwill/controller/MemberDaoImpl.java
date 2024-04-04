package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 -> 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {
	
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		
		return instance;
	}
	
	// ----------singleton 구현
	
	// 회원 정보를 저장할 배열 선언
	private Member[] members = new Member[MAX_LENGTH];
	
	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.
	
	public int getCount() {
		return count;
	}

	@Override // 배열에 더 이상 저장할 공간이 없는 경우
	//if문 사용 추가할 수 없을때는 리턴값만 0으로 변경
	public int create(Member member) {
		if (count < MAX_LENGTH) { 
	        members[count] = member;
	        count++;
	        return 1; 
	    } else {
	    	System.out.println("저장할 공간이 없습니다."); 
			return 0;
	    }
	  
	}

	@Override
	public Member[] read() {
		// TODO 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴. 사용자 편리성을 고민해보기.

		return members;
		
	}
	
	
	@Override //인덱스가 음수값이거나 배열 길이(3) 보다 크게 들어오는 경우 에러 발생 IF문으로 예외 처리
	public Member read(int index) {
		if (index < 0 || index > MAX_LENGTH) { 
		        return null;
		    } else {
		    	return members[index];
	   }
	}

	@Override // 
	public int update(int index, String password) {
		if (index < 0 || index > count) { 
		members[index].setPassword(password);
		return 0;
	 } else {
		System.out.println("."); 
		return 1;
	}
	}
}
