/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.AccountDAO;
import accounts.AccountDTO;
import accounts.AccountError;
import customers.CustomerDAO;
import customers.CustomerDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "infoCustomer.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        AccountError accountError = new AccountError();
        try {
            String idAccount = request.getParameter("idAccount");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String roleID = request.getParameter("roleID");
            String email = request.getParameter("email");
            boolean checkValidation = true;
            AccountDAO dao = new AccountDAO();
            CustomerDAO cusDao = new CustomerDAO();
            List<CustomerDTO> list = cusDao.getCusByID(idAccount);
            HttpSession session = request.getSession();
            session.setAttribute("LIST_CUS_CURRENT", list);
            boolean checkDuplicateUserName = dao.checkDuplicateUserName(userName);
            boolean checkDuplicateIdAccount = dao.checkDuplicateAccountID(idAccount);
            if (checkDuplicateUserName) {
                accountError.setUserNameError("Duplicate !!!");
                checkValidation = false;
            }
            if (checkDuplicateIdAccount) {
                accountError.setIdAccountError("Duplicate !!!");
                checkValidation = false;
            }
            if (userName.length() < 2 || userName.length() > 50) {
                accountError.setUserNameError("UserName must be in[2,50]!");
                checkValidation = false;
            }
            if (!idAccount.matches("^PA\\d{3}$")) {
                accountError.setIdAccountError("idAccount must be PA***!");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                accountError.setConfirmError("Confirm password is not the same!");
                checkValidation = false;
            }
            if (email.length() < 2 || email.length() > 50) {
                accountError.setEmailError("Email must be in[2,50]!");
                checkValidation = false;
            }
            if (checkValidation) {
                AccountDTO account = new AccountDTO(idAccount, userName, password, roleID, email);
                boolean checkCreate = dao.createAccount(account);
                if (checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ACCOUNT_ERROR", accountError);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                accountError.setUserNameError("The same id with available data!!!");
                accountError.setIdAccountError("The same id with available data!!!");
                request.setAttribute("ACCOUNT_ERROR", accountError);
            }
            log("Error at CreateController" + e.toString());
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
