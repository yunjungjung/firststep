package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

    public static void main(String[] args) {
        // 교재 연습문제 7
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
        Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서.
        
        while (run) {
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택> ");
            int menu = scanner.nextInt();
            switch (menu) {
            case 1:
                System.out.print("입금액>> ");
                int deposit = scanner.nextInt();
                balance += deposit;
                System.out.printf("입금: %d, 잔고: %d\n", deposit, balance);
                break;
            case 2:
                System.out.print("출금액>> ");
                int withdraw = scanner.nextInt();
                balance -= withdraw;
                System.out.printf("출금: %d, 잔고: %d\n", withdraw, balance);
                break;
            case 3:
                System.out.println("잔고: " + balance);
                break;
            case 4:
                run = false; // while 문을 종료하기 위한 조건 변경.
                System.out.println("안녕히 가세요~");
                break; // switch 문장을 종료.
            default:
                System.out.println("1~4 중에서 선택하세요!");
            }
            
        }
        
        System.out.println("프로그램 종료");
    }

}


//package com.itwill.loop14;
//
//import java.util.Scanner;
//
//public class LoopMain14 {
//
//	public static void main(String[] args) {
//		// 교재 연습문제7
//		boolean run = true; 
//		int balance = 0; //balance는 은행 잔고, 마이너스 통장도 가능하다고 생각
//		Scanner scanner = new Scanner(System.in);
//		//int i = scanner.nextInt();
//		while(run) { // while값 조건 run값이 true여서 무한 루프. 종료 원할 때는 변수 run값을 false로 변경해준다.
//			System.out.println("-----------------------------");
//			System.out.println("1.예금 |2.출금 |3.잔고 |4.종료");
//			System.out.println("-----------------------------");
//			System.out.print("선택> ");
//			
//			int i = scanner.nextInt(); // 콘솔에 입력한 값을 i에 저장
//			 
//			switch (i) { 
//			case 1 : 
//				//예금금액?
//				System.out.print("예금액> ");
//				int s = scanner.nextInt(); // 콘솔에 입력한 값을 변수 s에 저장(예금액)
//				balance = balance + s; // 은행잔고 + 예금액을 은행잔고에 저장
//				System.out.println();
//				System.out.println(s + "원이 예금 되었습니다."); //콘솔에 입력한 예금액 출력.예금 잘 되었다 표시
//				break; 
//			case 2 : 
//				// 얼마 출금? 기다렸다가 입력하면 출금액 나오게.은행잔고 변경되게.
//				System.out.print("출금액> ");
//				int w = scanner.nextInt(); 
//				balance = balance - w; // 은행잔고 - 출금액을 은행잔고에 저장
//				System.out.println();
//				System.out.println(w + "원이 출금 되었습니다."); //출금액 출력
//				break; 
//			case 3 : 
//				System.out.print("잔고> ");
//				System.out.println(balance+"원"); //은행잔고
//				break; 
//			case 4 : 
//				System.out.println("이용해 주셔서 감사합니다.\n"); // 종료시 문구
//				run = false; 
//				break;
//				
//			default :
//				System.out.println("입력을 잘못 하였습니다. 다시 입력해주세요.");
//				
//			}
//			
//			
//		}
//		System.out.println("프로그램 종료");
//	}
//
//}