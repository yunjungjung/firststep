package com.itwill.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 문자열 1차원 배열
		String[] leSserfim = {"채원", "사쿠라", "운진", "카즈하", "은채"};
		String[] newJeans = {"혜인", "해린", "민지", "하니", "다니엘"};
		String[] bts = {"정국", "뷔", "RM", "지민", "슈가", "제이홉", "진"};
		
		// 문자열 2차원 배열
		String[][] idols = {leSserfim, newJeans, bts};
		
		 for (int i = 0; i < idols.length; i++) {
	            for (int j = 0; j < idols[i].length; j++) {
	                System.out.print(idols[i][j] + " ");
	            }
	            System.out.println();
	        }
		 
		 // 2차원 배열의 내용을 향상된 for 문을 사용해서 출력
		 System.out.println("-------------------------");
		 for (String[] gruop : idols) {
			   for (String name : gruop) {
				 System.out.print(name + "\t");
			    }
			   System.out.println();
		 }
	}
}