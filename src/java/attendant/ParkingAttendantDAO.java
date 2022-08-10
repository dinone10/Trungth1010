package attendant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

public class ParkingAttendantDAO {

    private static final String SEARCH = "SELECT empID, empName, phone, email, idAccount FROM tblParkingAttendants WHERE empName like ?";
    private static final String GET = "SELECT * FROM tblParkingAttendants WHERE empID=?";
    private static final String CREATE = "INSERT INTO [ParkingApartment].[dbo].[tblParkingAttendants](empID, empName, phone, email, idAccount) VALUES(?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT empID FROM [ParkingApartment].[dbo].[tblParkingAttendants] WHERE empID=?";
    private static final String UPDATE = "UPDATE [ParkingApartment].[dbo].[tblParkingAttendants] SET empName=?, phone=?, email=?, idAccount=? WHERE empID= ?";
    private static final String DELETE = "DELETE [ParkingApartment].[dbo].[tblParkingAttendants] WHERE empID=?";
    public static final String DISPLAY_LIST_PAT = "SELECT empID, empName, phone, email, idAccount FROM [ParkingApartment].[dbo].[tblParkingAttendants]";
    private static final String CHECK_DUPLICATE_ACCOUNTID = "SELECT userName FROM [ParkingApartment].[dbo].[tblAccounts] WHERE idAccount=?";
    public static final String DISPLAY_PAT_BY_ID = "SELECT empID, empName, phone, email, idAccount FROM [ParkingApartment].[dbo].[tblParkingAttendants] WHERE idAccount=?";

    public List<ParkingAttendantDTO> getListParkingAttendant(String search) throws SQLException {
        List<ParkingAttendantDTO> listParkingAttendant = new ArrayList<>();
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
                    String empID = rs.getString("empID");
                    String empName = rs.getString("empName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");
                    listParkingAttendant.add(new ParkingAttendantDTO(empID, empName, phone, email, idAccount));
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
        return listParkingAttendant;
    }

    public List<ParkingAttendantDTO> getPATByAccID(String idAccount) throws SQLException {
        List<ParkingAttendantDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_PAT_BY_ID);
                stm.setString(1, idAccount);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String empID = rs.getString("empID");
                    String empName = rs.getString("empName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    idAccount = rs.getString("idAccount");
                    list.add(new ParkingAttendantDTO(empID, empName, phone, email, idAccount));
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

    public ParkingAttendantDTO getParkingAttendantById(String getById) throws SQLException {

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
                    String empID = rs.getString("empID");
                    String empName = rs.getString("empName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");

                    ParkingAttendantDTO officeEmployee = new ParkingAttendantDTO(empID, empName, phone, email, idAccount);
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

    public boolean checkDuplicate(String empID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, empID);
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

    public boolean create(ParkingAttendantDTO emp) throws SQLException, ClassNotFoundException {
        System.out.println("conme cungdc");
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, emp.getEmpID());
                ptm.setString(2, emp.getEmpName());
                ptm.setString(3, emp.getPhone());
                ptm.setString(4, emp.getEmail());
                ptm.setString(5, emp.getIdAccount());

                check = ptm.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
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

    public boolean delete(String empID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, empID);
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

    public boolean update(ParkingAttendantDTO emp) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, emp.getEmpName());
                ptm.setString(2, emp.getPhone());
                ptm.setString(3, emp.getEmail());
                ptm.setString(4, emp.getIdAccount());
                ptm.setString(5, emp.getEmpID());

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

    public List<ParkingAttendantDTO> getListAllPAT() throws SQLException {
        List<ParkingAttendantDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_PAT);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String empID = rs.getString("empID");
                    String empName = rs.getString("empName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String idAccount = rs.getString("idAccount");
                    list.add(new ParkingAttendantDTO(empID, empName, phone, email, idAccount));
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
