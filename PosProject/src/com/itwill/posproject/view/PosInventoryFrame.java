package com.itwill.posproject.view;

import com.itwill.posproject.controller.InventoryDao;
import com.itwill.posproject.model.Inventory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PosInventoryFrame extends JFrame {
    private InventoryDao inventoryDao = InventoryDao.getInstance();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnUpdate;
    

    
    private final String PIG_BAR_NAME = "돼지바";
    private final String JEWEL_BAR_NAME = "보석바";
    private final String BUNPARAE_NAME = "빵빠레";
    private final String WA_NAME = "와";
    private final String WILD_BODY_NAME = "와일드바디";
    private final String TANK_BOY_NAME = "탱크보이";
    private final String COOAND_CRE_NAME = "쿠앤크";
    private final String SSANGSSANG_BAR_NAME = "쌍쌍바";
    private final String WASACK_BAR_NAME = "와삭바";
    private JLabel lblNewLabel;
    private JLabel lblback;

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
     // 아이콘 설정
     Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/posproject/images/아이스크림.png"));
     setIconImage(img);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 564, 618);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 41, 490, 336);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setRowHeight(35); // 테이블 행 높이 설정
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20)); // 컬럼 헤더 폰트 설정

        Inventory inventory = inventoryDao.read();
        System.out.println(inventory);
        table.setModel(new DefaultTableModel(
                // 재고 데이터
                new Object[][]{
                        {PIG_BAR_NAME, inventory.getPigBarStock()},
                        {JEWEL_BAR_NAME, inventory.getJewelBarStock()},
                        {BUNPARAE_NAME, inventory.getBunparaeStock()},
                        {WA_NAME, inventory.getWaStock()},
                        {WILD_BODY_NAME, inventory.getWildBodyStock()},
                        {TANK_BOY_NAME, inventory.getTankBoyStock()},
                        {COOAND_CRE_NAME, inventory.getCooandCreStock()},
                        {SSANGSSANG_BAR_NAME, inventory.getSsangssangBarStock()},
                        {WASACK_BAR_NAME, inventory.getWasackBarStock()}
                },
                new String[]{
                        "상품명", "재고"
                }
        ) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
////                return false; // 셀 편집 금지
//            }
        });
        table.setFont(new Font("SansSerif", Font.PLAIN, 18)); // 테이블 내 텍스트 폰트 설정
        table.setShowGrid(false); // 그리드 라인 숨기기
        scrollPane.setViewportView(table);

        btnUpdate = new JButton("");
        btnUpdate.setIcon(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/메인버튼01 (1).png")));
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false); // 배경을 투명하게 설정
        btnUpdate.setForeground(new Color(0, 51, 255));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(contentPane, "재고를 수정하시겠습니까?", "재고 수정", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                if (result == JOptionPane.YES_OPTION) {
                    updateInventory();
                }
            }
        });

        btnUpdate.setFont(new Font("굴림", Font.BOLD, 20));
        btnUpdate.setBounds(238, 421, 96, 97);
        contentPane.add(btnUpdate);
        
        lblNewLabel = new JLabel("재고 수정");
        lblNewLabel.setForeground(new Color(0, 51, 255));
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 19));
        lblNewLabel.setBounds(238, 517, 96, 35);
        contentPane.add(lblNewLabel);
        
        lblback = new JLabel("");
        lblback = new JLabel(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/배경화면.jpg")));
        lblback.setBounds(0, 0, 553, 579);
        contentPane.add(lblback);
    }

    // 재고 수정 메서드
    private void updateInventory() {
        // 테이블 수정 내용 반영.
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // 여기서 테이블의 데이터를 가져와서 재고를 업데이트하도록 구현하세요
        // 예를 들어, model.getValueAt(row, column)을 사용하여 해당 상품의 재고를 가져올 수 있습니다.
        // 그리고 재고를 수정할 필요가 있으면 그에 맞게 구현하세요.
        // 마지막으로 변경된 재고를 다시 테이블에 반영해야 합니다.
        Inventory inventory = new Inventory();

        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String productName = (String) model.getValueAt(i, 0);
            int stock = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));

            switch (productName) {
                case PIG_BAR_NAME:
                    inventory.setPigBarStock(stock);
                    break;
                case JEWEL_BAR_NAME:
                    inventory.setJewelBarStock(stock);
                    break;
                case BUNPARAE_NAME:
                    inventory.setBunparaeStock(stock);
                    break;
                case WA_NAME:
                    inventory.setWaStock(stock);
                    break;
                case WILD_BODY_NAME:
                    inventory.setWildBodyStock(stock);
                    break;
                case TANK_BOY_NAME:
                    inventory.setTankBoyStock(stock);
                    break;
                case COOAND_CRE_NAME:
                    inventory.setCooandCreStock(stock);
                    break;
                case SSANGSSANG_BAR_NAME:
                    inventory.setSsangssangBarStock(stock);
                    break;
                case WASACK_BAR_NAME:
                    inventory.setWasackBarStock(stock);
                    break;
            }
        }

        // 데이터베이스에 변경 사항 저장
        inventoryDao.update(inventory);

        // 재고 수정 완료 메시지 출력
        JOptionPane.showMessageDialog(contentPane, "재고가 수정되었습니다.", "알림", JOptionPane.PLAIN_MESSAGE);
    }
}
