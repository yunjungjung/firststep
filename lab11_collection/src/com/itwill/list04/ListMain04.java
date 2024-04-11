package com.itwill.list04;

import java.util.Arrays;
import java.util. ArrayList;
import java.util.List;

public class ListMain04 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "sql", "html", "css", "javascript",
                "servlet", "jsp", "spring");
        //스트링을 저장하는 리스트 8개의 문자열을 가지고 있는 리스트에서
        
        // 1. names에서 5글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        // -> [JAVASCRIPT, SERVLET, SPRING]
        ArrayList<String> namestoUpperCase = new ArrayList<>();
        for (String s : names) {
	    	if (s.length() >=5) {
	    		namestoUpperCase.add(s.toUpperCase());  		
	    	}
        }
        System.out.println(namestoUpperCase);

        // 2. names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        // -> [4, 3, 4, 3, 10, 7, 3, 6]
        ArrayList<Integer> nameLength = new ArrayList<>();
        for(String s : names) {
        	nameLength.add(s.length());

        }
        System.out.println(nameLength);
       
        
        // 3. codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력.
         List<Integer> codes = Arrays.asList(0, 1, 0, 1, 1, 0);
         ArrayList<String> genderName = new ArrayList<>();
         for(Integer s : codes) {
        	 if (s == 0) {
        		 genderName.add("남성");
  
        	 } else {
        		 genderName.add("여성");
        	 }
         } 
         System.out.println(genderName);
         
    }
}