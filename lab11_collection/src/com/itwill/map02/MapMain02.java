package com.itwill.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고(아규먼트 첫번째), 정수를 value(아규먼트 두번째)로 하는 TreeMap을 선언, 초기화.
		TreeMap<String, Integer> menu = new TreeMap<> ();
		
		// 데이터 저장
		menu.put("짜장면", 7000);
		menu.put("짬뽕", 8000);
		menu.put("볶음밥", 8000);
		
		// 출력
		System.out.println(menu);
		
		Set<String> keySet = menu.keySet(); // String을 저장하는 key들의 집합
		for (String k : keySet) { // keySet에서 꺼낸 문자열 k 원소
			System.out.println(k + " : " + menu.get(k));
		}
		
		// decendingKeySet(): TreeMap에서 내림차순 정렬된 키들의 집합.
		  Set<String> keySet1 = menu.keySet();
	        for (String k : keySet1) {
	            System.out.println(k + " : " + menu.get(k));
	        }
	        
	        // descendingKeySet(): TreeMap에서 내림차순 정렬된 키들의 집합.
	        Set<String> keySet2 = menu.descendingKeySet();
	        for (String k : keySet2) {
	            System.out.println(k + "=" + menu.get(k));
	        }
	        
	    }

	}