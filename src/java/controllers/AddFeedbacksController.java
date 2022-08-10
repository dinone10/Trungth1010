/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import feedback.FeedbackDAO;
import feedback.FeedbackDTO;
import feedback.FeedbackError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddFeedbacksController", urlPatterns = {"/AddFeedbacksController"})
public class AddFeedbacksController extends HttpServlet {

    public static final String ERROR = "error.jsp";
    public static final String SUCCESS = "ViewFeedbackController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String rate = request.getParameter("rate");
            String cusID = request.getParameter("cusID");
            String infoFeedback = request.getParameter("infoFeedback");
            boolean check = true;
            FeedbackError feedbackError = new FeedbackError();
            if (cusID.length() > 10 || cusID.length() < 2) {
                feedbackError.setCusIDError("UserID leght must be [2,10]");
                check = false;
            }
            if (infoFeedback.length() > 50 || infoFeedback.length() < 2) {
                feedbackError.setInfoFeedbackError("Email leght must be [2,50]");
                check = false;
            }
            if (check) {
                FeedbackDAO dao = new FeedbackDAO();
                FeedbackDTO feedback = new FeedbackDTO(rate, cusID, infoFeedback);
                boolean checkInsert = dao.insertRate(feedback);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    feedbackError.setMessageError("Can not insert, unknow error!");
                    request.setAttribute("FEEDBACK_ERROR", feedbackError);
                }
            } else {
                request.setAttribute("FEEDBACK_ERROR", feedbackError);
            }
        } catch (Exception e) {
            log("Error at Add Feedback: " + e.toString());
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
