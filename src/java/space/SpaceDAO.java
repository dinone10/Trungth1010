/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

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
public class SpaceDAO {

    public static final String DISPLAY_LIST_SPACE = "SELECT slotID, floorID, status, parkingDetailID FROM [ParkingApartment].[dbo].[tblParkingSlots]";
    private static final String UPDATE_SPACE = "UPDATE [ParkingApartment].[dbo].[tblParkingSlots] SET status=?  WHERE slotID= ?";
    private static final String DELETE_STATUS = "UPDATE [ParkingApartment].[dbo].[tblParkingSlots] SET status=0  WHERE slotID= ?";
    private static final String TRUE_STATUS = "UPDATE [ParkingApartment].[dbo].[tblParkingSlots] SET status=1  WHERE slotID= ?";
    public static final String DISPLAY_LIST_SPACE_A1 = "SELECT slotID, floorID, status, parkingDetailID FROM [ParkingApartment].[dbo].[tblParkingSlots] WHERE floorID='A1'";
    public static final String DISPLAY_LIST_SPACE_A2 = "SELECT slotID, floorID, status, parkingDetailID FROM [ParkingApartment].[dbo].[tblParkingSlots] WHERE floorID='A2'";
    public static final String DISPLAY_LIST_SPACE_B1 = "SELECT slotID, floorID, status, parkingDetailID FROM [ParkingApartment].[dbo].[tblParkingSlots] WHERE floorID='B1'";
    public static final String DISPLAY_LIST_SPACE_B2 = "SELECT slotID, floorID, status, parkingDetailID FROM [ParkingApartment].[dbo].[tblParkingSlots] WHERE floorID='B2'";

    public List<SpaceDTO> getListAllSpace() throws SQLException {
        List<SpaceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String slotID = rs.getString("slotID");
                    String floorID = rs.getString("floorID");
                    String status = rs.getString("status");
                    String parkingDetailID = rs.getString("parkingDetailID");
                    list.add(new SpaceDTO(slotID, floorID, status, parkingDetailID));
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

    public List<SpaceDTO> getListSpaceA1() throws SQLException {
        List<SpaceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_A1);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String slotID = rs.getString("slotID");
                    String floorID = rs.getString("floorID");
                    String status = rs.getString("status");
                    String parkingDetailID = rs.getString("parkingDetailID");
                    list.add(new SpaceDTO(slotID, floorID, status, parkingDetailID));
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

    public List<SpaceDTO> getListSpaceA2() throws SQLException {
        List<SpaceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_A2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String slotID = rs.getString("slotID");
                    String floorID = rs.getString("floorID");
                    String status = rs.getString("status");
                    String parkingDetailID = rs.getString("parkingDetailID");
                    list.add(new SpaceDTO(slotID, floorID, status, parkingDetailID));
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

    public List<SpaceDTO> getListSpaceB1() throws SQLException {
        List<SpaceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_B1);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String slotID = rs.getString("slotID");
                    String floorID = rs.getString("floorID");
                    String status = rs.getString("status");
                    String parkingDetailID = rs.getString("parkingDetailID");
                    list.add(new SpaceDTO(slotID, floorID, status, parkingDetailID));
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

    public List<SpaceDTO> getListSpaceB2() throws SQLException {
        List<SpaceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_SPACE_B2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String slotID = rs.getString("slotID");
                    String floorID = rs.getString("floorID");
                    String status = rs.getString("status");
                    String parkingDetailID = rs.getString("parkingDetailID");
                    list.add(new SpaceDTO(slotID, floorID, status, parkingDetailID));
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

    public boolean updateStatusSpace(SpaceDTO space) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_SPACE);
                ptm.setString(1, space.getStatus());
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

    public boolean DeleteStatusSpace(String slotID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_STATUS);
                ptm.setString(1, slotID);
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

    public boolean SetStatusTrue(String slotID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TRUE_STATUS);
                ptm.setString(1, slotID);
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
}
