/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.AccountDAO;
import accounts.AccountDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "index.jsp";
    private static final String OE = "OE";
    private static final String OFFICE_EMPLOYEE_PAGE = "DisplayOEController";
    private static final String PAT = "PAT";
    private static final String PARKING_ATTENDANT_PAGE = "DisplayVehicleHistoryController";
    private static final String CUS = "CUS";
    private static final String CUSTOMER_PAGE = "home.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            boolean remember = request.getParameter("remember") != null;
            String idAccount = request.getParameter("idAccount");
            AccountDAO dao = new AccountDAO();
            AccountDTO loginAccount = dao.checkLogin(userName, password);
            HttpSession session = request.getSession();
            if (loginAccount != null) {
                session.setAttribute("LOGIN_ACCOUNT", loginAccount);
                session.setAttribute("CURRENT_LOGIN", loginAccount);
                String roleID = loginAccount.getRoleID();
                if (OE.equals(roleID)) {
                    url = OFFICE_EMPLOYEE_PAGE;
                } else if (PAT.equals(roleID)) {
                    url = PARKING_ATTENDANT_PAGE;
                } else if (CUS.equals(roleID)) {
                    url = CUSTOMER_PAGE;
                } else {
                    session.setAttribute("ERROR", "Your role is not support !");
                }
                if (remember) {
                    Cookie cookieUname = new Cookie("cookUname", userName);
                    cookieUname.setMaxAge(60 * 10);
                    Cookie cookiePass = new Cookie("cookPass", password);
                    cookiePass.setMaxAge(60 * 10);
                    Cookie cookRemember = new Cookie("cookRem", "1");
                    cookRemember.setMaxAge(60 * 10);
                    response.addCookie(cookieUname);
                    response.addCookie(cookiePass);
                    response.addCookie(cookRemember);
                }
            } else {
                session.setAttribute("ERROR", "Incorrect userID or password");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
