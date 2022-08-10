/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Account;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.AccountFacade;

/**
 *
 * @author team2
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @EJB
    private AccountFacade af;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "log":
                check(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "signUp":
                signUp(request, response);
                break;
            default:
                request.setAttribute("controller", "error");
                request.setAttribute("action", "index");
        }
        request.getRequestDispatcher(App.LAYOUT).forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("accept", null);
        request.setAttribute("controller", "home");
        request.setAttribute("action", "index");
        request.getRequestDispatcher(App.WEB).forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {

    }

    private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> listMember = af.findAll();
        HttpSession session = request.getSession();
        String userName = (String) request.getParameter("username");
        String password = (String) request.getParameter("pass");
        int count = 1;
        for (Account user : listMember) {
            if (user.getUsername().equals(userName) && user.getPass().equals(password)) {
                session.setAttribute("accept", user);
                count = 0;
                request.setAttribute("controller", "home");
                request.setAttribute("action", "index");
                request.getRequestDispatcher(App.WEB).forward(request, response);
                break;
            }
        }
        if (count == 1) {
            request.setAttribute("messeger", "Incorrect user name or password. Try again.");
            request.setAttribute("action", "index");
        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getParameter("usernames");
        String password = (String) request.getParameter("passs");
        String password2 = (String) request.getParameter("passs2");
        List<Account> listMember = af.findAll();
        double discount = 10;
        Account ac = new Account();
        int count = 0;
        for (Account user : listMember) {
            if (user.getUsername().equals(userName)) {
                request.setAttribute("messeger", "User already exist");
                request.setAttribute("username", userName);
                request.setAttribute("action", "create");
                count = 1;
                break;
            }
        }
        if (password.equals(password2) == false) {
            request.setAttribute("messeger", "Incorrect password. Please try again");
            request.setAttribute("username", userName);
            request.setAttribute("action", "create");
            count = 1;
        }
        if (count == 0) {
            ac.setUsername(userName);
            ac.setPass(password);
            ac.setDiscount(discount);
            af.create(ac);
            request.setAttribute("messeger", "Register successed");
            request.setAttribute("action", "create");
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
