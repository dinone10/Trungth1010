/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vehicleHistory.VehicleHistoryDAO;
import vehicleHistory.VehicleHistoryDTO;
import vehicleHistory.VehicleHistoryError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddVehicleHistoryOutController", urlPatterns = {"/AddVehicleHistoryOutController"})
public class AddVehicleHistoryOutController extends HttpServlet {

    public static final String ERROR = "DisplayVehicleHistoryController";
    public static final String SUCCESS = "DisplayVehicleHistoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String vehicleID = request.getParameter("vehicleID");
            String empID = request.getParameter("empID");
            String timeCheckOut = request.getParameter("timeCheckOut");
            String cusID = request.getParameter("cusID");
            VehicleHistoryDAO dao = new VehicleHistoryDAO();
            boolean check = true;
            VehicleHistoryError vehicleHistoryError = new VehicleHistoryError();
            

            if (check) {

                VehicleHistoryDTO vehicleHistory = new VehicleHistoryDTO(vehicleID, empID, timeCheckOut);
                boolean checkInsert = dao.intsertCheckOut(vehicleHistory, vehicleID);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    vehicleHistoryError.setMessageError("Can not insert, unknow error!");
                    request.setAttribute("VEHICLEHISTORY_ERROR", vehicleHistoryError);
                }
            } else {
                request.setAttribute("VEHICLEHISTORY_ERROR", vehicleHistoryError);
            }
        } catch (Exception e) {
            log("Error at Add Vihecle History: " + e.toString());
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
