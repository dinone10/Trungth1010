/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.AccountDAO;
import accounts.AccountDTO;
import attendant.ParkingAttendantDAO;
import attendant.ParkingAttendantDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
@WebServlet(name = "AddVehicleHistoryController", urlPatterns = {"/AddVehicleHistoryController"})
public class AddVehicleHistoryController extends HttpServlet {

    public static final String ERROR = "DisplayVehicleHistoryController";
    public static final String SUCCESS = "DisplayVehicleHistoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String vehicleID = request.getParameter("vehicleID");
            VehicleHistoryDAO dao = new VehicleHistoryDAO();
            List<VehicleHistoryDTO> list = dao.getListVehicleHisotryByVehicleID(vehicleID);
            HttpSession session = request.getSession();
            String userName = request.getParameter("userName");
            String idAccount = "";
            String empID = "";
            AccountDAO dao1 = new AccountDAO();
            List<AccountDTO> listAccount = dao1.getAccountByID(userName);
            session.setAttribute("LIST_ACCOUNT_BY_USER", listAccount);
            for (AccountDTO account : listAccount) {
                idAccount = account.getIdAccount();
            }
            ParkingAttendantDAO dao2 = new ParkingAttendantDAO();
            List<ParkingAttendantDTO> listPAT = dao2.getPATByAccID(idAccount);
            session.setAttribute("LIST_PAT_BY_ID", listPAT);
            for (ParkingAttendantDTO cus : listPAT) {
                empID = cus.getEmpID();
            }
            session.setAttribute("LIST_HIS_ID", list);
            boolean check = true;
            VehicleHistoryError vehicleHistoryError = new VehicleHistoryError();
            for (VehicleHistoryDTO vh : list) {
                if (vh.getTimeCheckOut() == null) {
                    vehicleHistoryError.setVehicleIDError("You must check-out first!");
                    check = false;
                    break;
                }
            }
            if (check) {
                VehicleHistoryDTO vehicleHistory = new VehicleHistoryDTO(vehicleID, empID);
                boolean checkInsert = dao.insertCheckIn(vehicleHistory);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    vehicleHistoryError.setMessageError("Vehicle ID or Employee ID not found in system!");
                    request.setAttribute("VEHICLE_HISTORY_ERROR", vehicleHistoryError);
                }
            } else {
                request.setAttribute("VEHICLE_HISTORY_ERROR", vehicleHistoryError);
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
