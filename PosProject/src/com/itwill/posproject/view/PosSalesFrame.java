package com.itwill.posproject.view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PosSalesFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnSearch;

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

    public PosSalesFrame() {
        setTitle("매출 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 627, 535);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(109, 10, 370, 51);
        contentPane.add(searchPanel);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(comboBox);

        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textField.setColumns(10);
        searchPanel.add(textField);

        btnSearch = new JButton("조회");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(btnSearch);
    }

    // 매출 조회 기능 추가
    private void searchSalesByDate(String date) {
        // 선택한 날짜를 이용하여 DB에서 해당 날짜의 매출 정보를 조회하고,
        // 조회된 정보를 테이블에 표시하는 기능을 구현하세요.
    }
}
