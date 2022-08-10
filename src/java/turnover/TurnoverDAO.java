/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnover;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

/**
 *
 * @author Admin
 */
public class TurnoverDAO {
    private static final String VIEW_TURNOVER = "select sum (price) from tblOrderDetail where price > 0";
    private static final String VIEW_TURNOVER_BY_YEAR = "select price from tblOrderDetail where timeStart LIKE ?"; 
    
    
//    public boolean showTurnover(String price) throws SQLException{
//         boolean check = false;
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtil.getConnection();
//            if (conn != null) {
//                ptm = conn.prepareStatement(VIEW_TURNOVER);
//                ptm.setString(1, price);
//                rs = ptm.executeQuery();
//                if (rs.next()) {
//                    check = true;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return check;
//    }
    
        public List<TurnoverDTO> getListAllTurnover() throws SQLException {
        List<TurnoverDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(VIEW_TURNOVER);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String detailID = rs.getString("detailID");
                    Double price = rs.getDouble("price");
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    String orderID = rs.getString("orderID");
                    String slotID = rs.getString("slotID");
                    list.add(new TurnoverDTO(detailID, price, timeStart, timeEnd, orderID, slotID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
        
        public List<TurnoverDTO> getTurnoverByYear(String timeStart) throws SQLException {
        List<TurnoverDTO> listTurnover = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_TURNOVER_BY_YEAR);
                ptm.setString(1, "%" + timeStart + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String detailID = rs.getString("detailID");
                    Double price = rs.getDouble("price");
                    String timeEnd = rs.getString("timeEnd");
                    String orderID = rs.getString("orderID");
                    String slotID = rs.getString("slotID");
                    listTurnover.add(new TurnoverDTO(detailID, price, timeStart, timeEnd, orderID, slotID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listTurnover;
    }
}
