/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_detail;

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
public class SpaceDetailDAO {

    public static final String DISPLAY_LIST_SPACE_DETAIL_BY_ID = "SELECT parkingDetailID, slotID, timeStart, timeEnd, vehicleID, price, floorID FROM [ParkingApartment].[dbo].[tblParkingDetail] WHERE slotID =?";
    public static final String ADD_VEHICLE_TO_SLOT = "UPDATE [ParkingApartment].[dbo].[tblParkingDetail] SET timeStart=?, timeEnd=? , vehicleID=?  WHERE slotID= ?";
    public static final String DISPLAY_LIST_SPACE_DETAIL = "SELECT parkingDetailID, slotID, timeStart, timeEnd, vehicleID, price, floorID FROM [ParkingApartment].[dbo].[tblParkingDetail]";
    public static final String CLEAR_CAR_IN_SPACE = "UPDATE [ParkingApartment].[dbo].[tblParkingDetail] SET timeStart='Empty', timeEnd='Empty' , vehicleID='Empty'  WHERE slotID= ?";
    private static final String UPDATE_PRICE = "UPDATE [ParkingApartment].[dbo].[tblParkingDetail] SET price=?  WHERE slotID= ?";

    public List<SpaceDetailDTO> getSpaceDeatailByID(String slotID) throws SQLException {
        List<SpaceDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_DETAIL_BY_ID);
                stm.setString(1, slotID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String parkingDetailID = rs.getString("parkingDetailID");
                    slotID = rs.getString("slotID");
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    String vehicleID = rs.getString("vehicleID");
                    float price = Float.parseFloat(rs.getString("price"));
                    String floorID = rs.getString("floorID");

                    list.add(new SpaceDetailDTO(parkingDetailID, slotID, timeStart, timeEnd, vehicleID, price, floorID));
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

    public List<SpaceDetailDTO> getListAllSpaceDetail() throws SQLException {
        List<SpaceDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_DETAIL);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String parkingDetailID = rs.getString("parkingDetailID");
                    String slotID = rs.getString("slotID");
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    String vehicleID = rs.getString("vehicleID");
                    float price = Float.parseFloat(rs.getString("price"));
                    String floorID = rs.getString("floorID");
                    list.add(new SpaceDetailDTO(parkingDetailID, slotID, timeStart, timeEnd, vehicleID, price, floorID));
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

    public boolean addVehicleToSlot(SpaceDetailDTO spaceDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_VEHICLE_TO_SLOT);
                ptm.setString(1, spaceDetail.getTimeStart());
                ptm.setString(2, spaceDetail.getTimeEnd());
                ptm.setString(3, spaceDetail.getVehicleID());
                ptm.setString(4, spaceDetail.getSlotID());

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

    public boolean clearVehicleToSlot(SpaceDetailDTO spaceDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CLEAR_CAR_IN_SPACE);
                ptm.setString(1, spaceDetail.getSlotID());
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

    public boolean updatePriceSpace(SpaceDetailDTO space) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRICE);
                ptm.setFloat(1, space.getPrice());
                ptm.setString(2, space.getSlotID());
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
