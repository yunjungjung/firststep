package com.itwill.posproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PosInventoryFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnUpdate;

    /**
     * Launch the application.
     */
    public static void showPosInventoryFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PosInventoryFrame frame = new PosInventoryFrame();
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
    public PosInventoryFrame() {
        setTitle("재고 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 36, 414, 168);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"돼지바", 10},
                {"보석바", 10},
                // 여기에 나머지 상품과 재고를 추가하세요
            },
            new String[] {
                "상품명", "재고"
            }
        ));
        scrollPane.setViewportView(table);
        
        btnUpdate = new JButton("재고 수정");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateInventory();
            }
        });
        btnUpdate.setFont(new Font("Dialog", Font.BOLD, 14));
        btnUpdate.setBounds(152, 228, 127, 23);
        contentPane.add(btnUpdate);
    }

    // 재고 수정 메서드
    private void updateInventory() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // 여기서 테이블의 데이터를 가져와서 재고를 업데이트하도록 구현하세요
        // 예를 들어, model.getValueAt(row, column)을 사용하여 해당 상품의 재고를 가져올 수 있습니다.
        // 그리고 재고를 수정할 필요가 있으면 그에 맞게 구현하세요.
        // 마지막으로 변경된 재고를 다시 테이블에 반영해야 합니다.
        
        // 예시: 돼지바의 재고를 5로 수정하는 경우
        // model.setValueAt(5, rowIndex, columnIndex);
        
        JOptionPane.showMessageDialog(contentPane, "재고가 수정되었습니다.", "알림", JOptionPane.PLAIN_MESSAGE);
    }
    
    // 주문이 완료되었을 때 재고를 업데이트하는 메서드
    public void updateInventoryAfterOrder(String productName, int quantity) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            if (model.getValueAt(i, 0).equals(productName)) {
                int currentQuantity = (int) model.getValueAt(i, 1);
                model.setValueAt(currentQuantity - quantity, i, 1); // 재고 업데이트
                break;
            }
        }
    }
}
