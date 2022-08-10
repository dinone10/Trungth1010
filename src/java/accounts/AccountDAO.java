/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

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
public class AccountDAO {

    private static final String LOGIN = "SELECT idAccount, userName, password, roleID, email FROM tblAccounts WHERE userName=? AND password =?";
    private static final String LOGIN_GOOGLE = "SELECT idAccount, userName, password, roleID, email FROM tblAccounts WHERE userName=?";
    private static final String CREATE = "INSERT INTO [ParkingApartment].[dbo].[tblAccounts] (idAccount, userName, password, roleID, email) VALUES(?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_USERNAME = "SELECT idAccount FROM [ParkingApartment].[dbo].[tblAccounts] WHERE userName=?";
    private static final String CHECK_DUPLICATE_ACCOUNTID = "SELECT userName FROM [ParkingApartment].[dbo].[tblAccounts] WHERE idAccount=?";
    private static final String FIND_BY_USERNAME_EMAIL = "Select idAccount, userName, password, roleID, email from [ParkingApartment].[dbo].[tblAccounts] where userName = ? and email = ?";
    public static final String DISPLAY_LIST_ACCOUNT = "SELECT idAccount, userName, password, roleID, email FROM [ParkingApartment].[dbo].[tblAccounts]";
    private static final String DELETE_ACCOUNT = "DELETE [ParkingApartment].[dbo].[tblAccounts] WHERE idAccount=?";
    private static final String UPDATE_ACCOUNT = "UPDATE [ParkingApartment].[dbo].[tblAccounts] SET userName=?, password=?, roleID=?, email=? WHERE idAccount= ?";
    public static final String DISPLAY_LIST_ACCOUNT_BY_USER = "SELECT idAccount, userName,roleID FROM [ParkingApartment].[dbo].[tblAccounts] WHERE userName=? ";

    public List<AccountDTO> getListAllAccount() throws SQLException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_ACCOUNT);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idAccount = rs.getString("idAccount");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    list.add(new AccountDTO(idAccount, userName, password, roleID, email));
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

    public AccountDTO checkLogin(String userName, String password) throws SQLException {
        AccountDTO account = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String idAccount = rs.getString("idAccount");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    account = new AccountDTO(idAccount, userName, "", roleID, email);
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
        return account;
    }

    public AccountDTO checkLoginGoogle(String userName) throws SQLException {
        AccountDTO account = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userName);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String idAccount = rs.getString("idAccount");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    account = new AccountDTO(idAccount, userName, "", roleID, email);
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
        return account;
    }

    public boolean delete(String idAccount) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_ACCOUNT);
                ptm.setString(1, idAccount);
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

    public boolean updateAccount(AccountDTO account) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ACCOUNT);
                ptm.setString(1, account.getUserName());
                ptm.setString(2, account.getPassword());
                ptm.setString(3, account.getRoleID());
                ptm.setString(4, account.getEmail());
                ptm.setString(5, account.getIdAccount());

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

    public boolean createAccount(AccountDTO account) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, account.getIdAccount());
                ptm.setString(2, account.getUserName());
                ptm.setString(3, account.getPassword());
                ptm.setString(4, account.getRoleID());
                ptm.setString(5, account.getEmail());
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

    public boolean checkDuplicateUserName(String userName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_USERNAME);
                ptm.setString(1, userName);
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

    public AccountDTO findByUsernameAndEmail(String userName, String email) throws SQLException {
        AccountDTO account = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FIND_BY_USERNAME_EMAIL);
                ptm.setString(1, userName);
                ptm.setString(2, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String idAccount = rs.getString("idAccount");
                    String roleID = rs.getString("roleID");
                    String password = rs.getString("password");
                    account = new AccountDTO(idAccount, userName, password, roleID, email);
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
        return account;
    }

    public List<AccountDTO> getAccountByID(String userName) throws SQLException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DISPLAY_LIST_ACCOUNT_BY_USER);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idAccount = rs.getString("idAccount");
                    userName = rs.getString("userName");
                    String roleID = rs.getString("roleID");

                    list.add(new AccountDTO(idAccount, userName, roleID));
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
