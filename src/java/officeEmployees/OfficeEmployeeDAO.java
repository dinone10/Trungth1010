package officeEmployees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

public class OfficeEmployeeDAO {
    
    private static final String SEARCH = "SELECT officeEmpID, officeEmpName, phone, email, idAccount FROM tblOfficeEmployees WHERE officeEmpName like ?";
    private static final String GET = "SELECT * FROM tblOfficeEmployees WHERE officeEmpID=?";
    private static final String CREATE = "INSERT INTO [ParkingApartment].[dbo].[tblOfficeEmployees](officeEmpID, officeEmpName, phone, email, idAccount) VALUES(?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT officeEmpID FROM [ParkingApartment].[dbo].[tblOfficeEmployees] WHERE officeEmpID=?";
    private static final String UPDATE = "UPDATE tblOfficeEmployees SET officeEmpName=?, phone=?, email=?, idAccount=? WHERE officeEmpID= ?";
    private static final String DELETE = "DELETE tblOfficeEmployees WHERE officeEmpID=?";
    public static final String DISPLAY_LIST_EMPLOYEES = "SELECT officeEmpID, officeEmpName, phone, email, idAccount FROM tblOfficeEmployees";
    private static final String CHECK_DUPLICATE_ACCOUNTID = "SELECT userName FROM [ParkingApartment].[dbo].[tblAccounts] WHERE idAccount=?";
    
    public List<OfficeEmployeeDTO> getOfficeEmployee(String search) throws SQLException {
        List<OfficeEmployeeDTO> listOfficeEmployee = new ArrayList<>();
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
                    String officeEmpID = rs.getString("officeEmpID");
                    String officeEmpName = rs.getString("officeEmpName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");
                    listOfficeEmployee.add(new OfficeEmployeeDTO(officeEmpID, officeEmpName, phone, email, idAccount));
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
        return listOfficeEmployee;
    }
    
    public OfficeEmployeeDTO getOfficeEmployeeById(String getById) throws SQLException {
        
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
                    String officeEmpID = rs.getString("officeEmpID");
                    String officeEmpName = rs.getString("officeEmpName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");
                    
                    OfficeEmployeeDTO officeEmployee = new OfficeEmployeeDTO(officeEmpID, officeEmpName, phone, email, idAccount);
                    return officeEmployee;
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
    
    public boolean checkDuplicate(String officeEmpID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, officeEmpID);
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
    
    public boolean create(OfficeEmployeeDTO OfficeEmployee) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, OfficeEmployee.getOfficeEmpID());
                ptm.setString(2, OfficeEmployee.getOfficeEmpName());
                ptm.setString(3, OfficeEmployee.getPhone());
                ptm.setString(4, OfficeEmployee.getEmail());
                ptm.setString(5, OfficeEmployee.getIdAccount());
                
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
    
    public boolean delete(String officeEmpID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, officeEmpID);
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
    
    public boolean updateOE(OfficeEmployeeDTO offEmp) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, offEmp.getOfficeEmpName());
                ptm.setString(2, offEmp.getPhone());
                ptm.setString(3, offEmp.getEmail());
                ptm.setString(4, offEmp.getIdAccount());
                ptm.setString(5, offEmp.getOfficeEmpID());
                
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
    
    public List<OfficeEmployeeDTO> getListAllOfficeEmployee() throws SQLException {
        List<OfficeEmployeeDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_EMPLOYEES);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String officeEmpID = rs.getString("officeEmpID");
                    String officeEmpName = rs.getString("officeEmpName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");
                    list.add(new OfficeEmployeeDTO(officeEmpID, officeEmpName, phone, email, idAccount));
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
