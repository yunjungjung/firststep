package com.itwill.switch01;

public class SwitchMain01 {

    public static void main(String[] args) {
        // switch-case 구문:
        // 해당 case 위치로 이동해서 break; 문장을 만날 때까지 실행.
        // 해당하는 case가 없으면 default 블록을 실행.
        // default 블록은 switch 구문에서 항상 가장 마지막에 작성.
        // default 블록은 없어도 됨.
        
        String season = "겨울";
        switch (season) {
        case "봄":
            System.out.println("Spring");
            break;
        case "여름":
            System.out.println("Summer");
            break;
        case "가을":
            System.out.println("Fall");
            break;
        case "겨울":
            System.out.println("Winter");
            break;
        default:
            System.out.println("몰라요~");
        }

        int number = 123;
        switch (number % 2) {
        case 0:
        	System.out.println("짝수");
        	break;
        default :
        	System.out.println("홀수");
        	
        }
        
    }

}