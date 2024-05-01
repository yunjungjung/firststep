
package com.itwill.LongLong.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import com.itwill.LongLong.controller.LongLongDao;

//import com.itwill.jdbc.controller.BlogDao;
//import com.itwill.jdbc.model.Blog;
//import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;

import oracle.jdbc.internal.JMSEnqueueOptions;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LongLongDiaryFrame  {
    
    private static final String[] SEARCH_TYPES  = { 
            "제목", "내용", "제목+내용", "작성자" 
    };
    private static final String[] COLUMN_NAMES = {
            "번호", "제목", "작성자", "수정시간"
    };

    private JFrame frame;
    private JPanel searchPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JPanel buttonPanel;
    private JButton btnReadAll;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    
    private LongLongDao dao = LongLongDao.getInstance();

    /**
     * Launch the application.
     */
    public static void showLongLongDiaryFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	LongLongDiaryFrame window = new LongLongDiaryFrame();
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
    public LongLongDiaryFrame() {
        initialize();
        initializeTable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 588, 585);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("블로그 메인");
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox<>();
        final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(SEARCH_TYPES);
        comboBox.setModel(comboBoxModel);
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
      
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnReadAll = new JButton("목록");
        btnReadAll.addActionListener((e)->initializeTable());
        btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnReadAll);
        
        btnCreate = new JButton("글 쓰기");
        btnCreate.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 작성 창 띄우기
            	LongLongCreateFrame.showLongLongDiaryFrame();
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
       
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener((e) -> deleteBlog()); 
 
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
    }
        


//	private void search() {
//    	int type = comboBox.getSelectedIndex(); // 콤보박스에서 서낵된 아이템의 인덱스
//    	String keyword = textSearchKeyword.getText(); // 검색어
//    	if (keyword.equals("")) {
//    		JOptionPane.showMessageDialog(frame, 
//    				"검색어를 입력하세요", 
//    				"경고", JOptionPane.WARNING_MESSAGE);
//    		textSearchKeyword.requestFocus();
//    		// -> 검색어 입력 jtextfield에 포커스를 줌(커서 깜박깜박)
//    		
//    		
//    		return;
//    	}
//    	
//    	// Dao 메서드를 호출해서 검색 결과를 가져옴
//    	List<Blog> blogs = dao.search(type, keyword);
//    	resetTable(blogs); // 
//    
//    }
//
//    private void initializeTable() {
//    	List<Blog> blogs = dao.read();
//    	resetTable(blogs); // 테이블 리셋
//    }
//    
//    private void resetTable(List<Blog> blogs) {
//    	
//         
//         // 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
//         tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
//         for (Blog b : blogs) {
//             // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
//             Object[] row = {
//                     b.getId(),
//                     b.getTitle(),
//                     b.getWriter(),
//                     b.getModifiedTime(),
//             };
//             tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
//         }
//         table.setModel(tableModel); // JTable의 모델을 다시 세팅.
//     }
//   

    private void deleteBlog() {
    	int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덳스
        if (index == -1) { //jtable에서 선택된 행이 없을때
        	JOptionPane.showMessageDialog(frame, 
        			"삭제할 행을 먼저 선택하세요", 
        			"경고", 
        			JOptionPane.WARNING_MESSAGE);
        	return;
        }
    
        int confirm = JOptionPane.showConfirmDialog(
        		frame, 
        		"정말 삭제할까요?", 
        		"삭제 확인", 
        		JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        	// 선택된 행에서 블로그 번호(id)를 읽음.
        	Integer id = (Integer) tableModel.getValueAt(index, 0);
        	// DAO의 delete 메서드 호출.
        	int result = dao.delete(id);
        	if (result == 1) {
        		initializeTable(); // 테이블을 새로고침.
        		JOptionPane.showMessageDialog(frame, "삭제 성공!");
        	} else {
        		JOptionPane.showMessageDialog(frame, "삭제 실패!");
        	}
        }
    }
    private void initializeTable() {
		// TODO Auto-generated method stub
		
	}

//	public void notifyCreateSuccess() {
//        // 테이블에 insert 성공했을 때 BlogCreateFrame이 호출하는 메서드.
//        initializeTable();
//        JOptionPane.showMessageDialog(frame, "새 블로그 등록 성공!");
//    }
//    
}
