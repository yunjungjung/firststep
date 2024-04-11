package com.itwill.ver04.controller;

import java.util.List;

import com.itwill.ver04.model.Contact;
import com.itwill.ver04.util.FileUtil;

// import static ����: Ŭ�������� public static���� ����� ���(�ʵ�, �޼���)�� �̸� ������.
// import static com.itwill.ver04.util.FileUtil.initializeData;
import static com.itwill.ver04.util.FileUtil.*;

// MVC ��Ű���Ŀ��� Controller ���� ��� Ŭ����. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
    //----- singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {
        // ������ ���� �ʱ�ȭ: ������ ������ ���� ����.
        initializeDataDir();
        
        // ����ó ������ �ʱ�ȭ: ������ ���Ͽ��� ����Ʈ�� �о���ų�, �� ����Ʈ�� ����.
        contacts = initializeData();
    }
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //----- singleton
    
    private List<Contact> contacts;
    
    /**
     * �ε����� ����ó ����Ʈ�� ��ȿ�� ���� �ȿ� �ִ� ���� ����.
     * @param index �˻��� �ε���.
     * @return ��ȿ�� �ε����̸� true, �׷��� ������ false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact); // ����Ʈ(�޸�)�� �߰�.
        writeDataToFile(contacts); // ���Ͽ� ��.
        
        return 1;
    }

    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts.set(index, contact);
        writeDataToFile(contacts);
        
        return 1;
    }

    @Override
    public int delete(int index) {
        if (isValidIndex(index)) {
            contacts.remove(index);
            writeDataToFile(contacts);
            return 1;
        } else {
            return 0;
        }
    }

}