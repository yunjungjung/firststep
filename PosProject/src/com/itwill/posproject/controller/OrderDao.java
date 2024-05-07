package com.itwill.posproject.controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.itwill.posproject.model.Order.Entity.*;
import static com.itwill.posproject.jdbc.OracleJdbc.*;
import com.itwill.posproject.model.Order;

import oracle.jdbc.OracleDriver;

public class OrderDao {

	//-----> singleton
    private static OrderDao instance = null;
    
    private OrderDao() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        
        return instance;
    }
    //<----- singleton
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     */
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }

//   public List<Order> order() {
//      // TODO Auto-generated method stub
//      return null;
//   }
//
//   public List<com.itwill.posproject.model.Order> read() {
//      // TODO Auto-generated method stub
//      return null;
//   }
    
    
 // create(Blog blog) 메서드에서 사용할 SQL:
    // insert into blogs (title, content, writer) values (?, ?, ?)
    private static final String SQL_INSERT = String.format(
            "insert into %s ( %s, %s, %s, %s) values ( ?, ?, ?, ?)", 
            TBL_MENUS, COL_NAMES, COL_PRICE, COL_NUMBER, COL_TOTLAPRICE);
    
    /**
     * 데이터베이스의 BLOGS 테이블에 행을 삽입.
     * @param blog 테이블에 삽입할 제목, 내용, 작성자 정보를 가지고 있는 객체.
     * @return 테이블에 삽입된 행의 개수.
     */
    public int create(Order order ) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
            stmt = conn.prepareStatement(SQL_INSERT); // Statement 객체 생성.
            stmt.setString(1, order.getNames()); // Statement의 첫번째 ? 채움.
            stmt.setInt(2, order.getPrice()); // Statement의 두번째 ? 채움.
            stmt.setInt(3, order.getNumber()); // Statement의 세번째 ? 채움.
            stmt.setInt(4, order.getTotalprice()); // Statement의 세번째 ? 채움.
            result = stmt.executeUpdate(); // SQL 실행.
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    
    
    
    
    
    
}
