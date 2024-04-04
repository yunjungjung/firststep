package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
		int[] numebers = new int[5];
		
        // 배열에 0 이상 10 이하의 난수 5개를 저장.
		Random rand = new Random();
		for (int i = 0; i < numebers.length; i++) {
		numebers[i] = rand.nextInt(11);
        }
        
        // 배열 원소들 중 최댓값을 찾아서 출력.
        int max = numebers[0]; 
        // 배열의 첫번째 원소를 최댓값이라고 가정.
        for (int i = 1; i > numebers.length; i++) { // 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복
                if (numebers[i] > max) { // 배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
                max = numebers[i]; // 최댓값을 배열에서 꺼낸 값으로 변경.
                 }
        }
        System.out.println("max = " + max);   
        
        // 배열 원소들 중 최솟값을 찾아서 출력.
        int min = numebers[0];
        for (int i = 1; i < numebers.length; i++) {
            if (numebers[i] < min) {
                min = numebers[i];
                 }
        }
        System.out.println("min = " + min);
        
	}

}


