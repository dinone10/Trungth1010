/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.Cart;
import cart.OrderDAO;
import cart.OrderDetailDTO;
import cart.OrderError;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import space_detail.SpaceDetailDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddSlotToCartController", urlPatterns = {"/AddSlotToCartController"})
public class AddSlotToCartController extends HttpServlet {

    public static final String ERROR = "booking.jsp";
    public static final String SUCCESS = "DisplaySpaceBookingController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OrderError orderError = new OrderError();
        try {
            String parkingDetailID = request.getParameter("parkingDetailID");
            String slotID = request.getParameter("slotID");
            float price = Float.parseFloat(request.getParameter("price"));
            String floorID = request.getParameter("floorID");
            String timeStart = request.getParameter("timeStart");
            String timeEnd = request.getParameter("timeEnd");

            Date nowDate = new Date();
            Date checkTimeStart = new Date();
            Date checkTimeEnd = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            checkTimeStart = formater.parse(timeStart);
            checkTimeEnd = formater.parse(timeEnd);
            long diff = checkTimeEnd.getTime() - checkTimeStart.getTime();
            long diffDays = (diff / (60 * 60 * 1000)) / 24;

            SpaceDetailDTO space = new SpaceDetailDTO(parkingDetailID, slotID, timeStart, timeEnd, price, floorID);

            HttpSession session = request.getSession();
            boolean checkValidation = true;
            OrderDAO dao = new OrderDAO();
            List<OrderDetailDTO> listOrder = dao.getOrderDeatailBySlotID(slotID);
            session.setAttribute("LIST_ORDER_BY_SLOTID", listOrder);
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
                cart = new Cart();

            } else {
                // check date nhap vao co trong gio hang hay ko
                for (SpaceDetailDTO _space : cart.getCart().values()) {
                    Date checkManyDate = new Date();
                    checkManyDate = formater.parse(_space.getTimeEnd());
                    String checkManySlot = _space.getSlotID();
                    if (slotID.equals(checkManySlot)) {
                        if (checkTimeStart.compareTo(checkManyDate) != 1 && slotID.equals(checkManySlot)) {
                            orderError.setSlotID("This is exist in the cart");
                            checkValidation = false;
                            break;
                        }
                    }
                }

            }
            // check date nhap vao co trong order hay ko
            for (OrderDetailDTO spaceOrder : listOrder) {
                Date checkOrderDate = new Date();
                checkOrderDate = formater.parse(spaceOrder.getTimeEnd());
                if (checkTimeStart.compareTo(checkOrderDate) != 1) {
                    orderError.setSlotID("This time period has already been booked!");
                    checkValidation = false;
                    break;
                }
            }
            if (timeStart == "") {
                orderError.setTimeStart("Date entered is null!");
                checkValidation = false;
            }
            if (timeEnd == "") {
                orderError.setTimeEnd("Date entered is null!");
                checkValidation = false;
            }
            if (checkTimeStart.compareTo(nowDate) != 1) {
                orderError.setTimeStart("Date entered in the past!");
                checkValidation = false;
            }
            if (checkTimeEnd.compareTo(nowDate) != 1) {
                orderError.setTimeEnd("Date entered in the past!");
                checkValidation = false;
            }
            if (checkValidation) {
                if (diffDays < 28) {
                    orderError.setTimeEnd("Check Out time must be more than 1 month ! ");
                    checkValidation = false;
                }
            }

            if (checkValidation) {
                cart.add(space);
                session.setAttribute("CART", cart);
                url = SUCCESS;
                String message = "Add to cart '" + slotID + "' successfully!!!";
                session.setAttribute("SHOPPING_MESSAGE", message);
            } else {
                request.setAttribute("ORDER_ERROR", orderError);
            }

        } catch (Exception e) {
            log("Error at AddToCartController" + e.toString());
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
