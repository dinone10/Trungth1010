/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import space.SpaceDTO;
import space_detail.SpaceDetailDTO;
import utils.DBUtil;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    private static final String CREATE_ORDER = "INSERT INTO [ParkingApartment].[dbo].[tblOrder] (orderID,orderDate,total,cusID,status) VALUES (?,?,?,?,?)";
    private static final String CREATE_ORDER_DETAIL = "INSERT INTO [ParkingApartment].[dbo].[tblOrderDetail] (detailID,price,timeStart,timeEnd,orderID,slotID) values (?,?,?,?,?,?)";
    private static final String GET_ORDER_ID = "SELECT MAX(orderID) AS [orderID] FROM [ParkingApartment].[dbo].[tblOrder]";
    private static final String DELETE_STATUS = "UPDATE [ParkingApartment].[dbo].[tblParkingSlots] SET status=0  WHERE slotID= ?";
    private static final String DISPLAY_ORDER = "SELECT orderID,orderDate,total,cusID,status FROM [ParkingApartment].[dbo].[tblOrder] ";
    private static final String DISPLAY_ORDER_DETAIL_BY_ID = "SELECT detailID,price,timeStart,timeEnd,orderID,slotID FROM [ParkingApartment].[dbo].[tblOrderDetail] WHERE orderID=? ";
    private static final String SUCESS_ORDER = "UPDATE [ParkingApartment].[dbo].[tblOrder] SET status=1  WHERE orderID= ?";
    private static final String DISPLAY_MY_ORDER = "SELECT orderID,orderDate,total,cusID,status FROM [ParkingApartment].[dbo].[tblOrder] WHERE cusID=? ";
    private static final String DISPLAY_ORDER_DETAIL = "SELECT detailID,price,timeStart,timeEnd,orderID,slotID FROM [ParkingApartment].[dbo].[tblOrderDetail] ";
    private static final String DISPLAY_TURNOVER_YEAR = "select price,timeStart,timeEnd,orderID from tblOrderDetail where timeStart like ?";
    private static final String DISPLAY_ORDER_DETAIL_BY_SLOTID = "SELECT detailID,price,timeStart,timeEnd,orderID,slotID FROM [ParkingApartment].[dbo].[tblOrderDetail] WHERE slotID=? ";

    public boolean createOrder(String cusID, float total, Cart cart, String timeStart, String timeEnd) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            Date nowDate = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            String strNowDate = formater.format(nowDate);
            int status = 0;
            int count = 0;
            ptm = conn.prepareStatement(GET_ORDER_ID);
            rs = ptm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            count++;
            ptm = null;
            ptm = conn.prepareStatement(CREATE_ORDER);
            ptm.setInt(1, count);
            ptm.setString(2, strNowDate);
            ptm.setFloat(3, total);
            ptm.setString(4, cusID);
            ptm.setInt(5, status);
            check = ptm.executeUpdate() > 0;
            if (check) {
                ptm = null;
                rs = null;
                ptm = conn.prepareStatement(GET_ORDER_ID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int orderID = rs.getInt("orderID");

                    for (SpaceDetailDTO space : cart.getList()) {
                        ptm = null;
                        rs = null;
                        count = 0;
                        ptm = conn.prepareStatement("select max([detailID]) from [ParkingApartment].[dbo].[tblOrderDetail]");
                        rs = ptm.executeQuery();
                        if (rs.next()) {
                            count = rs.getInt(1);
                        }
                        count++;
                        ptm = null;
                        rs = null;
                        ptm = conn.prepareStatement(CREATE_ORDER_DETAIL);
                        ptm.setInt(1, count);
                        ptm.setFloat(2, space.getPrice());
                        ptm.setString(3, timeStart);
                        ptm.setString(4, timeEnd);
                        ptm.setInt(5, orderID);
                        ptm.setString(6, space.getSlotID());
                        check = ptm.executeUpdate() > 0;
//                        if (check) {
//                            ptm = null;
//                            rs = null;
//                            ptm = conn.prepareStatement(DELETE_STATUS);
//                            ptm.setString(1, space.getSlotID());
//                            check = ptm.executeUpdate() > 0;
//                        }
                    }
                }
            }
        } catch (SQLException e) {
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

    public List<OrderDTO> getListAllOrder() throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_ORDER);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String orderDate = rs.getString("orderDate");
                    float total = rs.getFloat("total");
                    String cusID = rs.getString("cusID");
                    String status = rs.getString("status");
                    list.add(new OrderDTO(orderID, orderDate, total, cusID, status));
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

    public List<OrderDTO> getMyOrder(String cusID) throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_MY_ORDER);
                stm.setString(1, cusID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String orderDate = rs.getString("orderDate");
                    float total = rs.getFloat("total");
                    cusID = rs.getString("cusID");
                    String status = rs.getString("status");
                    list.add(new OrderDTO(orderID, orderDate, total, cusID, status));
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

    public List<OrderDetailDTO> getListAllOrderDetail() throws SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_ORDER_DETAIL);
                rs = stm.executeQuery();
                while (rs.next()) {
                    float price = Float.parseFloat(rs.getString("price"));
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    int orderID = Integer.parseInt(rs.getString("orderID"));
                    String slotID = rs.getString("slotID");
                    int detailID = Integer.parseInt(rs.getString("detailID"));

                    list.add(new OrderDetailDTO(detailID, price, timeStart, timeEnd, orderID, slotID));
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

    public List<OrderDetailDTO> getOrderDeatailByID(int orderID) throws SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_ORDER_DETAIL_BY_ID);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String detailID = rs.getString("detailID");
                    float price = Float.parseFloat(rs.getString("price"));
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    orderID = Integer.parseInt(rs.getString("orderID"));
                    String slotID = rs.getString("slotID");

                    list.add(new OrderDetailDTO(orderID, price, timeStart, timeEnd, orderID, slotID));
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

    public List<OrderDetailDTO> getOrderDeatailBySlotID(String slotID) throws SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_ORDER_DETAIL_BY_SLOTID);
                stm.setString(1, slotID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int detailID = Integer.parseInt(rs.getString("detailID"));;
                    float price = Float.parseFloat(rs.getString("price"));
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    int orderID = Integer.parseInt(rs.getString("orderID"));
                    slotID = rs.getString("slotID");
                    list.add(new OrderDetailDTO(detailID, price, timeStart, timeEnd, orderID, slotID));
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

    public boolean SuccessOrder(int orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SUCESS_ORDER);
                ptm.setInt(1, orderID);
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

    public List<OrderDetailDTO> getListAllOrderYearDetail(String year) throws SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_TURNOVER_YEAR);
                stm.setString(1, "%" + year + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    float price = Float.parseFloat(rs.getString("price"));
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    int orderID = Integer.parseInt(rs.getString("orderID"));
                    list.add(new OrderDetailDTO(price, timeStart, timeEnd, orderID));
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
