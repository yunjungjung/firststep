package com.itwill.posproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.itwill.posproject.model.Menu;
import oracle.jdbc.OracleDriver;

public class MenuDao {
    private static final String URL = "jdbc:mysql://localhost:3306/pos_database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    
    private static final String SQL_INSERT = "INSERT INTO Menu (name, price, description) VALUES (?, ?, ?)";
    
    public int create(Menu menu) {
        int result = 0;
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, menu.getName());
            stmt.setInt(2, menu.getPrice());
            stmt.setString(3, menu.getDescription());
            result = stmt.executeUpdate(); // SQL 실행
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}