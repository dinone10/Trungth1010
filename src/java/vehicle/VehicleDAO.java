/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

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
public class VehicleDAO {

    public static final String DISPLAY_LIST_VEHICLE = "SELECT vehicleID,cusID,vehicleType,licensePlates FROM [ParkingApartment].[dbo].[tblVehicles] ";
    public static final String DISPLAY_LIST_VEHICLE_BY_CUS = "SELECT vehicleID,cusID,vehicleType,licensePlates FROM [ParkingApartment].[dbo].[tblVehicles] WHERE cusID=?";

    public List<VehicleDTO> getListVehicle() throws SQLException {
        List<VehicleDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_VEHICLE);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vehicleID = rs.getString("vehicleID");
                    String cusID = rs.getString("cusID");
                    String vehicleType = rs.getString("vehicleType");
                    String licensePlates = rs.getString("licensePlates");
                    list.add(new VehicleDTO(vehicleID, cusID, vehicleType, licensePlates));
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

    public List<VehicleDTO> getVehicleByCus(String cusID) throws SQLException {
        List<VehicleDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_VEHICLE_BY_CUS);
                stm.setString(1, cusID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vehicleID = rs.getString("vehicleID");
                    cusID = rs.getString("cusID");
                    String vehicleType = rs.getString("vehicleType");
                    String licensePlates = rs.getString("licensePlates");
                    list.add(new VehicleDTO(vehicleID, cusID, vehicleType, licensePlates));
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
}
