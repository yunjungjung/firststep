package com.itwill.posproject.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.posproject.controller.OrderDao;
import com.itwill.posproject.model.Order;
import java.awt.BorderLayout;

public class PosMain {

   JFrame frame;
   
   private OrderDao dao = OrderDao.getInstance();
   private JLabel lblNewLabel;
   private JLabel lblTitle;

   private Object contentPane;
   private JButton btnInventory;
   private JButton btnSales;

   /**
    * Launch the application.
    */
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

   /**
    * Create the application.
    */
   public PosMain() {
      initialize();
      initializeTable();
 
   }

   private void initializeTable() {
        // DAO를 사용해서 DB 테이블에서 검색.
//        List<Order> orders = dao.equals();
//        resetTable(orders); // 테이블 리셋
    }
   

   private void resetTable(List<Order> orders) {
      // TODO Auto-generated method stub
      
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 615);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("포스 메인");
        frame.getContentPane().setLayout(null);
        
        lblTitle = new JLabel("SWEET POS");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("D2Coding", Font.BOLD, 33));
        lblTitle.setBounds(336, 47, 196, 74);
        frame.getContentPane().add(lblTitle);

      setContentPane(contentPane);
      frame.getContentPane().setLayout(null);

      lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\images\\image01.png"));
      lblNewLabel.setBounds(279, 110, 314, 187);
      frame.getContentPane().add(lblNewLabel);
      
      JButton btnNewButton = new JButton("주문");
      btnNewButton.setFont(new Font("D2Coding", Font.BOLD, 20));
      btnNewButton.addActionListener(new ActionListener() {
            @Override
            // 주문창 화면 띄우기
            public void actionPerformed(ActionEvent e) {
               PosOrderFrame.showPosOrderFrame();
            
         }
      });
      btnNewButton.setBounds(369, 320, 135, 50);
      frame.getContentPane().add(btnNewButton);
      
      btnInventory = new JButton("재고관리");
      btnInventory.addActionListener(new ActionListener() {
          @Override
          // 주문창 화면 띄우기
          public void actionPerformed(ActionEvent e) {
             PosInventoryFrame.showPosInventoryFrame();
          
         }
      });
      btnInventory.setFont(new Font("D2Coding", Font.BOLD, 20));
      btnInventory.setBounds(369, 392, 135, 50);
      frame.getContentPane().add(btnInventory);
	      
      
      
      btnSales = new JButton("매출관리");
      btnSales.addActionListener(new ActionListener() {
          @Override
          // 주문창 화면 띄우기
          public void actionPerformed(ActionEvent e) {
             PosSalesFrame.showPosSalesFrame();
          
         }
      });
      btnSales.setFont(new Font("D2Coding", Font.BOLD, 20));
      btnSales.setBounds(369, 464, 135, 50);
      frame.getContentPane().add(btnSales);
      

   }
      
   private void setContentPane(Object contentPane) {
      // TODO Auto-generated method stub
      
   }
}

