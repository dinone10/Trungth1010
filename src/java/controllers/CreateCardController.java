/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import card.CardDAO;
import card.CardDTO;
import card.CardError;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "CreateCardController", urlPatterns = {"/CreateCardController"})
public class CreateCardController extends HttpServlet {

    private static final String ERROR = "createCard.jsp";
    private static final String SUCCESS = "DisplayMyCardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CardError CardError = new CardError();
        try {
            String vehicleID = request.getParameter("vehicleID");
            String cusID = request.getParameter("cusID");
            String importDate = request.getParameter("importDate");
            String expirationDate = request.getParameter("expirationDate");
            String licensePlates = request.getParameter("licensePlates");
            boolean checkValidation = true;
            CardDAO dao = new CardDAO();
//check ngay nhap vao
            Date nowDate = new Date();
            Date checkTimeStart = new Date();
            Date checkTimeEnd = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            checkTimeStart = formater.parse(importDate);
            checkTimeEnd = formater.parse(expirationDate);
            long diff = checkTimeEnd.getTime() - checkTimeStart.getTime();
            long diffDays = (diff / (60 * 60 * 1000)) / 24;
            if (checkTimeStart.compareTo(nowDate) != 1) {
                CardError.setImportIDErorr("Date entered in the past!");
                checkValidation = false;
            }
            if (checkTimeEnd.compareTo(nowDate) != 1) {
                CardError.setExpirationDateErorr("Date entered in the past!");
                checkValidation = false;
            }
            if (checkValidation) {
                if (diffDays < 28) {
                    CardError.setExpirationDateErorr("Expiration Date time must be more than 1 month ! ");
                    checkValidation = false;
                }
            }
            if (checkValidation) {
                CardDTO card = new CardDTO(vehicleID, cusID, importDate, expirationDate, licensePlates);
                boolean checkCreate = dao.createCard(card);
                if (checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("CARD_ERROR", CardError);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                request.setAttribute("CARD_ERROR", CardError);
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
