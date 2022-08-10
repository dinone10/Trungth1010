/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import news.NewsDAO;
import news.NewsDTO;
import news.NewsError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateNewsController", urlPatterns = {"/UpdateNewsController"})
public class UpdateNewsController extends HttpServlet {

    private static final String ERROR = "editNews.jsp";
    private static final String SUCCESS = "ViewNewsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        NewsError newsError = new NewsError();
        try {
            String idNews = request.getParameter("idNews");
            String infoNews = request.getParameter("infoNews");
            String image = request.getParameter("image");
            String dateSubmited = request.getParameter("dateSubmited");
            String officeEmpID = request.getParameter("officeEmpID");
            String title = request.getParameter("title");

            boolean checkValidation = true;
            NewsDAO dao = new NewsDAO();

            if (infoNews.length() > 1000 || infoNews.length() < 2) {
                newsError.setDateSubmitedError("infoNews leght must be [2,1000]");
                checkValidation = false;
            }
            if (image.length() > 1000 || image.length() < 2) {
                newsError.setInfoNewsError("image leght must be [2,1000]");
                checkValidation = false;
            }
            if (!dateSubmited.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
                newsError.setIdNewsError("idNews must be N***!");
                checkValidation = false;
            }
            if (!officeEmpID.matches("^E\\d{3}$")) {
                newsError.setOfficeEmpIDError("IDOE must be E***!");
                checkValidation = false;
            }
            if (title.length() > 1000 || title.length() < 2) {
                newsError.setInfoNewsError("UserID leght must be [2,1000]");
                checkValidation = false;
            }
            if (checkValidation) {
                NewsDTO news = new NewsDTO(idNews, infoNews, image, dateSubmited, officeEmpID, title);
                boolean check = dao.updateNews(news);
                if (check) {
                    url = SUCCESS;
                }
            } else {
                newsError.setMessageError("Can not update, unknow error!");
                request.setAttribute("NEWS_ERROR", newsError);
            }

        } catch (Exception e) {
            log("Error at UpdateNewsController: " + e.toString());
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
