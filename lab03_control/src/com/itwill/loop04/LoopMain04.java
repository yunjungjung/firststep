package com.itwill.loop04;

public class LoopMain04 {

    public static void main(String[] args) {
        /* 369게임: 아래와 같이 출력하세요.
            1   2   *   4   5   *   7   8   *   10
            11  12  *   14  15  *   17  18  *   20
            21  22  *   24  25  *   27  28  *   *
            *   *   *   *   *   *   *   *   *   40
            41  42  *   44  45  *   47  48  *   50
            51  52  *   54  55  *   57  58  *   *
            *   *   *   *   *   *   *   *   *   70
            71  72  *   74  75  *   77  78  *   80
            81  82  *   84  85  *   87  88  *   *
            *   *   *   *   *   *   *   *   *   100
        */
        
        for (int n = 1; n <= 100; n++) {
            int x = n % 10; // n을 10으로 나눈 나머지 => 1의 자릿수
            int y = n / 10; // n을 10으로 나눈 몫 => 10의 자릿수
            boolean condition1 = (x == 3) || (x == 6) || (x == 9); // 1의 자릿수가 3, 6, 9
            boolean condition2 = (y == 3) || (y == 6) || (y == 9); // 10의 자릿수가 3, 6, 9
            
            if (condition1 && condition2) {
                System.out.print("**\t");
            } else if (condition1 || condition2) {
                System.out.print("*\t");
            } else {
                System.out.print(n + "\t");
            }
            
            if (n % 10 == 0) {
                System.out.println();
            }
        }

    }

}


//package com.itwill.loop04;
//
//public class LoopMain04 {
//
//    public static void main(String[] args) {
//        /* 369게임: 아래와 같이 출력하세요.
//            1   2   *   4   5   *   7   8   *   10
//            11  12  *   14  15  *   17  18  *   20
//            21  22  *   24  25  *   27  28  *   *
//            *   *   *   *   *   *   *   *   *   40
//            41  42  *   44  45  *   47  48  *   50
//            51  52  *   54  55  *   57  58  *   *
//            *   *   *   *   *   *   *   *   *   70
//            71  72  *   74  75  *   77  78  *   80
//            81  82  *   84  85  *   87  88  *   *
//            *   *   *   *   *   *   *   *   *   100
//        */
//    	
//    	for(int n = 1; n <= 100; n++) {
//    		
//    		int x = n % 10;
//    		int y = n / 10;
//    		// 결과가 int 니까 int 타입으로 선언함
//    		boolean condition1 = (x == 3) || (x == 6) || (x == 9);
//    		boolean condition2 = (y == 3) || (y == 6) || (y == 9);
//    		// boolean 타입 true 또는 faluse 값 저장.
//    		// 1의 자리 숫자가 3인 경우 또는 이여서 뒤에 것은 계산할 필요 없고 바로 true 값이 변수에 저장된다.
//    		// 해당하지 않는 경우에는 ()||()||() 검사 후에 아니니까 false 값이 변수에 저장됨.
//    		// A && B 인 경우 자바에서 둘 다 계산.
//    		// A || B 인 경우 앞 쪽이 false이면 뒷 쪽 B계산 안하고 그냥 false
//    		// A || B 인 경우 앞 쪽이 ture이면 뒷 쪽 B계산 안하고 그냥 true
//    		if(condition1 && condition2) {
//    			System.out.print("**\t");
//    		} else if(condition1 || condition2) {
//    			System.out.print("*\t");
//    		} else {
//    			System.out.print(n+"\t");
//    		}
//    		if(n % 10 == 0) {
//    			System.out.println();
//    		}
//    	}
//    	
//    }
//}

