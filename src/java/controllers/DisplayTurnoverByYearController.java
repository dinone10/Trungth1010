/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.OrderDAO;
import cart.OrderDetailDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DisplayTurnoverByYearController", urlPatterns = {"/DisplayTurnoverByYearController"})
public class DisplayTurnoverByYearController extends HttpServlet {

    public static final String ERROR = "error.jsp";
    public static final String SUCESSFUL = "viewTurnoverByYear.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("1");
        String url = ERROR;
        try {

            String year = request.getParameter("year");
            OrderDAO dao = new OrderDAO();
            List<OrderDetailDTO> list = dao.getListAllOrderYearDetail(year);
            System.out.println(list.size());
            if (list.size() > 0) {
                float total = 0;

                for (OrderDetailDTO detail : list) {
                    total += detail.getPrice();

                }
                System.out.println("abc"+total);
                request.setAttribute("TURNOVER", total);

                System.out.println("3");
                url = SUCESSFUL;
            }

        } catch (Exception e) {
            log("Error at DisplayTurnoverController: " + e.toString());
            System.out.println("4");
        } finally {
            System.out.println("5");
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
