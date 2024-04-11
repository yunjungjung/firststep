package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

    public static void main(String[] args) {
        // 1. ArrayList<Student> 객체 생성
        ArrayList<Student> students = new ArrayList<>();
        
        // 2. 1,000,000개의 Student 객체를 리스트에 저장 - Random 이용
        Random random = new Random();
        
        for (int i = 0; i < 1_000_000; i++) {
            Score score = new Score(random.nextInt(101), random.nextInt(101), random.nextInt(101));
            Student student = new Student(i, "NAME_" + i, score);
//            Student s = new Student(i, "NAME", random.nextInt(101), random.nextInt(101), random.nextInt(101));
            students.add(student);
        }
        
        // 3. 리스트를 students.dat 파일에 (직렬화해서) 씀.
        String file = "data/students.dat";
        
        try (
                FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
        ) {
            long start = System.currentTimeMillis();
            
            oout.writeObject(students); // 직렬화(serialize)
            
            long end = System.currentTimeMillis();
            System.out.println("write time: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 4. 파일에서 데이터를 읽어서 역직렬화 -> 읽은 데이터 확인.
        try (
                FileInputStream in = new FileInputStream(file);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
            long start = System.currentTimeMillis();
            
            ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
            
            long end = System.currentTimeMillis();
            System.out.println("read time: " + (end - start) + "ms");

            // 데이터  확인.
            System.out.println("students size = " + students.size());
            int index = random.nextInt(1_000_000);
            System.out.println("students: " + students.get(index));
            
            System.out.println("list size = " + list.size());
            System.out.println("list: " + list.get(index));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}