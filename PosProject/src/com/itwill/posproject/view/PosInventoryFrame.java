package com.itwill.posproject.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.itwill.posproject.controller.InventoryDao;
import com.itwill.posproject.model.Inventory;

public class PosInventoryFrame extends JFrame {
    private Container container = getContentPane();
    private Panel pal = new Panel();
    private InventoryDao dao = new InventoryDao();
    private Inventory inventory = new Inventory();
    private JTable table;
    private Object columnNames[] = {"상품명", "재고"};
    private JTextField textField;
    private JLabel lblNewLabel;

 // 생성자
    public PosInventoryFrame() {
        dao = new InventoryDao(); // dao 객체 초기화
        inventory = dao.getInventory();
        if (inventory == null) {
            // inventory가 null인 경우 처리
            // 예를 들어, 오류 메시지 표시 또는 기본값으로 초기화
            JOptionPane.showMessageDialog(null, "재고가 null입니다. 데이터베이스 연결을 확인하세요.");
            return;
        }
        setSize(550, 700);
        setVisible(true);
        setLocation(900, 100);
        getContentPane().setLayout(null);

        // 재고 테이블 생성
        table = new JTable();
        table.setFont(new Font("D2Coding", Font.PLAIN, 14));
        updateTable(); // 테이블 업데이트 메서드 호출
        // 스크롤 패널에 테이블 추가
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 50, 400, 200);
        scrollPane.setViewportView(table);
        getContentPane().add(scrollPane);

        // 주문 처리를 위한 텍스트 필드와 버튼 추가
        textField = new JTextField();
        textField.setBounds(50, 300, 200, 30);
        getContentPane().add(textField);

        JButton btnOrder = new JButton("주문");
        btnOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = textField.getText();
                if (productName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "상품명을 입력하세요.");
                    return;
                }
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("주문 수량을 입력하세요:"));
                processOrderAndUpdateStock(productName, quantity);
            }
        });
        btnOrder.setBounds(270, 300, 100, 30);
        getContentPane().add(btnOrder);

        // 상태 메시지를 나타내는 라벨 추가
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(50, 350, 400, 30);
        getContentPane().add(lblNewLabel);
    }

    // 주문을 처리하고 재고를 업데이트하는 메서드
    private void processOrderAndUpdateStock(String stockName, int quantity) {
        try {
            // 재고 확인
            int currentStock = 0;
            switch(stockName) {
                case "돼지바":
                    currentStock = inventory.getPigBar();
                    break;
                case "보석바":
                    currentStock = inventory.getJewelBar();
                    break;
                // 나머지 재고도 동일하게 추가
            }

            if (currentStock + quantity < 0) {
                JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
                return;
            }

            // 재고 업데이트
            switch (stockName) {
                case "돼지바":
                    inventory.setPigBar(currentStock + quantity);
                    break;
                case "보석바":
                    inventory.setJewelBar(currentStock + quantity);
                    break;
                // 나머지 재고도 동일하게 추가
            }

            // DAO를 사용하여 재고 업데이트
            dao.updateInventory(inventory);
            lblNewLabel.setText("주문이 성공적으로 처리되었습니다.");
            updateTable(); // 테이블 업데이트 메서드 호출
        } catch (Exception e) {
            lblNewLabel.setText("주문 처리 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 테이블 업데이트 메서드
    private void updateTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        model.addRow(new Object[]{"돼지바", inventory.getPigBar()});
        model.addRow(new Object[]{"보석바", inventory.getJewelBar()});
        // 나머지 재고도 동일하게 추가
        table.setModel(model);
    }

    public static void showPosInventoryFrame() {
        PosInventoryFrame inventoryFrame = new PosInventoryFrame();
        inventoryFrame.setVisible(true);
    }
}
