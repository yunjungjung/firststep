package com.itwill.LongLong.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.itwill.jdbc.view.BlogCreateFrame;
//import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class LongLongCreateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDate;
	private JTextField textTitle;
	private JLabel lblContent;
	private JTextField textContent;
	private JButton btnSave;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void showLongLongDiaryFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongLongCreateFrame frame = new LongLongCreateFrame();
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
	public LongLongCreateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 498, 321);
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblDate = new JLabel("작성일");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(12, 15, 79, 39);
		lblDate.setForeground(new Color(90, 90, 90));
		lblDate.setFont(new Font("D2Coding", Font.BOLD, 24));
		contentPanel.add(lblDate);
		
		textDate = new JTextField();
		textDate.setBounds(103, 14, 383, 40);
		textDate.setFont(new Font("D2Coding", Font.PLAIN, 28));
		textDate.setColumns(10);
		contentPanel.add(textDate);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(90, 90, 90));
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 24));
		lblTitle.setBounds(12, 65, 79, 39);
		contentPanel.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
		textTitle.setColumns(10);
		textTitle.setBounds(103, 64, 383, 40);
		contentPanel.add(textTitle);
		
		lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setForeground(new Color(90, 90, 90));
		lblContent.setFont(new Font("D2Coding", Font.BOLD, 24));
		lblContent.setBounds(12, 115, 79, 196);
		contentPanel.add(lblContent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 114, 383, 197);
		contentPanel.add(scrollPane);
		
		textContent = new JTextField();
		scrollPane.setViewportView(textContent);
		textContent.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 319, 498, 78);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
	
		btnSave = new JButton("저장");
		//btnSave.addActionListener((e) -> longLongDiaryFrame());
		btnSave.setForeground(new Color(95, 95, 95));
		btnSave.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnSave.setBounds(158, 23, 78, 31);
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnCancel.setForeground(new Color(95, 95, 95));
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnCancel.setBounds(277, 23, 78, 31);
		buttonPanel.add(btnCancel);
	}

//	 public static void showLongLongDiaryFrame(Component parent, CreateNotify app) {
//	        EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                try {
//	                	LongLongDiaryFrame frame = new LongLongDiaryFrame(parent, app);
//	                    frame.setVisible(true);
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        });
//	    }
//	
	
}
