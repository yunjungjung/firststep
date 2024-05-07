package com.itwill.posproject.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PosOrderFrame extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JLabel lblNewLabel_1_2;
   private JButton btnNewButton;
   private JLabel lblNewLabel_1_2_5_1;
   private JLabel lblNewLabel_1_2_5_1_1;
   private JLabel lblNewLabel_1_2_4;
   private JLabel lblNewLabel_1_2_2;
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_1_2_7;
   private JLabel lblNewLabel_1_2_1;
   private JLabel lblNewLabel_1_2_1_1;
   private JButton btnNewButton_5_1;
   private JButton btnNewButton_5_1_1;
   private JTable table;
   
   // 상품의 가격 설정
   private final int PIG_BAR_PRICE = 1000;
   private final int JEWEL_BAR_PRICE = 1000;
   private final int BUNPARAE_PRICE = 1700;
   private final int WA_PRICE = 2000;
   private final int WILD_BODY_PRICE = 1000;
   private final int TANK_BOY_PRICE = 1200;
   private final int COOAND_CRE_PRICE = 1000;
   private final int SSANGSSANG_BAR_PRICE = 1000;
   private final int WASACK_BAR_PRICE = 10800;

    private JTextField textField;
    
   // 상품의 재고
   protected int pigBarStock;
   protected int jewelBarStock;
    
   // 재고 관리를 위한 PosInventoryFrame 인스턴스 생성
   private PosInventoryFrame inventoryFrame;

   /**
    * Launch the application.
    */
   public static void showPosOrderFrame() {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               PosOrderFrame frame = new PosOrderFrame();
               frame.setLocationRelativeTo(null);
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
   public PosOrderFrame() {
      setTitle("주문하기");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 900, 615);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 501, 576);
      contentPane.add(panel);
      panel.setLayout(null);
      
      btnNewButton = new JButton("돼지바");
      btnNewButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "돼지바"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, PIG_BAR_PRICE);
          }
      });
      btnNewButton.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton.setBounds(51, 125, 115, 37);
      panel.add(btnNewButton);
      
      lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_06.jpg"));
      lblNewLabel_1.setBounds(199, 182, 115, 88);
      panel.add(lblNewLabel_1);
      
      lblNewLabel_1_2 = new JLabel("");
      lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524.jpg"));
      lblNewLabel_1_2.setBounds(51, 37, 115, 88);
      panel.add(lblNewLabel_1_2);
      
      lblNewLabel_1_2_1 = new JLabel("");
      lblNewLabel_1_2_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_01.jpg"));
      lblNewLabel_1_2_1.setBounds(199, 37, 115, 88);
      panel.add(lblNewLabel_1_2_1);
      
      JButton btnNewButton_1 = new JButton("보석바");
      btnNewButton_1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "보석바"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, JEWEL_BAR_PRICE);
          }
      });
      btnNewButton_1.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_1.setBounds(199, 125, 115, 37);
      panel.add(btnNewButton_1);
      
      lblNewLabel_1_2_1_1 = new JLabel("");
      lblNewLabel_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_02.jpg"));
      lblNewLabel_1_2_1_1.setBounds(347, 37, 115, 88);
      panel.add(lblNewLabel_1_2_1_1);
      
      JButton btnNewButton_1_1 = new JButton("빵빠레");
      btnNewButton_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // 주문된 제품과 수량 가져오기
             String productName = "빵빠레"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
             int quantity = 1; // 예시로 수량 1로 설정

             // 주문 테이블에 추가
             addOrderToTable(productName, quantity, BUNPARAE_PRICE);
         }
     });
        
      btnNewButton_1_1.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_1_1.setBounds(347, 125, 115, 37);
      panel.add(btnNewButton_1_1);
      
      lblNewLabel_1_2_2 = new JLabel("");
      lblNewLabel_1_2_2.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_04.jpg"));
      lblNewLabel_1_2_2.setBounds(51, 182, 120, 88);
      panel.add(lblNewLabel_1_2_2);
      
      JButton btnNewButton_2 = new JButton("와");
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
                 // 주문된 제품과 수량 가져오기
                 String productName = "와"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                 int quantity = 1; // 예시로 수량 1로 설정

                 // 주문 테이블에 추가
                 addOrderToTable(productName, quantity, WA_PRICE);
   
      	}
      });
      btnNewButton_2.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_2.setBounds(51, 270, 115, 37);
      panel.add(btnNewButton_2);
      
      JLabel lblNewLabel_1_2_3 = new JLabel("");
      lblNewLabel_1_2_3.setBounds(199, 182, 115, 88);
      panel.add(lblNewLabel_1_2_3);
      
      JButton btnNewButton_3 = new JButton("와일드바디");
      btnNewButton_3.addActionListener(new ActionListener() {
      	 public void actionPerformed(ActionEvent e) {
            // 주문된 제품과 수량 가져오기
            String productName = "와일드바디"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
            int quantity = 1; // 예시로 수량 1로 설정

            // 주문 테이블에 추가
            addOrderToTable(productName, quantity, WILD_BODY_PRICE);

 	      }
      });
      btnNewButton_3.setFont(new Font("D2Coding", Font.BOLD, 16));
      btnNewButton_3.setBounds(199, 270, 115, 37);
      panel.add(btnNewButton_3);
      
      JButton btnNewButton_4 = new JButton("탱크보이");
      btnNewButton_4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "탱크보이"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, TANK_BOY_PRICE);
          }
      });
      btnNewButton_4.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_4.setBounds(347, 270, 115, 37);
      panel.add(btnNewButton_4);
      
      lblNewLabel_1_2_4 = new JLabel("");
      lblNewLabel_1_2_4.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_07.jpg"));
      lblNewLabel_1_2_4.setBounds(51, 331, 115, 88);
      panel.add(lblNewLabel_1_2_4);
      
      JButton btnNewButton_5 = new JButton("쿠앤크");
      btnNewButton_5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "쿠앤크"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, COOAND_CRE_PRICE);
          }
      });
      btnNewButton_5.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_5.setBounds(51, 419, 115, 37);
      panel.add(btnNewButton_5);
      
      JButton btnNewButton_6 = new JButton("쌍쌍바");
      btnNewButton_6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "쌍쌍바"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, SSANGSSANG_BAR_PRICE);
          }
      });
      btnNewButton_6.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_6.setBounds(199, 419, 115, 37);
      panel.add(btnNewButton_6);
      
      JButton btnNewButton_7 = new JButton("와삭바");
      btnNewButton_7.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "와삭바"; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
              int quantity = 1; // 예시로 수량 1로 설정

              // 주문 테이블에 추가
              addOrderToTable(productName, quantity, WASACK_BAR_PRICE);
          }
      });
      btnNewButton_7.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_7.setBounds(347, 419, 115, 37);
      panel.add(btnNewButton_7);
      
      //주문버튼
      btnNewButton_5_1 = new JButton("주문");
      btnNewButton_5_1.addActionListener(new ActionListener() {
         @Override
          public void actionPerformed(ActionEvent e) {
              // 주문된 제품과 수량 가져오기
              String productName = "돼지바"; // 예시로 돼지바로 설정
              int quantity = 1; // 예시로 수량 1로 설정
              
              // 여기에 주문 처리 로직을 추가할 수 있습니다.
           // 주문 처리
              processOrder(productName, quantity, PIG_BAR_PRICE);
              
              // 예시로 콘솔에 주문 정보를 출력하는 대신에, 위에서 작성한 코드와 통합하여 처리할 수 있습니다.
              System.out.println("주문된 제품: " + productName + ", 수량: " + quantity);
              // 추가적인 처리 로직을 여기에 작성하세요.
              JOptionPane.showMessageDialog(contentPane, "주문이 완료되었습니다. \n 감사합니다", "알림", JOptionPane.PLAIN_MESSAGE);
          }

		private void processOrder(String productName, int quantity, int pIG_BAR_PRICE) {
			// TODO Auto-generated method stub
			
		}
         
         
      });
      btnNewButton_5_1.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_5_1.setBounds(125, 504, 115, 37);
      panel.add(btnNewButton_5_1);
      
      // 취소 버튼
      btnNewButton_5_1_1 = new JButton("주문취소");
      btnNewButton_5_1_1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cancelOrder();
             }
             private void cancelOrder() {
                 // 테이블 초기화
                 DefaultTableModel model = (DefaultTableModel) table.getModel();
                 model.setRowCount(0);

                 // 선택된 메뉴의 수량 초기화
                 pigBarStock = 10;
                 jewelBarStock = 10;

                 // 합계금액 업데이트
                 updateTotalAmount();
             
            }
         });
      btnNewButton_5_1_1.setFont(new Font("D2Coding", Font.BOLD, 17));
      btnNewButton_5_1_1.setBounds(273, 504, 115, 37);
      panel.add(btnNewButton_5_1_1);
      
      lblNewLabel_1_2_7 = new JLabel("");
      lblNewLabel_1_2_7.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_08.jpg"));
      lblNewLabel_1_2_7.setBounds(347, 182, 115, 88);
      panel.add(lblNewLabel_1_2_7);
      
      lblNewLabel_1_2_5_1 = new JLabel("");
      lblNewLabel_1_2_5_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_03.jpg"));
      lblNewLabel_1_2_5_1.setBounds(199, 331, 115, 88);
      panel.add(lblNewLabel_1_2_5_1);
      
      lblNewLabel_1_2_5_1_1 = new JLabel("");
      lblNewLabel_1_2_5_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\Images\\KakaoTalk_20240502_192201524_05.png"));
      lblNewLabel_1_2_5_1_1.setBounds(347, 331, 115, 88);
      panel.add(lblNewLabel_1_2_5_1_1);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(507, 37, 365, 418);
      contentPane.add(scrollPane);
      
      
      table = new JTable();
      table.setFont(new Font("D2Coding", Font.BOLD, 12));
      table.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "상품명", "단가", "수량", "합계"
         }
      ));
      scrollPane.setViewportView(table);
      
         DefaultTableCellRenderer rdr = new DefaultTableCellRenderer();
         rdr.setHorizontalAlignment(SwingConstants.CENTER);
         table.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(rdr);
         table.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(rdr);
         table.getColumnModel().getColumn(0).setPreferredWidth(150);
         table.getColumnModel().getColumn(1).setPreferredWidth(250);
         table.getColumnModel().getColumn(2).setPreferredWidth(250);
         table.getColumnModel().getColumn(3).setPreferredWidth(250);
      
      
      JLabel lblNewLabel = new JLabel("합계금액");
      lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(547, 485, 108, 50);
      contentPane.add(lblNewLabel);
      
      textField = new JTextField();
      textField.setFont(new Font("D2Coding", Font.BOLD, 24));
      textField.setBounds(663, 485, 139, 52);
      contentPane.add(textField);
      textField.setColumns(10);
   }
      private void updateTotalAmount() {
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          int rowCount = model.getRowCount();
          int totalAmount = 0;
          for (int i = 0; i < rowCount; i++) {
              int totalPrice = (int) model.getValueAt(i, 3);
              totalAmount += totalPrice;
          }
          textField.setText(String.valueOf(totalAmount));
      }
      
   

   private void addOrderToTable(String productName, int quantity, int price) {
       // 주문 테이블에 있는지 확인
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       int rowCount = model.getRowCount();
       boolean isFound = false;
       for (int i = 0; i < rowCount; i++) {
           if (model.getValueAt(i, 0).equals(productName)) {
               // 이미 주문된 제품이면 수량과 가격을 업데이트
               int prevQuantity = (int) model.getValueAt(i, 2);
               quantity += prevQuantity;
               model.setValueAt(quantity, i, 2); // 수량 업데이트
               int totalPrice = price * quantity;
               model.setValueAt(totalPrice, i, 3); // 가격 업데이트
               isFound = true;
               break;
           }
       }

       // 새로운 주문인 경우 테이블에 추가
       if (!isFound) {
           int totalPrice = price * quantity; // 총 가격 계산
           model.addRow(new Object[]{productName, price, quantity, totalPrice});
       }

       // 합계금액 업데이트
       updateTotalAmount( );
   }
   
}