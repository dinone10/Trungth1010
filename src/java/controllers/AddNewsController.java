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
@WebServlet(name = "AddNewsController", urlPatterns = {"/AddNewsController"})
public class AddNewsController extends HttpServlet {

    public static final String ERROR = "newsADD.jsp";
    public static final String SUCCESS = "ViewNewsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String idNews = request.getParameter("idNews");
            String infoNews = request.getParameter("infoNews");
            String image = request.getParameter("image");
            String dateSubmited = request.getParameter("dateSubmited");
            String officeEmpID = request.getParameter("officeEmpID");
            String title = request.getParameter("title");
            boolean check = true;
            NewsError newsError = new NewsError();
            if (!idNews.matches("^N\\d{3}$")) {
                newsError.setIdNewsError("idNews must be N***!");
                check = false;
            }
            if (infoNews.length() > 1000 || infoNews.length() < 2) {
                newsError.setInfoNewsError("infoNews leght must be [2,1000]");
                check = false;
            }
            if (image.length() > 1000 || image.length() < 2) {
                newsError.setImageError("image leght must be [2,1000]");
                check = false;
            }
            if (!dateSubmited.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
                newsError.setDateSubmitedError("idNews must be N***!");
                check = false;
            }
            if (!officeEmpID.matches("^E\\d{3}$")) {
                newsError.setOfficeEmpIDError("IDOE must be C***!");
                check = false;
            }
            if (title.length() > 1000 || title.length() < 2) {
                newsError.setTitleError("Title leght must be [2,1000]");
                check = false;
            }

            if (check) {
                NewsDAO dao = new NewsDAO();
                NewsDTO user = new NewsDTO(idNews, infoNews, image, dateSubmited, officeEmpID, title);
                boolean checkDuplicate = dao.checkDuplicateNews(idNews);
                if (checkDuplicate) {
                    newsError.setIdNewsError("Duplicate IDNews: " + idNews + " !");
                    request.setAttribute("NEWS_ERROR", newsError);
                } else {
                    boolean checkInsert = dao.insertNews(user);
                    if (checkInsert) {
                        url = SUCCESS;
                    } else {
                        newsError.setMessageError("Can not insert, unknow error!");
                        request.setAttribute("NEWS_ERROR", newsError);
                    }
                }
            } else {
                request.setAttribute("NEWS_ERROR", newsError);
            }
        } catch (Exception e) {
            log("Error at AddNewsController: " + e.toString());
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
