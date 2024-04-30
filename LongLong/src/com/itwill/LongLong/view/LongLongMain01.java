package com.itwill.LongLong.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import com.itwill.jdbc.view.BlogCreateFrame;
//import com.itwill.jdbc.view.BlogMain;
//import com.itwill.jdbc.view.LongLongMain;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LongLongMain01 {

	private JFrame frame;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongLongMain01 window = new LongLongMain01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LongLongMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("다이어리 메인");
		frame.setBounds(100, 100, 588, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setForeground(new Color(90, 90, 90));
		titlePanel.setBounds(0, 10, 579, 74);
		frame.getContentPane().add(titlePanel);
		
		JLabel lblTitle = new JLabel("<html> HAPPY<br>아롱 & 다롱 다이어리</html>");
		lblTitle.setForeground(new Color(107, 105, 105));
		titlePanel.add(lblTitle);
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 26));
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\image01.jpg"));
		lblImage.setBounds(0, 94, 572, 342);
		frame.getContentPane().add(lblImage);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 471, 572, 74);
		frame.getContentPane().add(buttonPanel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(90, 90, 90));
		btnHome.addActionListener(new ActionListener() {
			  @Override
	            public void actionPerformed(ActionEvent e) {
	                // 새 블로그 작성 창 띄우기
//	            	LongLongDiaryFrame.showLongLongDiaryFrame();
	            }
	        });
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 22));
		buttonPanel.add(btnHome);
		
		JButton btnDiary = new JButton("Diary");
		btnDiary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LongLongDiaryFrame.showLongLongDiaryFrame();
			}
		});
		btnDiary.setForeground(new Color(90, 90, 90));
		btnDiary.setFont(new Font("D2Coding", Font.BOLD, 22));
		buttonPanel.add(btnDiary);
		
		JButton btngallery = new JButton("Gallery");
		btngallery.setForeground(new Color(90, 90, 90));
		btngallery.setFont(new Font("D2Coding", Font.BOLD, 22));
		buttonPanel.add(btngallery);
		
		JButton btnVisitor = new JButton("Visitors' book");
		btnVisitor.setForeground(new Color(90, 90, 90));
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisitor.setFont(new Font("D2Coding", Font.BOLD, 22));
		buttonPanel.add(btnVisitor);
	}
}
