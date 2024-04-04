package com.itwill.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// 메서드 오버로딩(method overloding): 
		// 메서드의 파라미터(()안에 들어있는 값)가 다르면 같은 이름으로 메서드를 여러개 선언(장의)할 수 있음.
		// (주의) 메서드의 파라미터는 동일하고 리턴 타입만 다르게는 오버로딩할 수 없음.
		
		System.out.println("안녕하세요"); // println(String x) //문자
		System.out.println(100); //println(int x) // 정수
		System.out.println(); // println() // 
		System.out.println(true); // println(boolean x) // 논리
		
		newLine(); // 호출할때 아무것도 넣어주지 않으면 파라미터를 갖지 않는 메서드를 찾음.
		newLine(3); // 호출할때 값을 넣어주면 파라미터로 int타입 1개만 선언되어 있는 메서드를 찾음. ->11번째 줄
		
		System.out.println("======");
	}

	/**
	 * 콘솔에 빈 줄 하나를 출력하는 메서드.
	 */
	public static void newLine() {
		System.out.println();
	}
	
	public static int newLine() {
		return 0;
	}
	
	/**
	 * 콘솔에 n개의 빈 줄을 출력하는 메서드.
	 * @param n 콘솔에 출력할 빈 줄의 개수. 0 또는 양의 정수. 만약 0 또는 음수이면 아무것도 출력하지 않음.
	 */
	
	public static void newLine(int n) {
		for (int i = 0; i < n; i++) {
		System.out.println();
		}
	}
}
