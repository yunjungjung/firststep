package com.itwill.posproject.view;

import com.itwill.posproject.controller.InventoryDao;
import com.itwill.posproject.controller.OrderDao;
import com.itwill.posproject.model.Inventory;
import com.itwill.posproject.model.Order;

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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PosOrderFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private OrderDao orderDao = OrderDao.getInstance();
    private InventoryDao inventoryDao = InventoryDao.getInstance();

    private JPanel contentPane;
    private JLabel lblItem01;
    private JButton btnNewButton;
    private JLabel lblItem08;
    private JLabel lblItem09;
    private JLabel lblItem07;
    private JLabel lblItem04;
    private JLabel lblItem05;
    private JLabel lblItem06;
    private JLabel lblItem02;
    private JLabel lblItem03;
    private JButton btnOrder;
    private JButton btnReset;
    private JTable table;

    // 상품명
    private final String PIG_BAR_NAME = "돼지바";
    private final String JEWEL_BAR_NAME = "보석바";
    private final String BUNPARAE_NAME = "빵빠레";
    private final String WA_NAME = "와";
    private final String WILD_BODY_NAME = "와일드바디";
    private final String TANK_BOY_NAME = "탱크보이";
    private final String COOAND_CRE_NAME = "쿠앤크";
    private final String SSANGSSANG_BAR_NAME = "쌍쌍바";
    private final String WASACK_BAR_NAME = "와삭바";

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
    protected Inventory inventory;

    // 상품 주문 수량
    protected int pigBarSelected;
    protected int jewelBarSelected;
    protected int bunparaeSelected;
    protected int waSelected;
    protected int wildBodySelected;
    protected int tankBoySelected;
    protected int cooandCreSelected;
    protected int ssangssangBarSelected;
    protected int wasakBarSelected;
    private JLabel lblNewLabel_2;

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
        
        // 아이콘 설정
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/posproject/images/아이스크림.png"));
        setIconImage(img);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 501, 576);
        contentPane.add(panel);
        panel.setLayout(null);

        btnNewButton = new JButton(PIG_BAR_NAME);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = PIG_BAR_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                pigBarSelected++;

                // 재고 확인 후 주문 테이블에 추가. 재고가 없으면 주문 수량을 줄이고 알림창 띄우기
                if (inventory.getPigBarStock() >= pigBarSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, PIG_BAR_PRICE);
                } else {
                    pigBarSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        
        JButton btnCancel = new JButton("선택취소");
        btnCancel.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                cancelOrder();
            }

            private void cancelOrder() {
                // 테이블에서 선택된 행 삭제
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // 선택된 행이 있을 경우에만 삭제
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                }

                // 선택된 수량 제거
                pigBarSelected = 0;
                jewelBarSelected = 0;
                bunparaeSelected = 0;
                waSelected = 0;
                wildBodySelected = 0;
                tankBoySelected = 0;
                cooandCreSelected = 0;
                ssangssangBarSelected = 0;
                wasakBarSelected = 0;

                // 합계금액 업데이트
                updateTotalAmount();
            }
        });
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnCancel.setBounds(273, 504, 115, 37);
        panel.add(btnCancel);
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnCancel.setBounds(336, 504, 115, 37);
        panel.add(btnCancel);

        btnNewButton.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton.setBounds(51, 125, 115, 37);
        panel.add(btnNewButton);

        lblItem05 = new JLabel("");
        lblItem05.setIcon(new ImageIcon(getClass().getResource("../images/item05.jpeg")));
        lblItem05.setBounds(199, 182, 115, 88);
        panel.add(lblItem05);

        lblItem01 = new JLabel("");
        lblItem01.setIcon(new ImageIcon(getClass().getResource("../images/item01.jpeg")));
        lblItem01.setBounds(51, 37, 115, 88);
        panel.add(lblItem01);

        lblItem02 = new JLabel("");
        lblItem02.setIcon(new ImageIcon(getClass().getResource("../images/item02.jpeg")));
        lblItem02.setBounds(199, 37, 115, 88);
        panel.add(lblItem02);

        JButton btnNewButton_1 = new JButton(JEWEL_BAR_NAME);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = JEWEL_BAR_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                jewelBarSelected++;
                if (inventory.getJewelBarStock() >= jewelBarSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, JEWEL_BAR_PRICE);
                } else {
                    jewelBarSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        btnNewButton_1.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_1.setBounds(199, 125, 115, 37);
        panel.add(btnNewButton_1);

        lblItem03 = new JLabel("");
        lblItem03.setIcon(new ImageIcon(getClass().getResource("../images/item03.jpeg")));
        lblItem03.setBounds(347, 37, 115, 88);
        panel.add(lblItem03);

        JButton btnNewButton_1_1 = new JButton(BUNPARAE_NAME);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = BUNPARAE_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                bunparaeSelected++;
                if (inventory.getBunparaeStock() >= bunparaeSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, BUNPARAE_PRICE);
                } else {
                    bunparaeSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        btnNewButton_1_1.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_1_1.setBounds(347, 125, 115, 37);
        panel.add(btnNewButton_1_1);

        lblItem04 = new JLabel("");
        lblItem04.setIcon(new ImageIcon(getClass().getResource("../images/item01.jpeg")));
        lblItem04.setBounds(51, 182, 120, 88);
        panel.add(lblItem04);

        JButton btnNewButton_2 = new JButton(WA_NAME);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = WA_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                waSelected++;
                if (inventory.getWaStock() >= waSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, WA_PRICE);
                } else {
                    waSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btnNewButton_2.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_2.setBounds(51, 270, 115, 37);
        panel.add(btnNewButton_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("");
        lblNewLabel_1_2_3.setBounds(199, 182, 115, 88);
        panel.add(lblNewLabel_1_2_3);

        JButton btnNewButton_3 = new JButton(WILD_BODY_NAME);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = WILD_BODY_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                wildBodySelected++;
                if (inventory.getWildBodyStock() >= wildBodySelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, WILD_BODY_PRICE);
                } else {
                    wildBodySelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btnNewButton_3.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnNewButton_3.setBounds(199, 270, 115, 37);
        panel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton(TANK_BOY_NAME);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = TANK_BOY_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                tankBoySelected++;

                // 주문 테이블에 추가
                addOrderToTable(productName, quantity, TANK_BOY_PRICE);
            }
        });
        btnNewButton_4.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_4.setBounds(347, 270, 115, 37);
        panel.add(btnNewButton_4);

        lblItem07 = new JLabel("");
        lblItem07.setIcon(new ImageIcon(getClass().getResource("../images/item07.jpeg")));
        lblItem07.setBounds(51, 331, 115, 88);
        panel.add(lblItem07);

        JButton btnNewButton_5 = new JButton(COOAND_CRE_NAME);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = COOAND_CRE_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                cooandCreSelected++;

                // 주문 테이블에 추가
                addOrderToTable(productName, quantity, COOAND_CRE_PRICE);
            }
        });
        btnNewButton_5.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_5.setBounds(51, 419, 115, 37);
        panel.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton(SSANGSSANG_BAR_NAME);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = SSANGSSANG_BAR_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                ssangssangBarSelected++;
                if (inventory.getSsangssangBarStock() >= ssangssangBarSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, SSANGSSANG_BAR_PRICE);
                } else {
                    ssangssangBarSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btnNewButton_6.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_6.setBounds(199, 419, 115, 37);
        panel.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton(WASACK_BAR_NAME);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문된 제품과 수량 가져오기
                String productName = WASACK_BAR_NAME; // 버튼의 텍스트를 가져오거나 설정할 수도 있습니다.
                int quantity = 1; // 예시로 수량 1로 설정
                wasakBarSelected++;
                if (inventory.getWasackBarStock() >= wasakBarSelected) {
                    // 주문 테이블에 추가
                    addOrderToTable(productName, quantity, WASACK_BAR_PRICE);
                } else {
                    wasakBarSelected--;
                    JOptionPane.showMessageDialog(contentPane, "재고가 부족합니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btnNewButton_7.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnNewButton_7.setBounds(347, 419, 115, 37);
        panel.add(btnNewButton_7);

        // 주문버튼
        btnOrder = new JButton("주문");
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 확인하는 모달. 맞으면 주문처리
                int result = JOptionPane.showConfirmDialog(contentPane, "주문하시겠습니까?", "주문 확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                if (result == JOptionPane.YES_OPTION) {
                    // 주문처리
                    processOrder();

                    // 주문 테이블 초기화
                    clearTableModel();
                    JOptionPane.showMessageDialog(contentPane, "주문이 완료되었습니다. \n 감사합니다", "알림", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        btnOrder.setFont(new Font("D2Coding", Font.BOLD, 17));
        btnOrder.setBounds(60, 504, 115, 37);
        panel.add(btnOrder);

        // 취소 버튼
        btnReset = new JButton("주문초기화");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetOrder();
            }

            private void resetOrder() {
                // 테이블 초기화
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                // 선택된 수량 제거
                pigBarSelected = 0;
                jewelBarSelected = 0;
                bunparaeSelected = 0;
                waSelected = 0;
                wildBodySelected = 0;
                tankBoySelected = 0;
                cooandCreSelected = 0;
                ssangssangBarSelected = 0;
                wasakBarSelected = 0;

                // 합계금액 업데이트
                updateTotalAmount();
            }
        });
        btnReset.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnReset.setBounds(199, 504, 115, 37);
        panel.add(btnReset);

        lblItem06 = new JLabel("");
        lblItem06.setIcon(new ImageIcon(getClass().getResource("../images/item06.jpeg")));
        lblItem06.setBounds(347, 182, 115, 88);
        panel.add(lblItem06);

        lblItem08 = new JLabel("");
        lblItem08.setIcon(new ImageIcon(getClass().getResource("../images/item08.jpeg")));
        lblItem08.setBounds(199, 331, 115, 88);
        panel.add(lblItem08);

        lblItem09 = new JLabel("");
        lblItem09.setIcon(new ImageIcon(getClass().getResource("../images/item09.png")));
        lblItem09.setBounds(347, 331, 115, 88);
        panel.add(lblItem09);
        
        lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/배경화면.jpg")));
        lblNewLabel_2.setBounds(0, 0, 884, 566);
        panel.add(lblNewLabel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(507, 37, 365, 418);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("D2Coding", Font.BOLD, 20));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "상품명", "단가", "수량", "합계"
                }
        ));
        scrollPane.setViewportView(table);

        DefaultTableCellRenderer rdr = new DefaultTableCellRenderer();
        rdr.setHorizontalAlignment(SwingConstants.CENTER);
        
        

        table.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(rdr);
        table.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(rdr);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);


        JLabel lblNewLabel = new JLabel("합계금액");
        lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(547, 485, 108, 50);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.BOLD, 20));
        textField.setBounds(663, 485, 139, 52);
        contentPane.add(textField);
        textField.setColumns(10);

        // 재고 가져오기
        setInventory();
    }

    private void setInventory() {
        inventory = inventoryDao.read();
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
        updateTotalAmount();
    }

    private void processOrder() {
        Order order = makeOrder();
        // 테이블에 order 데이터 추가
        orderDao.create(order);

        // 주문 재고 차감
        inventory.setPigBarStock(inventory.getPigBarStock() - pigBarSelected);
        inventory.setJewelBarStock(inventory.getJewelBarStock() - jewelBarSelected);
        inventory.setBunparaeStock(inventory.getBunparaeStock() - bunparaeSelected);
        inventory.setWaStock(inventory.getWaStock() - waSelected);
        inventory.setWildBodyStock(inventory.getWildBodyStock() - wildBodySelected);
        inventory.setTankBoyStock(inventory.getTankBoyStock() - tankBoySelected);
        inventory.setCooandCreStock(inventory.getCooandCreStock() - cooandCreSelected);
        inventory.setSsangssangBarStock(inventory.getSsangssangBarStock() - ssangssangBarSelected);
        inventory.setWasackBarStock(inventory.getWasackBarStock() - wasakBarSelected);

        inventoryDao.update(inventory);
    }

    // 주문 객체 생성
    private Order makeOrder() {
        String date = "";
        String menu = "";
        int price = 0;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = currentDate.format(formatter);

        if (pigBarSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += PIG_BAR_NAME + ":" + pigBarSelected;
            price += PIG_BAR_PRICE;
        }
        if (jewelBarSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += JEWEL_BAR_NAME + ":" + jewelBarSelected;
            price += JEWEL_BAR_PRICE;
        }
        if (bunparaeSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += BUNPARAE_NAME + ":" + bunparaeSelected;
            price += BUNPARAE_PRICE;
        }
        if (waSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += WA_NAME + ":" + waSelected;
            price += WA_PRICE;
        }
        if (wildBodySelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += WILD_BODY_NAME + ":" + wildBodySelected;
            price += WILD_BODY_PRICE;
        }
        if (tankBoySelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += TANK_BOY_NAME + ":" + tankBoySelected;
            price += TANK_BOY_PRICE;
        }
        if (cooandCreSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += COOAND_CRE_NAME + ":" + cooandCreSelected;
            price += COOAND_CRE_PRICE;
        }
        if (ssangssangBarSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += SSANGSSANG_BAR_NAME + ":" + ssangssangBarSelected;
            price += SSANGSSANG_BAR_PRICE;
        }
        if (wasakBarSelected > 0) {
            if (menu.length() > 0) {
                menu += ",";
            }
            menu += WASACK_BAR_NAME + ":" + wasakBarSelected;
            price += WASACK_BAR_PRICE;
        }

        Order order = new Order(date, menu, price);

        return order;
    }

    private void clearTableModel() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    }

