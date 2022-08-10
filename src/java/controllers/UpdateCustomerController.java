/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import customers.CustomerDAO;
import customers.CustomerDTO;
import customers.CustomerError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCustomerController", urlPatterns = {"/UpdateCustomerController"})
public class UpdateCustomerController extends HttpServlet {

    private static final String ERROR = "editCUS.jsp";
    private static final String SUCCESS = "DisplayCUSController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CustomerError customerError = new CustomerError();
        try {
            String cusID = request.getParameter("cusID");
            String cusName = request.getParameter("cusName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String vehicleID = request.getParameter("vehicleID");
            String idAccount = request.getParameter("idAccount");
            CustomerDAO dao = new CustomerDAO();
            boolean checkValidation = true;
            if (cusName.length() < 2 || cusName.length() > 50) {
                customerError.setCusNameError("CusName must be in[2,50]!");
                checkValidation = false;
            }
            if (!idAccount.matches("^PA\\d{3}$")) {
                customerError.setIdAccountError("idAccount must be PA***!");
                checkValidation = false;
            }
            if (!cusID.matches("^C\\d{3}$")) {
                customerError.setCusIDError("cusID must be C***!");
                checkValidation = false;
            }

            if (email.matches("/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")) {
                customerError.setEmailError("Email must be ***@gmail.com");
                checkValidation = false;
            }
            if (phone.length() != 10) {
                customerError.setPhoneError("Phone must be 10 number!");
                checkValidation = false;
            }
            if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                customerError.setEmailError("Wrong format email! (Ex: ht1010@gmail.com )");
                checkValidation = false;
            }
            if (checkValidation) {
                CustomerDTO customer = new CustomerDTO(cusID, cusName, phone, email, vehicleID, idAccount);
                boolean check = dao.updateCUS(customer);
                if (check) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("CUSTOMER_ERROR", customerError);
            }

        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
