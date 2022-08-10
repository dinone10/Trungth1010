/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

    private static final String ERROR = "createProduct.jsp";
    private static final String SUCCESS = "admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductError productError = new ProductError();
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            float price = Float.parseFloat(request.getParameter("price"));
            String image = request.getParameter("image");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            String importDate = request.getParameter("importDate");
            String usingDate = request.getParameter("usingDate");
            String status = request.getParameter("status");
            boolean checkValidation = true;
            ProductDAO dao = new ProductDAO();
            boolean checkDuplicate = dao.checkDuplicate(productID);
//            if (checkDuplicate) {
//                productError.setProductIDError("Duplicate !!!");
//                checkValidation = false;
//            }
//            if (productID.length() < 2 || productID.length() > 10) {
//                productError.setProductIDError("ProductID must be in[2,10]!");
//                checkValidation = false;
//            }

            if (checkValidation) {
                ProductDTO product = new ProductDTO(productID, productName, image, price,quantity, categoryID, importDate, usingDate, status);
                boolean checkCreate = dao.addNewProduct(product);
                if (checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("PRODUCT_ERROR", productError);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                productError.setProductIDError("Trung id roi kia!!!!");
                request.setAttribute("PRODUCT_ERROR", productError);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
