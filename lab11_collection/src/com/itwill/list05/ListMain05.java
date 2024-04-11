package com.itwill.list05;

import java.util.ArrayList;

public class ListMain05 {

	public static void main(String[] args) {
		// Member 타입 객체들을 저장하는 ArrayList를 선언, 초기화
		ArrayList<Member> members = new ArrayList<>();
		
		// members에 원소들을 저장
		members.add(new Member("admin", "1111"));
		members.add(new Member("guest", "guest"));
		members.add(new Member("itwill", "0410"));
		members.add(new Member("TEST", "test"));
		
//      System.out.println(members);
		// 향상된 for 문장을 사용해서 members의 원소들을 출력
		for (Member member : members) {
            System.out.println(member);
		}
		
		// 회원 아이디에 "est"가 포함된 회원 정보를 다른 리스트에 저장하고, 출력.
		// 영문자의 대/소문자는 구분하지 않음.
		 ArrayList<Member> list = new ArrayList<>();
	        for(Member m : members) { //하나씩 원소를 꺼내서 회원의 id를 찾기
	        	// 소문자로 변환하고 "est"가 포함된 회원 정보 추출
	        	if(m.getId().toLowerCase().contains("est")) {
	        		list.add(m); // 리스트에 저장
	        	}
	        }
	        System.out.println(list); //출력
	    
	        // members에서 첫번째로 등장하는 id가 "guest"인 회원 삭제
	    //(1) hashCode랑 equals가 override되어 있는 경우
	     members.remove(new Member("guest", null));
	     System.out.println(members);
	     
	    // (2) hashCode랑 equals가 override되어 있지 않은 경우
	    // 반복문 인력
	     for(int i = 0; i < members.size(); i++) {
	    	 if (members.get(i).getId().equals("guest")) {
	    		 members.remove(i);
	    		 break;
	    	 }
	     } 
	     System.out.println(members);
	        }
	        
		

	}


