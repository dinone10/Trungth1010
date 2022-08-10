package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import officeEmployees.OfficeEmployeeDAO;
import officeEmployees.OfficeEmployeeDTO;
import officeEmployees.OfficeEmployeeError;

@WebServlet(name = "UpdateOEController", urlPatterns = {"/UpdateOEController"})
public class UpdateOEController extends HttpServlet {

    private static final String ERROR = "editOE.jsp";
    private static final String SUCCESS = "DisplayOEController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OfficeEmployeeError oeError = new OfficeEmployeeError();
        try {
            String officeEmpID = request.getParameter("officeEmpID");
            String officeEmpName = request.getParameter("officeEmpName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String idAccount = request.getParameter("idAccount");

            boolean checkValidation = true;
            OfficeEmployeeDAO dao = new OfficeEmployeeDAO();

            if (!officeEmpID.matches("^E\\d{3}$")) {
                checkValidation = false;
                oeError.setOfficeEmpIDError("Office Employess ID must be OE*** !!!");
            }
            if (officeEmpName.length() < 2 || officeEmpName.length() > 50) {
                checkValidation = false;
                oeError.setOfficeEmpNameError("Parking Attendant Name must be [2,50]");
            }
            if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                oeError.setEmailError("Wrong format email! (Ex: ht1010@gmail.com )");
                checkValidation = false;
            }
            if (!idAccount.matches("^PA\\d{3}$")) {
                oeError.setIdAccountError("idAccount must be PA***!");
                checkValidation = false;
            }
            if (phone.length() != 10) {
                oeError.setPhoneError("Phone must be 10 number!");
                checkValidation = false;
            }
            if (checkValidation) {
                OfficeEmployeeDTO oe = new OfficeEmployeeDTO(officeEmpID, officeEmpName, phone, email, idAccount);
                boolean check = dao.updateOE(oe);
                if (check) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("OFFICE_EMPLOYEES_ERROR", oeError);
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
