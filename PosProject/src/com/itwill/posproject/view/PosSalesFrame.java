package com.itwill.posproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PosSalesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void showPosSalesFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosSalesFrame frame = new PosSalesFrame();
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
	public PosSalesFrame() {
		setTitle("매출관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(109, 10, 370, 51);
		contentPane.add(searchPanel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
		searchPanel.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 28));
		textField.setColumns(10);
		searchPanel.add(textField);
		
		btnSearch = new JButton("조회");
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
		searchPanel.add(btnSearch);
	}

}
