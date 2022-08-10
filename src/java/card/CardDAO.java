/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBUtil;

/**
 *
 * @author Admin
 */
public class CardDAO {

    private static final String CREATE_CARD = "INSERT INTO [ParkingApartment].[dbo].[tblLongTermCard] (longCardID, vehicleID,cusID, importDate, expirationDate, licensePlates, status) VALUES(?,?,?,?,?,?,'0')";
    private static final String GET_ID = "SELECT MAX(longCardID) AS [longCardID] FROM [ParkingApartment].[dbo].[tblLongTermCard]";
    public static final String DISPLAY_LIST_CARD = "SELECT longCardID, vehicleID,cusID, importDate, expirationDate, licensePlates, status FROM [ParkingApartment].[dbo].[tblLongTermCard]";
    public static final String DISPLAY_LIST_CARD_BY_ID = "SELECT longCardID, vehicleID,cusID, importDate, expirationDate, licensePlates, status FROM [ParkingApartment].[dbo].[tblLongTermCard] WHERE cusID=? ";
    private static final String TRUE_STATUS = "UPDATE [ParkingApartment].[dbo].[tblLongTermCard] SET status=1  WHERE longCardID= ?";
    private static final String EXTEND_CARD = "UPDATE [ParkingApartment].[dbo].[tblLongTermCard] SET expirationDate=?  WHERE longCardID= ?";
    private static final String FALSE_STATUS = "UPDATE [ParkingApartment].[dbo].[tblLongTermCard] SET status=0  WHERE longCardID= ?";

    public boolean createCard(CardDTO card) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                int count = 0;
                ptm = conn.prepareStatement(GET_ID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                count++;
                ptm = null;
                ptm = conn.prepareStatement(CREATE_CARD);
                ptm.setInt(1, count);
                ptm.setString(2, card.getVehicleID());
                ptm.setString(3, card.getCusID());
                ptm.setString(4, card.getImportDate());
                ptm.setString(5, card.getExpirationDate());
                ptm.setString(6, card.getLicensePlates());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public List<CardDTO> getCardByID(String cusID) throws SQLException {
        List<CardDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_CARD_BY_ID);
                stm.setString(1, cusID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int longCardID = rs.getInt("longCardID");
                    String vehicleID = rs.getString("vehicleID");
                    cusID = rs.getString("cusID");
                    String importDate = rs.getString("importDate");
                    String expirationDate = rs.getString("expirationDate");
                    String licensePlates = rs.getString("licensePlates");
                    String status = rs.getString("status");

                    list.add(new CardDTO(longCardID, vehicleID, cusID, importDate, expirationDate, licensePlates, status));
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

    public List<CardDTO> getListAllCard() throws SQLException {
        List<CardDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_CARD);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int longCardID = rs.getInt("longCardID");
                    String vehicleID = rs.getString("vehicleID");
                    String cusID = rs.getString("cusID");
                    String importDate = rs.getString("importDate");
                    String expirationDate = rs.getString("expirationDate");
                    String licensePlates = rs.getString("licensePlates");
                    String status = rs.getString("status");
                    list.add(new CardDTO(longCardID, vehicleID, cusID, importDate, expirationDate, licensePlates, status));
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

    public boolean SetStatusTrue(int longCardID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TRUE_STATUS);
                ptm.setInt(1, longCardID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public boolean SetStatusFalse(int longCardID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FALSE_STATUS);
                ptm.setInt(1, longCardID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public boolean extendCard(CardDTO card) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(EXTEND_CARD);
                ptm.setString(1, card.getExpirationDate());
                ptm.setInt(2, card.getLongCardID());

                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
