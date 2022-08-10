/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.AccountDTO;
import card.CardDAO;
import card.CardDTO;
import card.CardError;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ExtendCardController", urlPatterns = {"/ExtendCardController"})
public class ExtendCardController extends HttpServlet {

    private static final String ERROR = "extendCard.jsp";
    private static final String SUCCESS = "DisplayMyCardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CardError cardError = new CardError();
        try {
            int longCardID = Integer.parseInt(request.getParameter("longCardID"));
            String expirationDate = request.getParameter("expirationDate");
            int numberDate = Integer.parseInt(request.getParameter("numberDate"));
            Date checkExDate = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            checkExDate = formater.parse(expirationDate);
            cal.setTime(checkExDate);
            cal.add(Calendar.DATE, numberDate);
            expirationDate = formater.format(cal.getTime());
            boolean checkValidation = true;
            CardDAO dao = new CardDAO();

            if (numberDate < 30) {
                cardError.setImportIDErorr("The date entered must be 30 days older than the current expiration date!");
                checkValidation = false;
            }
            if (checkValidation) {
                CardDTO account = new CardDTO(longCardID, expirationDate);
                boolean check = dao.extendCard(account);
                boolean checkStatus = dao.SetStatusFalse(longCardID);
                if (check) {
                    if (checkStatus) {
                        url = SUCCESS;
                    }
                }
            } else {
                request.setAttribute("CARD_ERROR", cardError);
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
