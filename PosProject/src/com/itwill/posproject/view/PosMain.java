package com.itwill.posproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;






public class PosMain extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblNewLabel;
	private JPanel buttonPanel;
	private JButton btnOrder;
	private JButton btnInventory;
	private JButton btnSales;
	private Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosMain frame = new PosMain();
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
	public PosMain() {
		setTitle("sweet pos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 615);
		setLocationRelativeTo(null);//화면 중앙에 창이 뜨게 하기.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("SWEET POS");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(107, 105, 105));
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 26));
		lblTitle.setBounds(329, 36, 207, 64);
		contentPane.add(lblTitle);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\images\\image01.png"));
		lblNewLabel.setBounds(279, 110, 314, 187);
		contentPane.add(lblNewLabel);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(132, 324, 609, 214);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnOrder = new JButton("주문");
		btnOrder.addActionListener(new ActionListener() {
			@Override
			// 주문창 화면 띄우기
			public void actionPerformed(ActionEvent e) {
				PosOrderFrame.showPosOrderFrame();
			}
		});
		btnOrder.setForeground(new Color(108, 108, 108));
		btnOrder.setFont(new Font("D2Coding", Font.BOLD, 17));
		btnOrder.setBounds(241, 10, 115, 40);
		buttonPanel.add(btnOrder);
		
		btnInventory = new JButton("재고");
		btnInventory.setForeground(new Color(108, 108, 108));
		btnInventory.setFont(new Font("D2Coding", Font.BOLD, 17));
		btnInventory.setBounds(241, 60, 115, 40);
		buttonPanel.add(btnInventory);
		
		btnSales = new JButton("매출");
		btnSales.setForeground(new Color(108, 108, 108));
		btnSales.setFont(new Font("D2Coding", Font.BOLD, 17));
		btnSales.setBounds(241, 111, 115, 40);
		buttonPanel.add(btnSales);
		
		JButton btnProduct = new JButton("상품관리");
		btnProduct.setForeground(new Color(108, 108, 108));
		btnProduct.setFont(new Font("D2Coding", Font.BOLD, 17));
		btnProduct.setBounds(241, 161, 115, 40);
		buttonPanel.add(btnProduct);
	}
}
