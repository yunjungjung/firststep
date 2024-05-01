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
	public static void showLongLongGalleryFrame() {
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
		setTitle("롱롱 사진");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(35, 76, 497, 362);
		contentPane.add(lblNewLabel);
		
		btnFrontImage = new JButton("이전 사진");
		btnFrontImage.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnFrontImage.setForeground(new Color(95, 95, 95));
		btnFrontImage.setBounds(140, 476, 121, 42);
		contentPane.add(btnFrontImage);
		
		JButton btnNextImage = new JButton("다음 사진");
		btnNextImage.setForeground(new Color(95, 95, 95));
		btnNextImage.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnNextImage.setBounds(321, 476, 121, 42);
		contentPane.add(btnNextImage);
	}

}
