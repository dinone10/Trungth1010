/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import space.SpaceDAO;
import space_detail.SpaceDetailDAO;
import space_detail.SpaceDetailDTO;
import space_detail.SpaceDetailError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddVehicleToSlotController", urlPatterns = {"/AddVehicleToSlotController"})
public class AddVehicleToSlotController extends HttpServlet {

    private static final String ERROR = "addVehicleToSlot.jsp";
    private static final String SUCCESS = "DisplaySpaceController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        SpaceDetailError spaceDetailError = new SpaceDetailError();
        try {
            String parkingDetailID = request.getParameter("parkingDetailID");
            String slotID = request.getParameter("slotID");
            String timeStart = request.getParameter("timeStart");
            String timeEnd = request.getParameter("timeEnd");
            String vehicleID = request.getParameter("vehicleID");
            boolean checkValidation = true;
            SpaceDetailDAO dao = new SpaceDetailDAO();
            SpaceDAO dao1 = new SpaceDAO();
//Check Date
            Date nowDate = new Date();
            Date checkTimeStart = new Date();
            Date checkTimeEnd = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            checkTimeStart = formater.parse(timeStart);
            checkTimeEnd = formater.parse(timeEnd);
            long diff = checkTimeEnd.getTime() - checkTimeStart.getTime();
            long diffDays = (diff / (60 * 60 * 1000)) / 24;

            if (checkTimeStart.compareTo(nowDate) != 1) {
                spaceDetailError.setTimeStartError("Date entered in the past!");
                checkValidation = false;
            }
            if (checkTimeEnd.compareTo(nowDate) != 1) {
                spaceDetailError.setTimeEndError("Date entered in the past!");
                checkValidation = false;
            }
            if (checkValidation) {
                if (diffDays < 28) {
                    spaceDetailError.setTimeEndError("Check Out time must be more than 1 month ! ");
                    checkValidation = false;
                }
            }
            if (checkValidation) {
                SpaceDetailDTO spaceDetail = new SpaceDetailDTO(parkingDetailID, slotID, timeStart, timeEnd, vehicleID);
                boolean check = dao.addVehicleToSlot(spaceDetail);
                if (check) {
                    dao1.DeleteStatusSpace(slotID);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("SPACE_DETAIL_ERROR", spaceDetailError);
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
