
package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	
	public interface UpdateNotify {
		void notifyContactUpdated();
	}
	
	private UpdateNotify app;// 메인 쓰레드 주소를 저장하기 위한 객체
	
	
	private int index;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel lblName;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JLabel lblPhone;
    private JLabel lblEmail;
    
    private ContactDao dao = ContactDaoImpl.getInstance();
	private Component frame;

    
    /**
     * Launch the application.
     * @param contactMain05 
     * @param index 
     * @param frame 
     */
    public static void showContactUpdateFrame(int index) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(index);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(int index) {
    	this.index = index;
    	initialize();
    	initializeTextFields();
    	
    }
    
private void initializeTextFields() {
		// 3개의 텍스트필드에 해당 인덱스의 연락처 정보를 채움.
	Contact contact = dao.read(index);
	textName.setText(contact.getName());
	textPhone.setText(contact.getPhone());
	textEmail.setText(contact.getEmail());
	}

//    private String getEmail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private String getPhone() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void initialize() {
    	setTitle("연락처 업데이트");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 542, 367);
        
       
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblName.setBounds(12, 10, 121, 64);
        contentPanel.add(lblName);
        
        textName = new JTextField(dao.read(index).getName());
        textName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textName.setBounds(145, 10, 359, 64);
        contentPanel.add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblPhone.setBounds(12, 84, 121, 64);
        contentPanel.add(lblPhone);
        
        textPhone = new JTextField(dao.read(index).getPhone());
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textPhone.setColumns(10);
        textPhone.setBounds(145, 84, 359, 64);
        contentPanel.add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEmail.setBounds(12, 158, 121, 64);
        contentPanel.add(lblEmail);
        
        textEmail = new JTextField(dao.read(index).getEmail());
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEmail.setColumns(10);
        textEmail.setBounds(145, 158, 359, 64);
        contentPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateContact();
        	}
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCancel);
    }
	 private void updateContact() {
	        // JTextField에서 업데이트 정보들을 읽음.
	        String name = textName.getText();
	        String phone = textPhone.getText();
	        String email = textEmail.getText();
	        
	        Contact contact = new Contact(0, name, phone, email);
	        
	        int result = dao.update(index, contact); //다오를 사용해서 업데이트 내용 읽기
	        if (result == 1) {
	        	// 메인 쓰레드에게 업데이트 성공을 알려줌.
	        app.notifyContactUpdated();
	        dispose();// 현재 창 닫기.
	        } else {
	        	// TODO 업데이트 실패 메시지 보여주기
	        }
	        
	    
	    }

	public static void showContactUpdateFrame(JFrame frame2, int index2, ContactMain05 contactMain05) {
		// TODO Auto-generated method stub
		
	}
	        
	  
	}