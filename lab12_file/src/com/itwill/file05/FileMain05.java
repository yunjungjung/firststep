package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

    public static void main(String[] args) {
        // 파일에 쓸(write) 더미 데이터
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(new Product(i, "name_" + i, i));
        }
        System.out.println("size = " + list.size());
        // ArrayList를 저장하는 파일 이름
        String fileName = "data/product_list.dat";

        // 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일에 쓰기
        // FOS, BOS, OOS를 이용.
        FileOutputStream fos = null;
        BufferedOutputStream bos =null; 
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(list); 
           
            System.out.println("Writing to file completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        // 2. 파일에서 객체를 읽어서 ArrayList<product>로 변환하기 (역직렬화)
        // FIS, BIS, OIS를 이용.
        ArrayList<Product> readList = new ArrayList<Product>();
        try (
        		FileInputStream in = new FileInputStream(fileName);
        		BufferedInputStream bin = new BufferedInputStream(in);
        		ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
        	readList = (ArrayList<Product>) oin.readObject();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println(readList.get(50));
        System.out.println(readList.get(500));
        System.out.println(readList.get(1000));
        System.out.println(readList.get(999999));
        
    }
}