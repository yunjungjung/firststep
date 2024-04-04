package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
	
	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();
		
		
		int x = app.inputInteger2();
		System.out.println("x= " + x);
	}
//		public int inputInteger() {
//			int input = 0;
//			
//			 while (true) {
//				 try {
//				System.out.print("정수를 입력하세요.");
//				input = Integer.parseInt(sc.nextLine());
//				break;
//						
//			} catch (NumberFormatException e) {
//				System.out.println("잘못된 입력입니다... x를 정수로 입력하세요.");	
//	        }
//
//        }
//			 return input;
		
	   public int inputInteger2() { //재귀호출
		   int input = 0;
		
		 while(true) {
			 try {
				 System.out.println("정수를 입력하세요.");
				 return Integer.parseInt(sc.nextLine());
			 } catch (NumberFormatException e) {
				 System.out.println("x를 정수로 입력하세요.");
				 return inputInteger2();
			 }
		 }
		 
		}
}