package customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import officeEmployees.OfficeEmployeeDTO;
import utils.DBUtil;

public class CustomerDAO {

    private static final String SEARCH = "SELECT cusID, cusName, phone, email, vehicleID, idAccount FROM tblCustomers WHERE cusName like ?";
    private static final String GET = "SELECT * FROM tblCustomers WHERE cusID=?";
    private static final String CREATE_CUSTOMER = "INSERT INTO [ParkingApartment].[dbo].[tblCustomers](cusID, cusName, phone, email, vehicleID, idAccount) VALUES(?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT cusID FROM tblCustomers WHERE cusID=?";
    private static final String UPDATE_CUS = "UPDATE [ParkingApartment].[dbo].[tblCustomers] SET cusName=?, phone=?, email=?,vehicleID=?, idAccount=? WHERE cusID=?";
    private static final String DELETE_CUS = "DELETE [ParkingApartment].[dbo].[tblCustomers] WHERE cusID=?";
    public static final String DISPLAY_LIST_CUS = "SELECT cusID, cusName, phone, email,vehicleID, idAccount FROM [ParkingApartment].[dbo].[tblCustomers]";
    private static final String CHECK_DUPLICATE_USERNAME = "SELECT idAccount FROM [ParkingApartment].[dbo].[tblCustomers] WHERE cusID=?";
    private static final String CHECK_DUPLICATE_ACCOUNTID = "SELECT cusID FROM [ParkingApartment].[dbo].[tblCustomers] WHERE idAccount=?";
    private static final String CHECK_DUPLICATE_PHONE = "SELECT phone FROM [ParkingApartment].[dbo].[tblCustomers] WHERE phone=?";
    public static final String GET_CUS_BY_ID = "SELECT cusID, cusName, phone, email,vehicleID, idAccount FROM [ParkingApartment].[dbo].[tblCustomers] where idAccount=?";
    private static final String CHECK_DUPLICATE_ID_ACCOUNT = "SELECT idAccount FROM [ParkingApartment].[dbo].[tblCustomers] WHERE idAccount=?";

    public List<CustomerDTO> getCustomer(String search) throws SQLException {
        List<CustomerDTO> listCustomer = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String cusID = rs.getString("cusID");
                    String cusName = rs.getString("cusName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String vehicleID = rs.getString("vehicleID");
                    String idAccount = rs.getString("idAccount");
                    listCustomer.add(new CustomerDTO(cusID, cusName, phone, email, vehicleID, idAccount));
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
        return listCustomer;
    }

    public CustomerDTO getCustomerById(String getById) throws SQLException {

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET);
                ptm.setString(1, getById);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String cusID = rs.getString("cusID");
                    String cusName = rs.getString("cusName");
                    String phone = rs.getString("phone");
                    String vehicleID = rs.getString("vehicleID");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");

                    CustomerDTO customer = new CustomerDTO(cusID, cusName, phone, email, vehicleID, idAccount);
                    return customer;
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
        return null;
    }

    public boolean checkDuplicate(String cusID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, cusID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean checkDuplicateIdAccount(String idAccount) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_ID_ACCOUNT);
                ptm.setString(1, idAccount);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean checkDuplicatePhone(String phone) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_PHONE);
                ptm.setString(1, phone);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean createCUS(CustomerDTO Customer) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_CUSTOMER);
                ptm.setString(1, Customer.getCusID());
                ptm.setString(2, Customer.getCusName());
                ptm.setString(3, Customer.getPhone());
                ptm.setString(4, Customer.getEmail());
                ptm.setString(5, Customer.getVehicleID());
                ptm.setString(6, Customer.getIdAccount());

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

    public boolean deleteCUS(String cusID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_CUS);
                ptm.setString(1, cusID);
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

    public boolean updateCUS(CustomerDTO Cus) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_CUS);
                ptm.setString(1, Cus.getCusName());
                ptm.setString(2, Cus.getPhone());
                ptm.setString(3, Cus.getEmail());
                ptm.setString(4, Cus.getVehicleID());
                ptm.setString(5, Cus.getIdAccount());
                ptm.setString(6, Cus.getCusID());

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

    public List<CustomerDTO> getListAllCus() throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_CUS);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cusID = rs.getString("cusID");
                    String cusName = rs.getString("cusName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String vehicleID = rs.getString("vehicleID");
                    String idAccount = rs.getString("idAccount");
                    list.add(new CustomerDTO(cusID, cusName, phone, email, vehicleID, idAccount));
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

    public List<CustomerDTO> getCusByID(String idAccount) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_CUS_BY_ID);
                stm.setString(1, idAccount);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cusID = rs.getString("cusID");
                    idAccount = rs.getString("idAccount");
                    String cusName = rs.getString("cusName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String vehicleID = rs.getString("vehicleID");

                    list.add(new CustomerDTO(cusID, cusName, phone, email, vehicleID, idAccount));
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

    public boolean checkDuplicateCusID(String cusID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_USERNAME);
                ptm.setString(1, cusID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean checkDuplicateAccountID(String idAccount) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_ACCOUNTID);
                ptm.setString(1, idAccount);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

}
