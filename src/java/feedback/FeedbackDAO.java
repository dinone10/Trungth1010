/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

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
public class FeedbackDAO {

    private static final String INSERT = "INSERT INTO tblFeedback(cusID, infoFeedBack) VALUES(?,?)";
    private static final String SEARCH = "SELECT cusID, infoFeedBack FROM tblFeedback WHERE cusID like ?";
    private static final String DELETE = "DELETE tblFeedback WHERE idFeedback=?";
    private static final String DUPLICATE = "SELECT cusID FROM tblFeedback WHERE cusID=?";
    public static final String ALL_FEEDBACK = "SELECT idFeedback,cusID,infoFeedBack,rate FROM tblFeedback";
    private static final String INSERT_RATE = "INSERT INTO tblFeedback(rate, cusID, infoFeedBack) VALUES(?,?,?)";

    public List<FeedbackDTO> getListFeedback(String search) throws SQLException {
        List<FeedbackDTO> list = new ArrayList(); // Arraylist()<>;
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
                    String infoFeedback = rs.getString("infoFeedback");
                    String rate = rs.getString("rate");
                    list.add(new FeedbackDTO(cusID, infoFeedback, rate));
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

    public boolean deleteFeedback(String idFeedback) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, idFeedback);
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

    public boolean insert(FeedbackDTO feedback) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(INSERT);
            ptm.setString(1, feedback.getCusID());
            ptm.setString(2, feedback.getInfoFeedback());
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

    public boolean insertRate(FeedbackDTO feedback) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(INSERT_RATE);
            ptm.setString(1, feedback.getCusID());
            ptm.setString(2, feedback.getInfoFeedback());
            ptm.setString(3, feedback.getRate());

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

    public boolean checkDuplicate(String idFeedback) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DUPLICATE);
                ptm.setString(1, idFeedback);
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

    public List<FeedbackDTO> getListAllFeedback() throws SQLException {
        List<FeedbackDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(ALL_FEEDBACK);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idFeedback = rs.getString("idFeedback");
                    String rate = rs.getString("rate");
                    String cusID = rs.getString("cusID");
                    String infoFeedback = rs.getString("infoFeedback");
                    list.add(new FeedbackDTO(idFeedback, cusID, infoFeedback, rate));

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

    public static void main(String[] args) throws SQLException {
        FeedbackDAO dao = new FeedbackDAO();
        List<FeedbackDTO> list = dao.getListAllFeedback();
        for (FeedbackDTO o : list) {
            System.out.println(o);
        }
    }
}
