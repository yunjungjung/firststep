package com.itwill.posproject.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.itwill.posproject.model.Order;

import java.awt.Color;

public class PosMain {

    private JFrame frame;
    private JLabel lblTitle;
    private JButton btnInventory;
    private JButton btnSales;
    private JLabel lblBackground;
    private JLabel lblTitle_1;
    private JLabel lblTitle_2;
    private JLabel lblTitle_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PosMain window = new PosMain();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PosMain() {
        initialize();
        initializeTable();
    }

    private void initializeTable() {

    }

    private void resetTable(List<Order> orders) {
        // TODO Auto-generated method stub
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 615);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("포스 메인");
        frame.getContentPane().setLayout(null);

        // 아이콘 창 바꾸기
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/posproject/images/아이스크림.png"));
        frame.setIconImage(img);

        lblTitle = new JLabel("SWEET POS");
        lblTitle.setForeground(new Color(0, 102, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Microsoft Tai Le", Font.BOLD, 49));
        lblTitle.setBounds(284, 38, 295, 98);
        frame.getContentPane().add(lblTitle);

        // 주문
        JButton btnOrder = new JButton("");
        btnOrder.setIcon(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/메인버튼01 (1).png")));
        btnOrder.setBorderPainted(false);
        btnOrder.setForeground(new Color(0, 51, 255));
        btnOrder.setFont(new Font("Monospaced", Font.BOLD, 21));
        btnOrder.setContentAreaFilled(false); // 배경을 투명하게 설정
        btnOrder.addActionListener(new ActionListener() {
            @Override
            // 주문창 화면 띄우기
            public void actionPerformed(ActionEvent e) {
                PosOrderFrame.showPosOrderFrame();
            }
        });
        btnOrder.setBounds(264, 122, 84, 98);
        frame.getContentPane().add(btnOrder);

        // 재고 관리
        btnInventory = new JButton("");
        btnInventory.setIcon(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/메인버튼01 (1).png")));
        btnInventory.setBorderPainted(false);
        btnInventory.setForeground(new Color(0, 51, 255));
        btnInventory.setContentAreaFilled(false); // 배경을 투명하게 설정
        btnInventory.addActionListener(new ActionListener() {
            @Override
            // 재고관리창 화면 띄우기
            public void actionPerformed(ActionEvent e) {
                PosInventoryFrame.showPosInventoryFrame();
            }
        });
        btnInventory.setFont(new Font("Monospaced", Font.BOLD, 21));
        btnInventory.setBounds(392, 132, 84, 98);
        frame.getContentPane().add(btnInventory);

        // 매출 관리
        btnSales = new JButton("");
        btnSales.setIcon(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/메인버튼01 (1).png")));
        btnSales.setBorderPainted(false);
        btnSales.setForeground(new Color(0, 51, 255));
        btnSales.setContentAreaFilled(false); // 배경을 투명하게 설정
        btnSales.addActionListener(new ActionListener() {
            @Override
            // 매출관리창 화면 띄우기
            public void actionPerformed(ActionEvent e) {
                PosSalesFrame.showPosSalesFrame();
            }
        });
        btnSales.setFont(new Font("Monospaced", Font.BOLD, 21));
        btnSales.setBounds(517, 122, 84, 98);
        frame.getContentPane().add(btnSales);

        lblTitle_1 = new JLabel("주문");
        lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle_1.setForeground(new Color(0, 102, 255));
        lblTitle_1.setFont(new Font("굴림", Font.BOLD, 25));
        lblTitle_1.setBounds(250, 230, 104, 38);
        frame.getContentPane().add(lblTitle_1);
        
        JLabel lblTitle_1_1 = new JLabel("재고관리");
        lblTitle_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle_1_1.setForeground(new Color(0, 102, 255));
        lblTitle_1_1.setFont(new Font("굴림", Font.BOLD, 25));
        lblTitle_1_1.setBounds(380, 241, 104, 38);
        frame.getContentPane().add(lblTitle_1_1);
        
        JLabel lblTitle_1_2 = new JLabel("매출관리");
        lblTitle_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle_1_2.setForeground(new Color(0, 102, 255));
        lblTitle_1_2.setFont(new Font("굴림", Font.BOLD, 25));
        lblTitle_1_2.setBounds(517, 230, 104, 38);
        frame.getContentPane().add(lblTitle_1_2);
        
                lblBackground = new JLabel(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/배경화면.jpg")));
                lblBackground.setBounds(0, 0, 884, 576);
                frame.getContentPane().add(lblBackground);
    }
}
