package com.itwill.array09;

import java.util.Random;

public class ArrayaMain09 {

	public static void main(String[] args) {
		Random random = new Random();
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열(array)을 선언 & 촉화.
		int[][] array2 = new int[3][];
		
		// 2차원 배열 array의 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개,
		array2[0] = new int[2];
		array2[1] = new int[3];
		array2[2] = new int[4];
		
		// 세번째 배열에는 난수 4개를 저장. 난수의 범위는 0 이상 10미만.
		for (int i = 0; i < array2.length; i++)
		      for (int j = 0; j < array2[i].length; j++) {
	               array2[i][j] = random.nextInt(10);
		      }	
		// 2차원 배열  array의 내용을 출력.
	    int sum = 0; // 배열의 원소들의 합을 저장할 변수.
	    int count = 0; // 배열에서 읽은 원소 개수를 증가.
	    
	    for (int[] arr : array2) {
	         for (int x : arr) {
	              System.out.print(x + " ");
	              sum = sum + x;
	              count++;
	           } 
	         
	         System.out.println();           
	    } 	               
		// 2차원 배열의 모든 원소들(정수 9개)의 합을 계산하고 출력.
	         System.out.println("sum = " + sum);
	         System.out.println("count = " + count);
	     
	     
		// 2차원 배열의 모든 원소들(정수 9개)의 평균을 계산하고 출력.
	         System.out.println("average = " + sum / (double) count);

	}

}