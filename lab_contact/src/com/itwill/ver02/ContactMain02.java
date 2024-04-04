package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;
import com.itwill.ver01.ContactMain;

public class ContactMain02 {
	
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
	private char[][] contact;
	
	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");
		
		// ContactMain 타입 객체의 인스턴스 멤버(필드, 메서드)를 사용하기 위해서.
		ContactMain02 app = new ContactMain02();
		
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


	private int showMainMenu() {
		
		try {
			System.out.println("\n-----------------------------------------");
			System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스 검색 [4]수정");
			System.out.println("-----------------------------------------");
			System.out.print("선택> ");
			
			int menu = Integer.parseInt(scanner.nextLine());
			return menu;
			
		} catch(Exception e) {
			System.out.println("숫자써줭");
			return showMainMenu();
		}
		
		
	
	}

	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 업데이트");

		System.out.println("업데이트할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());

		Contact contact = dao.read(index);
		if (contact == null) {
			
			System.out.println("수정할 연락처 정보가 없습니다.");
		} else {

			System.out.println("수정 전: " + contact);

			System.out.println("새로운 이름>> ");
			String updatename = scanner.nextLine();
			
			System.out.println("새로운 전화번호>> ");
			String updatephone = scanner.nextLine();
			
			System.out.println("새로운 이메일>> ");
			String updateemail = scanner.nextLine();

			// View에서 Controller의 기능을 사용해서 연락처 업데이트
			int result = dao.update (index, updatename, updatephone, updateemail);
			if (result == 1) {
				System.out.println("연락처 수정 성공");
			} else {
				System.out.println("연락처 수정 실패");
			}
		}
	}


	private void saveNewContact() {
		System.out.println("\n-------- 새로운 연락처 정보 저장 ----------");
		System.out.println("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.println("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.println("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);
		int result = dao.create(contact); // View 객체에서 Controller 객체의 기능을 사용.
		if (result == 1) {
			System.out.println("새로운 연락처 정보 저장 성공");
		} else {
			System.out.println("새로운 연락처 정보 저장 실패");
		}
	}
		
	


	private void readAllContact() {
		System.out.println("\n--- 연락처 목록 ---");
		// 인덱스 0번부터 현재 저장된 연락처 개수보다 작을 때까지
		for (int i = 0; i < dao.getCount() ; i++) {
			if (contact[i] != null) {
			System.out.println(contact[i]);
		}
	}
		
	}


	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");

		System.out.println("검색할 인덱스를 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		// View에서 Controller의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴.

		Contact contact = dao.read(index);
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
		}

}
	}