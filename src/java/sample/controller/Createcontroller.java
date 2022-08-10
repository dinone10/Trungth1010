/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Createcontroller", urlPatterns = {"/Createcontroller"})
public class Createcontroller extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String confirm = request.getParameter("confirm");
            boolean checkValidation = true;
            UserDAO dao = new UserDAO();
            boolean checkDuplicate = dao.checkDuplicate(userID);
            if (checkDuplicate) {
                userError.setUserIDError("Duplicate !!!");
                checkValidation = false;
            }
            if (userID.length() < 2 || userID.length() > 10) {
                userError.setUserIDError("UserID must be in[2,10]!");
                checkValidation = false;
            }
            if (fullName.length() < 5 || fullName.length() > 20) {
                userError.setFullNameError("Full Name must be in [5,20] !!!");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Hai password khong giong nhau!");
                checkValidation = false;
            }
            if (address.length() < 5 || address.length() > 20) {
                userError.setAddressError("Address must be in [5,20] !!!");
                checkValidation = false;
            }
            if (birthday.length() < 5 || birthday.length() > 20) {
                userError.setBirthdayError("Wrong date format !!!");
                checkValidation = false;
            }
            if (phone.length() < 10) {
                userError.setPhoneError("Wrong PHONE NUMBER format !!!");
                checkValidation = false;
            }
            if (email.length() < 4) {
                userError.setEmailError("Wrong EMAIL format !!!");
                checkValidation = false;
            }

            if (checkValidation) {
                UserDTO user = new UserDTO(userID, fullName, roleID, password, address, birthday, phone, email);
//                boolean checkCreate = dao.create(user);
                boolean checkCreate = dao.createV2(user);
                if (checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("Trung id roi kia!!!!");
                request.setAttribute("USER_ERROR", userError);
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
