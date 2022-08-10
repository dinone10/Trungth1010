/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleHistory;

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
public class VehicleHistoryDAO {

    public static final String VEHICLEHISTORY = "SELECT MAX(historyID) AS [historyID] FROM [ParkingApartment].[dbo].[tblHistoryVehicle] WHERE vehicleID = ? ";
    private static final String INSERT_CHECK_IN = "INSERT INTO tblHistoryVehicle(vehicleID,empID, timeCheckIn) VALUES(?,?,?)";
    private static final String INSERT_CHECK_OUT = "UPDATE [ParkingApartment].[dbo].[tblHistoryVehicle] SET timeCheckOut=? WHERE vehicleID = ? AND historyID=?";
    public static final String ALL_VEHICLE_HISTORY = "SELECT historyID, vehicleID, empID, timeCheckIn, timeCheckOut FROM tblHistoryVehicle";
    public static final String SEARCH = "SELECT historyID, vehicleID, empID, timeCheckIn, timeCheckOut FROM tblHistoryVehicle WHERE vehicleID = ? AND historyID=? ";
    private static final String DELETE_HISTORY = "DELETE tblHistoryVehicle WHERE vehicleID=?";

    public boolean insertCheckIn(VehicleHistoryDTO vehicleHistory) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            Date nowDate = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            String strNowDate = formater.format(nowDate);
            ptm = conn.prepareStatement(INSERT_CHECK_IN);
            ptm.setString(1, vehicleHistory.getVehicleID());
            ptm.setString(2, vehicleHistory.getEmpID());
            ptm.setString(3, strNowDate);
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            return check;
        }
    }

    public List<VehicleHistoryDTO> getListAllVehicleHistory() throws SQLException {
        List<VehicleHistoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(ALL_VEHICLE_HISTORY);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vehicleID = rs.getString("vehicleID");
                    String empID = rs.getString("empID");
                    String timeCheckIn = rs.getString("timeCheckIn");
                    String timeCheckOut = rs.getString("timeCheckOut");

                    list.add(new VehicleHistoryDTO(vehicleID, empID, timeCheckIn, timeCheckOut));
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

    public List<VehicleHistoryDTO> getListVehicleHisotryByVehicleID(String vehicleID) throws SQLException {
        List<VehicleHistoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                int count = 0;
                ptm = conn.prepareStatement(VEHICLEHISTORY);
                ptm.setString(1, vehicleID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                ptm = null;
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, vehicleID);
                ptm.setInt(2, count);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    vehicleID = rs.getString("vehicleID");
                    String empID = rs.getString("empID");
                    String timeCheckIn = rs.getString("timeCheckIn");
                    String timeCheckOut = rs.getString("timeCheckOut");
                    list.add(new VehicleHistoryDTO(vehicleID, empID, timeCheckIn, timeCheckOut));
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
        return list;
    }

    public boolean intsertCheckOut(VehicleHistoryDTO vehicleHistory, String vehicleID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                int count = 0;
                Date nowDate = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String strNowDate = formater.format(nowDate);
                ptm = conn.prepareStatement(VEHICLEHISTORY);
                ptm.setString(1, vehicleID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                ptm = null;
                ptm = conn.prepareStatement(INSERT_CHECK_OUT);
                ptm.setString(1, strNowDate);
                ptm.setString(2, vehicleHistory.getVehicleID());
                ptm.setInt(3, count);

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

    public List<VehicleHistoryDTO> getHistoryID() throws SQLException {
        List<VehicleHistoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(VEHICLEHISTORY);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String historyID = rs.getString("historyID");

                    list.add(new VehicleHistoryDTO(historyID));
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

    public boolean deleteVehicleHisotry(String vehicleID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_HISTORY);
                ptm.setString(1, vehicleID);
                int value = ptm.executeUpdate();
                check = value > 0 ? true : false;
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
