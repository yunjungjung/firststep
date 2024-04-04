package com.itwill.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		
		
		// 정수 10개를 저장할 수 있는 배열(codes)을 만들고 기본값으로 초기화 하기
		int[] codes = new int[10];
		// 배열 변수이름 codes[]에 1이상 4이하 범위 정수를 임의로 저장.
		Random random = new Random(); // 순서 상관 없음. 랜덤 사용전에만 만들면 됨. 
		// ()안에 숫자 써도 된긴 되는데 굳이 그럴 필요 없음. 난수를 만들어 낼 때 사용.
		for(int i = 0; i < codes.length; i++) { //new int[10]; 10개짜리로 만들어서 codes.length는 10
			codes[i] = random.nextInt(1,5); // 첫번째 위치 이상 두번째 위치 미만. 99%거의 이렇게 되어있음
		} // 10번 반복해야 함. 향상된 for문은 못씀.
		// 배열 codes에 난수를 저장하는데 범위는 1이상 4이하로 설정하기
		// 10번 반복해야..
		// codes의 내용을 출력.
		for(int x:codes) { // codes의 첫번째 값 x에, 2번째 값 x에 ,...10번째 값까지 x에
			System.out.print(x + " ");
		}
		// 코드 값만 저장하는 경우가 많음 값들을 검색해서 가지고 왔을 때
		// 그런데 보고서나 화면에 출력했을 때 값을 성별을 1,2보단 "남성","여성"으로 출력하는 것이 더 나음
		// 1,3은 남성이라고 하는 문자열로. 2,4는 여성이라고 하는 문자열로 저장
		// 필요한 숫자 갯수만큼의 문자열 배열이 필요함
		// 문자열(String) 10개를 저장할 수 있는 배열(genders)를 만들고 기본값으로 초기화하고
		String[] genders = new String[10];
		
		// codes의 원소 값이 1 또는 3이면 "남성"을 2 또는 4 이면 "여성"을
		// genders에 저장한다. // 향상된 for문에서는 값 변경 못함. 향상된 for문에서는 인덱스를 사용하지 못해서.
		// 인덱스 이용해서 저장해야 한다.
		for(int i = 0; i < codes.length; i++) {
			if(codes[i] == 1 || codes[i] == 3) {
			genders[i] = "남성";
		 } else { // 어차피 1~4까지밖에 안나오게 해서 else if  안쓰고 그냥 else써도 된다.
			genders[i] = "여성";
		 }
		}
		
		// 인덱스 [0]번에 "남성", 인덱스 [1]에 "여성"
		// 정수를 문자열로 값을 바꿔서 저장하기
		// genders의 내용을 출력하기.
		for(String g : genders) { 
			System.out.print(g + " ");
		}
	}

}
