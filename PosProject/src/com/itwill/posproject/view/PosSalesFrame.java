package com.itwill.posproject.view;

import com.itwill.posproject.controller.OrderDao;
import com.itwill.posproject.model.Order;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer; // 추가
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PosSalesFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private OrderDao dao = OrderDao.getInstance();

    private static List<String> dateList = new ArrayList<>();

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnSearch;
    private JTable table;
    /**
     * @wbp.nonvisual location=170,619
     */
    private final JLabel label = new JLabel("New label");
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void showPosSalesFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PosSalesFrame frame = new PosSalesFrame();
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
    public PosSalesFrame() {
        // dateList에 날짜 목록을 가져온다
        setDateList();

        setTitle("매출관리");
        // 아이콘 설정
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/posproject/images/아이스크림.png"));
        setIconImage(img);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 811, 615);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(128, 10, 532, 51);
        contentPane.add(searchPanel);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        int size = dateList.size();
        for (int i = 0; i < size; i++) {
            comboBox.addItem(dateList.get(i));
        }

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDate = (String) comboBox.getSelectedItem();
                updateTable(selectedDate);
            }
        });

        searchPanel.add(comboBox);
        
        btnNewButton = new JButton("전체 검색");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTableForAllDates();
            }
            
            private void updateTableForAllDates() {
                List<Order> orders = dao.search(OrderDao.SEARCH_ALL_DATES, ""); // 빈 문자열로 검색
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                // 테이블의 모든 행을 삭제
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }

                // orders 리스트에 있는 각 Order 객체의 데이터를 테이블에 추가
                int size = orders.size();
                for (int i = 0; i < size; i++) {
                    Order order = orders.get(i);
                    Object[] row = new Object[] { i+1, order.getDate(), order.getMenu(), order.getPrice() };
                    model.addRow(row);
                }
                updateTotalAmount();
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 24));
        searchPanel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 71, 738, 380);
        contentPane.add(scrollPane);
        table = new JTable();

        table.setFont(new Font("D2Coding", Font.BOLD, 12));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "번호", "날짜", "메뉴", "가격"
                }
        ));
        scrollPane.setViewportView(table);

        // 가운데 정렬을 위한 셀 렌더러 추가
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // 테이블 행의 높이 설정
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(400);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        JLabel lblNewLabel = new JLabel("합계금액");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(241, 477, 114, 50);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.BOLD, 24));
        textField.setBounds(367, 477, 139, 52);
        contentPane.add(textField);
        textField.setColumns(10);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("/com/itwill/posproject/images/배경화면.jpg")));
        lblNewLabel_1.setBounds(0, 0, 795, 576);
        contentPane.add(lblNewLabel_1);

        // 초기에는 첫 번째 날짜에 대한 주문 목록을 테이블에 표시
        if (size > 0) {
            updateTable(dateList.get(0));
        }
    }

    private void setDateList() {
        dateList = dao.searchDates();
    }

    private void updateTable(String selectedDate) {
        List<Order> orders = dao.search(OrderDao.SEARCH_BY_DATE, selectedDate);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // 테이블의 모든 행을 삭제
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // orders 리스트에 있는 각 Order 객체의 데이터를 테이블에 추가
        int size = orders.size();
        for (int i = 0; i < size; i++) {
            Order order = orders.get(i);
            Object[] row = new Object[] { i+1, order.getDate(), order.getMenu(), order.getPrice() };
            model.addRow(row);
        }
        updateTotalAmount();
    }

    // 테이블의 모든 행의 가격을 합산하여 textField에 표시
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
}
