/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.products.ProductDAO;
import sample.products.ProductDTO;
import sample.products.ProductError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CheckEditController", urlPatterns = {"/CheckEditController"})
public class CheckEditController extends HttpServlet {

    public static final String ERROR = "editProduct.jsp";
    public static final String SUCCESS = "RoleController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductError productError = new ProductError();
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            String image = request.getParameter("image");
            String importDate = request.getParameter("importDate");
            String usingDate = request.getParameter("usingDate");
            String status = request.getParameter("status");

            //CheckValidation
            boolean checkValidator = true;
//            if (productName.length() < 5 || productName.length() > 50) {
//                productError.setProductNameError("Product Name must be in [5,50]!");
//                checkValidator = false;
//            }
//            if (price <= 0) {
//                productError.setProductPriceError("Product Price must be more than zero!! ");
//                checkValidator = false;
//            }

            if (checkValidator) {
                ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, categoryID, importDate, usingDate, status);
                ProductDAO dao = new ProductDAO();
                boolean checkUpdate = dao.updateProduct(product);
                if (checkUpdate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("PRODUCT_ERROR", productError);
            }

        } catch (Exception e) {
            log("Error at ConfirmEditController " + e.toString());
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
