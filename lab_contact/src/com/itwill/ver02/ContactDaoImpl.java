package com.itwill.ver02;

import com.itwill.ver01.Contact;

// 컨트롤러 -> 싱글턴으로 구현
public class ContactDaoImpl implements ContactDao {
	
	//(1)
    private static ContactDaoImpl instance = null; 

    //(2)
    private ContactDaoImpl() {}; 
    
    // (3)
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    
    // 연락처를 저장할 배열
    private Contact[] contacts = new Contact[MAX_LENGTH]; 
    
	// 연락처 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.
	
	public int getCount() {
		return count;
	}

	@Override
	public int create(Contact contact) {
		if (count < MAX_LENGTH) {
			contacts[count] = contact;
			count++;
			return 1; // 새로운 연락처 배열에 저장 성공
		} else {
			System.out.println("저장할 공간이 없습니다.");
			return 0; // 배열이 가득 차서 저장 실패
		}
	}

	@Override // 배열 contacts의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴.
	public Contact[] read() {
		
		return contacts;
	}

	@Override // 인덱스가 음수값이거나 배열 길이(3) 보다 크게 들어오는 경우 에러 발생 IF문으로 예외 처리
	public Contact read(int index) {
	  // 인덱스가 양수값이거나 배열 길이보다 작은 경우 정삭 작동
		if (index >= 0 && index < MAX_LENGTH) {
		  return contacts[index];
	  } else { // 인덱스가 유효하지 않은 경우 null 반환
		return null;
		}
	}

	@Override
	public int update(int index, String n, String p, String e) {
		if (index >= 0 && index < count) {
            Contact contact = contacts[index];
            contact.setName(n);
            contact.setPhone(p);
            contact.setemail(e);
            return 1; // 성공
        } else {
            return 0; // 실패
        }
    }
}