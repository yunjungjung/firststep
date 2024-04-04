package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

    public static void main(String[] args) {
        // 교재 연습문제 3
        // 주사위 2개를 던졌을 때 결과를 (x, y) 형식으로 출력.
        // 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
        // (1, 2), (6, 2), ..., (2, 3)
        
        Random random = new Random();
        
        // for ( ; ; ) { ... }
        while (true) { // 무한 루프
            int x = random.nextInt(1, 7); // 1 <= x < 7 범위의 난수.
            int y = random.nextInt(1, 7);
            System.out.printf("(%d, %d)\n", x, y);
            if (x + y == 5) {
                break; // 무한 루프를 멈춤.
            }
        }
        
        System.out.println("----------");
        
        int x;
        int y;
        do {
            x = random.nextInt(1, 7);
            y = random.nextInt(1, 7);
            System.out.printf("(%d, %d)\n", x, y);
        } while (x + y != 5);

        System.out.println("----------");
        
        // 교재 연습문제 4
        // 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기.
        // 단, x와 y는 10 이하의 자연수(1, 2, 3, ..., 9, 10).
        // (x=5, y=8), ...
        for (x = 1; x <= 10; x++) {
            for (y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    System.out.printf("(x=%d, y=%d)", x, y);
                }
            }
        }

    }

}


//package com.itwill.loop12;
//
//import java.util.Random;
//
//public class LoopMain12 {
//
//	public static void main(String[] args) {
//		// 교재 연습문제 3
//		// 주사위 2개를 던졌을 때 결과를 (x,y) 형식으로 출력.
//		// 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
//		// (1,2),(6,2),...,하다가 (2,3) 또는 (3,2) 이게 나오면 멈춤.
//		// 난수 2개 만들기. 난수의 범위 1부터 7보다 작을 때 까지.
//		// 출력하고 5가 됐는지 안 됐는지 검사해보고 무한루프로 시작했으면 break;필요
//		Random random = new Random();
//		//int x = random.nextInt(1,7);
//		//int y = random.nextInt(1,7);
//		//System.out.printf("(%d,%d)\n",x,y);	
//		//System.out.println("눈의 합 : " + (x + y));
//		while(true) {
//			int x = random.nextInt(1,7);
//			int y = random.nextInt(1,7);
//			System.out.printf("(%d,%d) 눈의 합 : %d\n",x,y,(x+y));
//			if (x+y == 5) {
//				break;
//			}
//		}
//		// 교재 연습문제 4
//		// 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기.
//		// 범위 제한 
//		// 단, x와 y는 10 이하의 자연수 (1,2,3,...,9,10)
//		// 예) (x=5, y=8), ... 이런건 프로그램으로 찾아보자.
//			
//
//	}
//
//}