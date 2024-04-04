package com.itwill.array03;

import java.util.Random;

public class ArrayMain03 {

	public static void main(String[] args) {
		// 할일 : 시험점수 성적처리프로그램 만드려고 한다.
		// 점수은 난수로 만들고, 배열에 저장시키고 배열에 저장된 점수들의 합계와 평균을 출력하기.
		
		// 선생님이 써주는 주석 순서대로만 작성해도 된다.
		
		// Random타입 변수선언 & 초기화
		Random random = new Random();
		// 성적 여러개. 점수들을 저장할 수 있는 배열이 있어야 함.
		// 점수는 int타입
		// int 타입 5개를 저장할 수 있는 배열. 배열 이름은 scores을 선언하고 기본값(0)으로 초기화하기
		int[] scores = new int[5];
		// 인덱스 번호마다 난수를 저장해야 됨.
//		scores[0] =random.nextInt(1,11); 
//		scores[1] =random.nextInt(1,11);
//		scores[2] =random.nextInt(1,11);
//		scores[3] =random.nextInt(1,11);
//		scores[4] =random.nextInt(1,11);
			
		// 일반 for문을 사용해서 5개의 정수 난수(점수)를 배열에 저장하면 됨.
		for (int i = 0; i < scores.length; i++ ) { 
			scores[i] = random.nextInt(11);

		} System.out.println();
		// 나중에 맞게 됐나 확인 하기 쉽도록 난수를 0~10까지만 해서 배열에 저장.
		// 어떤 숫자들이 저장되어있는지 모르니까(난수라서)
		// 향상된 for문을 사용해서 배열에 저장된 모든 정수들을 출력해서 확인해보기.
			for(int x : scores) {
				System.out.print(x+" ");
			}
			System.out.println();
		// 배열의 모든 원소들의 합계를 계산하고 출력
			int sum = 0; // sum = 0번지의 원소 꺼내서 + 1번지의 원소 꺼내서 + ...+ 마지막 번지의 원소
			// 일반 for문 보다는 향상된 for문을 이용하는 것이 더 간단.
			
			for(int x : scores) { // 순차적으로 꺼내와서 다 더한 것
				sum += x;
			}
			
			// 일반 for문 사용.
			for(int i = 0;i < scores.length; i++) {
				sum += scores[i];
			}
			System.out.println("합계 : " + sum);
		// 배열의 원소들의 평균을 계산하고 출력
			//double mean = sum / scores.length; //이렇게 쓰면 소수점 계산 정확히 안됨
			double mean = (double) sum / scores.length; //sum과 scores.length 둘 다 int여서 double로 강제변환. 
			System.out.println("평균 : " + mean);
		// 힌트 :  평균은 합계만 계산이 되면 원소의 개수로 나눠주면 됨. /5
		// 합계는 어제 반복문 연습중 1~10 다 하나씩 더 할때 썼던 반복문과 비슷.
		// sum += x
		// 순서대로 더하기
			
			
				 

	}

}