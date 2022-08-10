package controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import attendant.ParkingAttendantDAO;
import attendant.ParkingAttendantDTO;
import attendant.ParkingAttendantError;

@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "addPAT.jsp";
    private static final String SUCCESS = "DisplayPATController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("lamdcj");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ParkingAttendantError patError = new ParkingAttendantError();
        try {
            String empID = request.getParameter("empID");
            String empName = request.getParameter("empName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String idAccount = request.getParameter("idAccount");

            ParkingAttendantDAO dao = new ParkingAttendantDAO();
            boolean checkDuplicate = dao.checkDuplicate(empID);
            boolean checkValidation = true;

            if (checkDuplicate) {
                patError.setEmpIDError("Duplicate !!!");
                checkValidation = false;
            }
            if (!empID.matches("^PAT\\d{3}$")) {
                checkValidation = false;
                patError.setEmpIDError("Parking Attendant ID must be PAT*** !!!");
            }
            if (empName.length() < 2 || empName.length() > 50) {
                checkValidation = false;
                patError.setEmpNameError("Parking Attendant Name must be [2,50]");
            }
            if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                patError.setEmailError("Wrong format email! (Ex: ht1010@gmail.com )");
                checkValidation = false;
            }
            if (!idAccount.matches("^PA\\d{3}$")) {
                patError.setIdAccountError("idAccount must be PA***!");
                checkValidation = false;
            }
            if (phone.length() != 10) {
                patError.setPhoneError("Phone must be 10 number!");
                checkValidation = false;
            }

            if (checkValidation) {
                ParkingAttendantDTO pat = new ParkingAttendantDTO(empID, empName, phone, email, idAccount);
                boolean checkCreate = dao.create(pat);
                if (checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("PARKING_ATTENDANT_ERROR", patError);
            }

        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                patError.setEmpIDError("The same id with available data!!!");
                request.setAttribute("PARKING_ATTENDANT_ERROR", patError);
            }
            log("Error at CreateController: " + e.toString());
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
