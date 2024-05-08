package com.itwill.posproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    private static final String SQL_INSERT = String.format(
            "insert into %s ( %s, %s, %s) values ( ?, ?, ? )",
            TBL_ORDER, COL_ORDER_DATE, COL_MENU, COL_PRICE);
    
    /**
     * 데이터베이스의 ORDERS 테이블에 행을 삽입.
     * @param order 테이블에 삽입할 날짜, 메뉴, 가격 정보를 가지고 있는 객체.
     * @return 테이블에 삽입된 행의 개수.
     */
    public int create(Order order ) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
            stmt = conn.prepareStatement(SQL_INSERT); // Statement 객체 생성.
            stmt.setString(1, order.getDate());
            stmt.setString(2, order.getMenu());
            stmt.setInt(3, order.getPrice());
            result = stmt.executeUpdate(); // SQL 실행.
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }

    // 제목에 검색 키워드가 포함된 검색 결과:
    private static final String SQL_SELECT_BY_DATE = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_ORDER, COL_ORDER_DATE, COL_ORDER_DATE);

    public static final int SEARCH_BY_DATE = 0;

    // 데이터베이스에서 검색된 결과를 Order 객체로 만들어서 반환.
    public List<Order> search(int type, String keyword) {
        List<Order> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String searchKeyword = "%" + keyword.toLowerCase() + "%"; // like 검색에서 사용할 파라미터
        System.out.println(searchKeyword);

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            switch (type) {
                case SEARCH_BY_DATE: // 제목으로 검색
                    stmt = conn.prepareStatement(SQL_SELECT_BY_DATE);
                    System.out.println(SQL_SELECT_BY_DATE);
                    stmt.setString(1, searchKeyword);
                    break;
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                Order order = makeOrderFromResultSet(rs);
                result.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return result;
    }

    private static final String SQL_SELECT_DATE = String.format(
            "select DISTINCT(%s) from %s ORDER BY %s",
            COL_ORDER_DATE, TBL_ORDER, COL_ORDER_DATE);

	public static final int SEARCH_ALL_DATES = 0;

    // 데이터베이스에서 검색된 결과를 Order 객체로 만들어서 반환.
    public List<String> searchDates() {
        List<String> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_DATE);

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("rs!!");
                String orderDate = makeOrderDateFromResultSet(rs);
                result.add(orderDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return result;
    }

    // 데이터베이스에서 검색된 결과를 Order 객체로 만들어서 반환.
    private String makeOrderDateFromResultSet(ResultSet rs) throws SQLException {
        return rs.getString(COL_ORDER_DATE);
    }

    // 데이터베이스에서 검색된 결과를 Order 객체로 만들어서 반환.
    private Order makeOrderFromResultSet(ResultSet rs) throws SQLException {
        String date = rs.getString(COL_ORDER_DATE);
        String menu = rs.getString(COL_MENU);
        int price = rs.getInt(COL_PRICE);

        Order order = new Order(date, menu, price);

        return order;
    }
}
