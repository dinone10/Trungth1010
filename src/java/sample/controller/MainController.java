/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {

    private static final String ROLE = "role";
    private static final String ROLE_CONTROLLER = "RoleController";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String CREATE = "Create";
    private static final String CREATE_CONTROLLER = "Createcontroller";

    private static final String ADD = "Add";
    private static final String ADD_CONTROLLER = "AddProductController";
    private static final String VIEW = "View";
    private static final String VIEW_CONTROLLER = "viewCart.jsp";
    private static final String EDIT = "Edit";
    private static final String EDIT_CONTROLLER = "EditController";
    public static final String CHECK_EDIT = "CheckEdit";
    public static final String CHECK_EDIT_CONTROLLER = "CheckEditController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";

    private static final String ADD_TO_CART = "Add to cart";
    private static final String ADD_TO_CART_CONTRLLER = "AddToCartController";
    private static final String UPDATE_TO_CART = "Update";
    private static final String UPDATE_TO_CART_CONTROLLER = "UpdateCartController";
    private static final String REMOVE_TO_CART = "RemoveCart";
    private static final String REMOVE_TO_CART_CONTROLLER = "RemoveCartController";
    private static final String CHECK_OUT = "Go To Check Out";
    private static final String CHECK_OUT_CONTROLLER = "CheckOutController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (ADD.equals(action)) {
                url = ADD_CONTROLLER;
            } else if (VIEW.equals(action)) {
                url = VIEW_CONTROLLER;
            } else if (EDIT.equals(action)) {
                url = EDIT_CONTROLLER;
            } else if (CHECK_EDIT.equals(action)) {
                url = CHECK_EDIT_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } 
            
            
            else if (ADD_TO_CART.equals(action)) {
                url = ADD_TO_CART_CONTRLLER;
            } else if (ROLE.equals(action)) {
                url = ROLE_CONTROLLER;
            } else if (UPDATE_TO_CART.equals(action)) {
                url = UPDATE_TO_CART_CONTROLLER;
            } else if (REMOVE_TO_CART.equals(action)) {
                url = REMOVE_TO_CART_CONTROLLER;
            } else if (CHECK_OUT.equals(action)) {
                url = CHECK_OUT_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
