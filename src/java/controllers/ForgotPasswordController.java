/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.AccountDAO;
import accounts.AccountDTO;
import email.EmailDAO;
import email.EmailDTO;
import java.io.IOException;
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
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/ForgotPasswordController"})
public class ForgotPasswordController extends HttpServlet {

    private static final String ERROR = "forgotPassword.jsp";
    private static final String SUCCESS = "forgotPassword.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            AccountDAO dao = new AccountDAO();
            AccountDTO account = dao.findByUsernameAndEmail(userName, email);
            HttpSession session = request.getSession();
            if (account != null) {
                EmailDTO _email = new EmailDTO();
                _email.setFrom("trungthse150485@fpt.edu.vn");
                _email.setFromPassword("trung123");
                _email.setTo(email);
                _email.setSubject("Forgot Password Funtion");
                StringBuilder sb = new StringBuilder();
                sb.append("Dear ").append(userName).append("<br>");
                sb.append("You are used the forgot password funtion. <br> ");
                sb.append("Your password is <b>").append(account.getPassword()).append("</b><br>");
                sb.append("Regards <br>");
                sb.append("Administrator.");

                _email.setContent(sb.toString());
                EmailDAO.send(_email);
                url = SUCCESS;
                session.setAttribute("ERROR", "Email send to the email Address."
                        + "Please check and get your password!");
            } else {
                session.setAttribute("ERROR", "UserName or Email are incorrect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("ERROR", e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

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
