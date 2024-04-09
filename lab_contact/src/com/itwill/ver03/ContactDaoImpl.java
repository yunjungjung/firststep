package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	// 연락처를 저장하는 ArratList를 생성.
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	//----- singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    
    @Override //새로운 연락처 정보(이름, 전화번호, 이메일)을 리스트에 저장.
    public int create(Contact contact) {
       if (contacts.add(contact)) {
        return 1;
      } else {
    	return 0;
      }
    }
        
    @Override // 연락처 전체 목록 검색.
    public List<Contact> read() {
        return contacts;
    }

    @Override // 인덱스를 사용한 연락처 정보 검색 기능.
    public Contact read(int index) {
        if (isValidIndex(index)) {
        	return contacts.get(index);
        } else {
        	return null;
        }
        
    }

    @Override // 연락처 정보 업데이트 기능.
    public int update(int index, Contact contact) {
    	 if (isValidIndex(index)) {
    		// contacts.set(index, contact);
    		 contacts.get(index).setName(contact.getName());
    		 // 위의 코드 풀이: 연락처의 정보를 가져와서 setName의 연락처 이름을 수정.
         	return 1;
         	} else {
         	return 0;
         }
         
     }

    @Override // 연락처 삭제 기능.
    public int delete(int index) {
        if (isValidIndex(index)) {
        	contacts.remove(index);
        return 1;
        } else {
        	return 0;
        }
    }

	public boolean isValidIndex(int index) {
		
		return (index >=0 && index < contacts.size());

	
	}

}