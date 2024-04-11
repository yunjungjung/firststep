package com.itwill.list03;

import java.util.ArrayList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		// 1. 정수를 저장할 수 있는 ArrayList를 선언 (변수이름은 (numbers)), 객체 생성.
		ArrayList<Integer> numbers = new ArrayList<>();
		
		
		// 2. numbers에 [0, 100) 범위 (0이상 100 미만)의 난수 20개를 저장.
		//[}대괄호는 이상. ()소괄호는 미만.
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			numbers.add(random.nextInt(100));
		}
		
		
		// 3. numbers를 출력.
		System.out.println("numbers = " + numbers);
		
		
		//4. 홀수들만 저장할 수 있는 ArrayList를 선언(변수이름은 (odds)), 객체 생성.
		ArrayList<Integer> odds = new ArrayList<>();
		
		
		//5. numbers에 저장된 숫자들 중에서 홀수들을 찾아서 odds에 저장.
		// 반복문 사용
		for (int n : numbers ) {
			if (n % 2 != 0) {
				odds.add(n);
			}
		}
		
		//6. odd를 출력
		System.out.println("odds = " + odds);
		
				
		//7. 정수를 저장할 수 있는 ArrayList를 선언(evenSqaures), 객체 생성.
		ArrayList<Integer> evenSqaures = new ArrayList<>();
		
		
		// 8. numbers에 저장된 숫자들 중에서 짝수를 찾아서 짝수의 제곱을 evenSquares에 저장.
		for (int n : numbers) {
			if (n % 2 == 0) {
				evenSqaures.add(n * n);
			}
		}
		
		// 9. evenSqaures 출력.
		System.out.println("evenSqaures = " + evenSqaures);
		
	}

}
