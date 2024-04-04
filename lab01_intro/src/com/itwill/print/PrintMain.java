package com.itwill.print;

public class PrintMain {

	public static void main(String[] args) {
		//여러가지 콘솔 출력 방법:
		
		System.out.println("한 줄 출력(print line)");
		System.out.println("1+2");
		System.out.println(1+2);
		System.out.println("1+2="+3);
		System.out.println("1+2="+1+2);
		System.out.println("1+2="+(1+2));
		
		System.out.print("안녕하세요~");
		System.out.println("Hello");
		
		System.out.printf("문자열 포맷: 정수(%d), 실수(%f), 문자열(%s)\n",123,3.14,"홍길동");
		System.out.printf("%d+%d = %d",1,2,(1+2));
	}

}
