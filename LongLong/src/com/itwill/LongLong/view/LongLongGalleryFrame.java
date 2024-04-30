package com.itwill.LongLong.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class LongLongGalleryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnFrontImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongLongGalleryFrame frame = new LongLongGalleryFrame();
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
	public LongLongGalleryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("사진");
		lblNewLabel.setBounds(12, 10, 451, 293);
		contentPane.add(lblNewLabel);
		
		btnFrontImage = new JButton("이전 사진");
		btnFrontImage.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnFrontImage.setForeground(new Color(95, 95, 95));
		btnFrontImage.setBounds(62, 322, 121, 42);
		contentPane.add(btnFrontImage);
		
		JButton btnNextImage = new JButton("다음 사진");
		btnNextImage.setForeground(new Color(95, 95, 95));
		btnNextImage.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnNextImage.setBounds(273, 322, 121, 42);
		contentPane.add(btnNextImage);
	}

}
