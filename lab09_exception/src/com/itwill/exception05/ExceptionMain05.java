package com.itwill.exception05;

import java.util.Scanner;

/*
 * multi-catch 블록
 * 하나의 catch 구문에서 여러개의 Exception 타입 객체를 처리하는 방법.
 * 
 * try {
 *    // TODO
 * } catch (Exception1 | Exception2 | ... e) {
 *    // TODO
 * }
 * 
 * (주의) 상속 관계가 있는 예외 클래스들은 multi-catch 블록에서 사용할 수 없음.
 * 가능한 예: catch (ArithmeticException | NumberFormatException e)
 * 컴파일 에러: catch (ArithmeticException | Exception e)
 */

public class ExceptionMain05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("x = ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.println("y = ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.println("x / y = " + ( x /y ));
		} catch  (NumberFormatException | ArithmeticException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
