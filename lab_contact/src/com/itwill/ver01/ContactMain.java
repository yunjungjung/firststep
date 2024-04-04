package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3;// 연락처 배열의 최대 길이(원소 개수)

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수.
	// 배열에 새로운 연락처 저장될 때마다 count++을 실행.
	
	
	public static void main(String[] args) {
	   System.out.println("*** 연락처 프로그램 v0.1");
	   
	   ContactMain app = new ContactMain();
	   
	      
	   boolean run = true;
	   while (run) {
		 int menu = app.showMainMenu();
		 switch (menu) {
		 case 0:
			 run = false;
			 break;
		 case 1:
			 app.saveNewContact();
			 break;
		 case 2:
			 app.readAllContact();
			 break;
		 case 3:
			 app.readContactByIndex();
		 case 4:
			 app.updateContactByIndex();
			 break;
			 default:
				 System.out.println("메뉴 번호(0 ~ 4)를 확인하세요.");
			 
		 }
	   }
	   
	   System.out.println("*** 프로그램 종료 ***");
	}
	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 수정 ----");
		System.out.println("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if(contacts[index] == null || index >= count) {
			System.out.println("해당 인덱스에는 수정할 정보가 없습니다.");
		
		} else {
		System.out.println("수정전: " + contacts[index].toString());
		
		System.out.println("이름 수정>> ");
		String name = scanner.nextLine();
		
		System.out.println("전화번호 수정>> ");
		String phone = scanner.nextLine();
		
		System.out.println("이메일 수정");
		String email = scanner.nextLine();
		
		//TODO: 입력한 내용으로 배열의 내용을 업데이트.
//		contacts[index].setName(name);
//		contacts[index].setPhone(phone);
//		contacts[index].setemail(email);
        contacts[index] = new Contact(name, phone, email);
        
	}
	}
	
	
	private void readContactByIndex() {
		if(count > MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
	
		} else {
			System.out.println("\n--- 인덱스 검색 ----");	
	    int index = Integer.parseInt(scanner.nextLine());
	    
	    // 해당 인덱스의 연락처를 출력
	    System.out.println(contacts[index].toString());
	    if (index >=0 && index < count) {
	    	
	    }
	}
	}
	private void readAllContact() {
		System.out.println("\n--- 연락처 목록 ---");
		// 인덱스 0번부터 현재 저장된 연락처 개수보다 작을 때까지
		for (int i = 0; i < count; i++) {
		System.out.println(i + " : " + contacts[i].toString());
		}
	}
	
	
	private void saveNewContact() {
		// 배열에 저장된 연락처 개수(count)가 배열 최대 길이와 같아면
		if(count == MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
	
		} else {
		
		System.out.println("\n--- 새 연락처 저장 ---");
		
		
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		
		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.print("이메일 입력>>");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(name, phone, email);
		
		// Contact 타입 객체를 연락처 배열 인덱스 count에 저장
		contacts[count] = contact;
		// 배열의 저장 후에는 연락처 저장 개수(인덱스)를 증가
		count++;
		}
		System.out.println("연락처 저장 성공~!");
	}
	
	private int showMainMenu() {
		System.out.println("\n-----------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스 검색 [4]수정");
		System.out.println("-----------------------------------------");
		System.out.println("선택> ");
		
		int menu = Integer.parseInt(scanner.nextLine());
		
		return menu;
		
	}

}