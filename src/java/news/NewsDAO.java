/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

public class NewsDAO {

    
    private static final String INSERT = "INSERT INTO tblNews(idNew, infoNew, image, dateSubmitted, officeEmpID, title) VALUES(?,?,?,?,?,?)";
    private static final String DUPLICATE_NEWS = "SELECT idNew FROM tblFeedback WHERE idNew=?";
    public static final String ALL_NEW = "SELECT idNew, infoNew, image, dateSubmitted, officeEmpID, title FROM tblNews";
    private static final String DELETE = "DELETE tblNews WHERE idNew=?";
    public static final String UPDATE_NEWS_ADMIN = "UPDATE tblNews SET infoNew=?, image=?, dateSubmitted=?, officeEmpID=? ,title=? WHERE idNew=?";
    public static final String SEARCH = "SELECT idNew, infoNew, image, dateSubmitted, officeEmpID, title FROM tblNews WHERE title like ?";

     public List<NewsDTO> getListNews(String search) throws SQLException {
        List<NewsDTO> list = new ArrayList<>();
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
                    String idNew = rs.getString("idNew");
                    String infoNew = rs.getString("infoNew");
                    String image = rs.getString("image");
                    String dateSubmitted = rs.getString("dateSubmitted");
                    String officeEmpID = rs.getString("officeEmpID");
                    String title = rs.getString("title");
                    list.add(new NewsDTO(idNew, infoNew, image, dateSubmitted, officeEmpID, title));
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
     
      public List<NewsDTO> getListAllNews() throws SQLException {
        List<NewsDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(ALL_NEW);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idNew = rs.getString("idNew");
                    String infoNew = rs.getString("infoNew");
                    String image = rs.getString("image");
                    String dateSubmitted = rs.getString("dateSubmitted");
                    String officeEmpID = rs.getString("officeEmpID");
                    String title = rs.getString("title");
                    list.add(new NewsDTO(idNew, infoNew, image, dateSubmitted, officeEmpID, title));
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
      
    public boolean insertNews(NewsDTO news) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(INSERT);
            ptm.setString(1, news.getIdNews());
            ptm.setString(2, news.getInfoNews());
            ptm.setString(3, news.getImage());
            ptm.setString(4, news.getDateSubmited());
            ptm.setString(5, news.getOfficeEmpID());
            ptm.setString(6, news.getTitle());

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

    public boolean checkDuplicateNews(String idNews) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DUPLICATE_NEWS);
                ptm.setString(1, idNews);
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

   

    public boolean deleteNews(String idNew) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, idNew);
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

    public boolean updateNews(NewsDTO news) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                stm = conn.prepareStatement(UPDATE_NEWS_ADMIN);

                stm.setString(1, news.getInfoNews());
                stm.setString(2, news.getImage());
                stm.setString(3, news.getDateSubmited());
                stm.setString(4, news.getOfficeEmpID());
                stm.setString(5, news.getTitle());
                stm.setString(6, news.getIdNews());

                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<NewsDTO> searchListNews(String search) throws SQLException {
        List<NewsDTO> list = new ArrayList<>();
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
                    String idNew = rs.getString("idNew");
                    String infoNew = rs.getString("infoNew");
                    String image = rs.getString("image");
                    String dateSubmitted = rs.getString("dateSubmitted");
                    String officeEmpID = rs.getString("officeEmpID");
                    String title = rs.getString("title");
                    list.add(new NewsDTO(idNew, infoNew, image, dateSubmitted, officeEmpID, title));
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
}
