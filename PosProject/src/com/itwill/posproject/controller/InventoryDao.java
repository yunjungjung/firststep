package com.itwill.posproject.controller;

import com.itwill.posproject.model.Inventory;
import oracle.jdbc.OracleDriver;

import java.sql.*;

import static com.itwill.posproject.jdbc.OracleJdbc.*;
import static com.itwill.posproject.model.Inventory.Entity.*;

public class InventoryDao {
    private static InventoryDao instance = null;

    private InventoryDao() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static InventoryDao getInstance() {
        if (instance == null) {
            instance = new InventoryDao();
        }

        return instance;
    }

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

    // read() 메서드에서 사용할 SQL 문장: select * from inventories order by id desc
    private static final String SQL_SELECT_ALL = String.format(
            "select * from %s",
            TBL_INVENTORY
    );

    /**
     * 데이터베이스 테이블 INVENTORIES 테이블에서 모든 레코드(행)를 검색해서
     * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return Inventory
     */
    public Inventory read() {
        Inventory result = new Inventory();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 데이터베이스에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            // SQL 문장을 데이터베이스로 전송해서 실행.
            rs = stmt.executeQuery();
            // 결과 처리.
            while (rs.next()) {
                result = makeInventoryFromResultSet(rs);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return result;
    }

    private Inventory makeInventoryFromResultSet(ResultSet rs) throws SQLException {
        int pigBarStock = rs.getInt(COL_PIG_BAR_STOCK);
        int jewelBarStock = rs.getInt(COL_JEWEL_BAR_STOCK);
        int bunparaeStock = rs.getInt(COL_BUNPARAE_STOCK);
        int waStock = rs.getInt(COL_WA_STOCK);
        int wildBodyStock = rs.getInt(COL_WILD_BODY_STOCK);
        int tankBoyStock = rs.getInt(COL_TANK_BOY_STOCK);
        int cooandCreStock = rs.getInt(COL_COOAND_CRE_STOCK);
        int ssangssangBarStock = rs.getInt(COL_SSANGSSANG_BAR_STOCK);
        int wasackBarStock = rs.getInt(COL_WASACK_BAR_STOCK);

        Inventory inventory = new Inventory(pigBarStock, jewelBarStock, bunparaeStock, waStock, wildBodyStock, tankBoyStock, cooandCreStock, ssangssangBarStock, wasackBarStock);

        return inventory;
    }

    private static final String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ?,  %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?",
            TBL_INVENTORY, COL_PIG_BAR_STOCK, COL_JEWEL_BAR_STOCK, COL_BUNPARAE_STOCK, COL_WA_STOCK, COL_WILD_BODY_STOCK, COL_TANK_BOY_STOCK, COL_COOAND_CRE_STOCK, COL_SSANGSSANG_BAR_STOCK, COL_WASACK_BAR_STOCK);

    /**
     * INVENTORIES 테이블 업데이트.
     * @param inventory 업데이트할 데이터를 가지고 있는 객체.
     * @return 업데이트한 행의 개수.
     */
    public int update(Inventory inventory) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, inventory.getPigBarStock());
            stmt.setInt(2, inventory.getJewelBarStock());
            stmt.setInt(3, inventory.getBunparaeStock());
            stmt.setInt(4, inventory.getWaStock());
            stmt.setInt(5, inventory.getWildBodyStock());
            stmt.setInt(6, inventory.getTankBoyStock());
            stmt.setInt(7, inventory.getCooandCreStock());
            stmt.setInt(8, inventory.getSsangssangBarStock());
            stmt.setInt(9, inventory.getWasackBarStock());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }

        return result;
    }

}
