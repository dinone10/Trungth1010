/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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

    private static final String ERROR = "error.jsp";
//--------------Login-Controller------------
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGIN_GOOGLE = "loginGG";
    private static final String LOGIN_GOOGLE_CONTROLLER = "LoginGoogleController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String BACK = "Back";
    private static final String BACK_CONTROLLER = "BackController";
    private static final String REGISTER = "Register";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String FORGOT_PASSWORD = "Retrieve";
    private static final String FORGOT_PASSWORD_CONTROLLER = "ForgotPasswordController";
//--------------ParkingAtendant-Controller-----
    private static final String SEARCH_OFFICE_EMPLOYEE = "SearchParkingAttendant";
    private static final String SEARCH_CONTROLLER_OFFICE_EMPLOYEE = "SearchControllerOffEmployee";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String CREATE = "Create";
    private static final String CREATE_CONTROLLER = "CreateController";
    private static final String DISPLAY_PAT = "displayPAT";
    private static final String DISPLAY_PAT_CONTROLLER = "DisplayPATController";
    private static final String GET_INFO_PAT = "getPAT";
    private static final String GET_INFO_PAT_CONTROLLER = "GetInfoPATController";
//------------------OfficeEmployees-Controller------------
    private static final String DISPLAY_OE = "displayOE";
    private static final String DISPLAY_OE_CONTROLLER = "DisplayOEController";
    private static final String DELETE_OE = "DeleteOE";
    private static final String DELETE_CONTROLLER_OE = "DeleteOEController";
    private static final String UPDATE_OE = "UpdateOE";
    private static final String UPDATE_CONTROLLER_OE = "UpdateOEController";
    private static final String CREATE_OE = "CreateOE";
    private static final String CREATE_CONTROLLER_OE = "CreateOEController";
    private static final String GET_INFO_OE = "getOE";
    private static final String GET_INFO_OE_CONTROLLER = "GetInfoOEController";
//------------------Customer-Controller-------------------
    private static final String DISPLAY_CUS = "displayCUS";
    private static final String DISPLAY_CUS_CONTROLLER = "DisplayCUSController";
    private static final String CREATE_CUS = "createCUS";
    private static final String CREATE_CUS_CONTROLLER = "CreateCUSController";
    private static final String DELETE_CUS = "deleteCUS";
    private static final String DELETE_CUS_CONTROLLER = "DeleteCUSController";
    private static final String UPDATE_CUS = "updateCUS";
    private static final String UPDATE_CUS_CONTROLLER = "UpdateCustomerController";
    private static final String GET_INFO_CUS = "getCUS";
    private static final String GET_INFO_CUS_CONTROLLER = "GetInfoCustomerController";
    private static final String DISPLAY_USERPROFILE = "displayUserProfile";
    private static final String DISPLAY_USERPROFILE_CONTROLLER = "DisplayUserProfileController";
    private static final String ADD_INFO_CUS = "addInfoCus";
    private static final String ADD_INFO_CUS_CONTROLLER = "AddInfoCusController";
    private static final String GET_INFO_ADD_CUS = "getInfoAddCus";
    private static final String GET_INFO_ADD_CUS_CONTROLLER = "GetInfoAddCusController";
//------------------Feedback-Controller-------------------
    private static final String VIEW_FEEDBACK = "ViewFeedback";
    private static final String VIEW_FEEDBACK_CONTROLLER = "ViewFeedbackController";
    private static final String REMOVE_FEEDBACK = "Remove Feedback";
    private static final String REMOVE_FEEDBACK_CONTROLLER = "RemoveFeedbackController";
    private static final String ADD_FEEDBACK = "AddFeedback1";
    private static final String ADD_FEEDBACK_CONTROLLER = "AddFeedbacksController";
//------------------Account-Controller---------------------
    private static final String DISPLAY_ACCOUNT = "displayAccount";
    private static final String DISPLAY_ACCOUNT_CONTROLLER = "DisplayAccountController";
    private static final String CREATE_ACCOUNT = "createAccount";
    private static final String CREATE_ACCOUNT_CONTROLLER = "CreateAccountController";
    private static final String DELETE_ACCOUNT = "deleteAccount";
    private static final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController";
    private static final String GET_INFO_ACCOUNT = "getAccount";
    private static final String GET_INFO_ACCOUNT_CONTROLLER = "GetInfoAccountController";
    private static final String UPDATE_ACCOUNT = "updateAcc";
    private static final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController";
    //------------------Send-Email-Controller---------------------------
    private static final String SEND_EMAIL = "sendEmail";
    private static final String SEND_EMAIL_CONTROLLER = "SendEmailController";
    //------------------News-Controller---------------------------
    private static final String DISPLAY_NEWS = "displayNews";
    private static final String DISPLAY_NEWS_CONTROLLER = "DisplayNewsController";
    private static final String ADD_NEWS = "AddNews";
    private static final String ADD_NEWS_CONTROLLER = "AddNewsController";
    private static final String VIEW_NEWS = "ViewNews";
    private static final String VIEW_NEWS_CONTROLLER = "ViewNewsController";
    private static final String REMOVE_NEWS = "Remove News";
    private static final String REMOVE_NEWS_CONTROLLER = "RemoveNewsController";
    private static final String UPDATE_NEWS = "Update News";
    private static final String UPDATE_NEWS_CONTROLLER = "UpdateNewsController";
    private static final String SEARCH_NEWS = "Search News";
    private static final String SEARCH_NEWS_CONTROLLER = "SearchNewsController";
    private static final String GET_INFO_NEWS = "getNews";
    private static final String GET_INFO_NEWS_CONTROLLER = "GetNewsController";
    //-----------------Space-Controller---------------------------
    private static final String DISPLAY_SPACE = "displaySpace";
    private static final String DISPLAY_SPACE_CONTROLLER = "DisplaySpaceController";
    private static final String UPDATE_SPACE = "updateSpace";
    private static final String UPDATE_SPACE_CONTROLLER = "UpdateSpaceController";
    private static final String GET_INFO_SPACE = "getSpace";
    private static final String GET_INFO_SPACE_CONTROLLER = "GetInfoSpace";
    private static final String DISPLAY_SPACE_DETAIL = "displaySpaceDetail";
    private static final String DISPLAY_SPACE_DETAIL_CONTROLLER = "DisplaySpaceDetailController";
    private static final String DELETE_STATUS = "deleteStatus";
    private static final String DELETE_STATUS_CONTROLLER = "DeleteStatusSpaceController";
    private static final String ADD_VEHICLE_TO_SLOT = "addVehicleToSlot";
    private static final String ADD_VEHICLE_TO_SLOT_CONTROLLER = "AddVehicleToSlotController";
    private static final String GET_INFO_ADD_VEHICLE_TO_SLOT = "getInfoAddToSlot";
    private static final String GET_INFO_ADD_VEHICLE_TO_SLOT_CONTROLLER = "GetInfoAddSlot";
    private static final String DISPLAY_SPACE_A1 = "displaySpaceA1";
    private static final String DISPLAY_SPACE_A1_CONTROLLER = "DisplaySpaceA1Controller";
    private static final String DISPLAY_SPACE_A2 = "displaySpaceA2";
    private static final String DISPLAY_SPACE_A2_CONTROLLER = "DisplaySpaceA2Controller";
    private static final String DISPLAY_SPACE_B1 = "displaySpaceB1";
    private static final String DISPLAY_SPACE_B1_CONTROLLER = "DisplaySpaceB1Controller";
    private static final String DISPLAY_SPACE_B2 = "displaySpaceB2";
    private static final String DISPLAY_SPACE_B2_CONTROLLER = "DisplaySpaceB2Controller";
    private static final String CLEAR_CAR = "clearCar";
    private static final String CLEAR_CAR_CONTROLLER = "clearCarController";
    private static final String UPDATE_PRICE = "updatePriceSlot";
    private static final String UPDATE_PRICE_CONTROLLER = "EditPriceController";
    //----------------Booking-------------------------------------------
    private static final String ADD_TO_CARD = "addToCart";
    private static final String ADD_TO_CARD_CONTROLLER = "AddSlotToCartController";
    private static final String DISPLAY_BOOKING = "displayBooking";
    private static final String DISPLAY_BOOKING_CONTROLLER = "DisplaySpaceParking_CustomerController";
    private static final String REMOVE_CART = "RemoveCart";
    private static final String REMOVE_CART_CONTROLLER = "RemoveSlotCartController";
    private static final String CHECK_OUT = "CheckOut";
    private static final String CHECK_OUT_CONTROLLER = "CheckOutController";
    private static final String VIEW_CART = "ViewCart";
    private static final String VIEW_CART_CONTROLLER = "ViewCartController";
    private static final String DISPLAY_ORDER = "displayOrder";
    private static final String DISPLAY_ORDER_CONTROLLER = "DisplayOrderController";
    private static final String DISPLAY_ORDER_DETAIL_BY_ID = "displayOrderDetail";
    private static final String DISPLAY_ORDER_DETAIL_BY_ID_CONTROLLER = "DisplayOrderDetailController";
    private static final String SUCCESS_ORDER = "submitOrder";
    private static final String SUCCESS_ORDER_CONTROLLER = "SuccessOrderController";
    private static final String BACK_BOOKING = "backToBook";
    private static final String BACK_BOOKING_CONTROLLER = "BackBookingController";
    private static final String DISPLAY_SPACE_BOOKING = "listSpace";
    private static final String DISPLAY_SPACE_BOOKING_CONTROLLER = "DisplaySpaceBookingController";
    private static final String INFO_BOOKING = "bookNow";
    private static final String INFO_BOOKING_CONTROLLER = "InfoAboutBookingController";
    private static final String A1_BOOKING = "listSpaceA1";
    private static final String A1_BOOKING_CONTROLLER = "BookingA1Controller";
    private static final String A2_BOOKING = "listSpaceA2";
    private static final String A2_BOOKING_CONTROLLER = "BookingA2Controller";
    private static final String B1_BOOKING = "listSpaceB1";
    private static final String B1_BOOKING_CONTROLLER = "BookingB1Controller";
    private static final String B2_BOOKING = "listSpaceB2";
    private static final String B2_BOOKING_CONTROLLER = "BookingB2Controller";
    private static final String DISPLAY_MY_ORDER = "displayMyOrder";
    private static final String DISPLAY_MY_ORDER_CONTROLLER = "DisplayMyOrderController";
    private static final String DISPLAY_MY_ORDER_DETAIL = "displayMyOrderDetail";
    private static final String DISPLAY_MY_ORDER_DETAIL_CONTROLLER = "DisplayMyOrderDetailController";
    //----------------------Home-----------------------------------------
    private static final String VIEW_INFO_CUS = "ViewInfoCus";
    private static final String VIEW_INFO_CUS_CONTROLLER = "GetInfoCusController";
    private static final String GET_HOME = "getHome";
    private static final String GET_HOME_CONTROLLER = "GetHomeController";
    //---------------------History-----------------------------------------
    private static final String ADD_VEHICLE_HISTORY = "AddVehicleHistory";
    private static final String ADD_VEHICLE_HISTORY_CONTROLLER = "AddVehicleHistoryController";
    private static final String ADD_VEHICLE_HISTORY_CHECK_OUT = "AddVehicleHistoryOut";
    private static final String ADD_VEHICLE_HISTORY_CHECK_OUT_CONTROLLER = "AddVehicleHistoryOutController";
    private static final String DISPLAY_VEHICLE_HISTORY = "DisplayVehicleHistory";
    private static final String DISPLAY_VEHICLE_HISTORY_CONTROLLER = "DisplayVehicleHistoryController";
    private static final String REMOVE_VEHICLE_HISTORY = "removeHis";
    private static final String REMOVE_VEHICLE_HISTORY_CONTROLLER = "RemoveVehicleHistoryController";
    //----------------------Turnover-----------------------------------------
    private static final String DISPLAY_TURNOVER = "DisplayTurnover";
    private static final String DISPLAY_TURNOVER_CONTROLLER = "DisplayTurnoverController";
    private static final String DISPLAY_TURNOVER_YEAR = "DisplayTurnoverByYear";
    private static final String DISPLAY_TURNOVER_YEAR_CONTROLLER = "DisplayTurnoverByYearController";
    //------------------------Long-Term-Card----------------------------------
    private static final String CREATE_CARD = "createCard";
    private static final String CREATE_CARD_CONTROLLER = "CreateCardController";
    private static final String GET_INFO_CREATE = "getCreateCard";
    private static final String GET_INFO_CREATE_CONTROLLER = "GetInfoCardController";
    private static final String DISPLAY_CARD = "displayCard";
    private static final String DISPLAY_CARD_CONTROLLER = "DisplayCardController";
    private static final String SUCCESS_CARD = "SuccessStatus";
    private static final String SUCCESS_CARD_CONTROLLER = "SubmitCardcontroller";
    private static final String GET_EXTEND = "getExtend";
    private static final String GET_EXTEND_CONTROLLER = "GetExtendCardController";
    private static final String EXTEND_CARD = "extendCard";
    private static final String EXTEND_CARD_CONTROLLER = "ExtendCardController";
    private static final String DISPLAY_MY_CARD = "DisplayMyCard";
    private static final String DISPLAY_MY_CARD_CONTROLLER = "DisplayMyCardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            //-------Login-Controller-----------
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (REGISTER.equals(action)) {
                url = REGISTER_CONTROLLER;
            } else if (FORGOT_PASSWORD.equals(action)) {
                url = FORGOT_PASSWORD_CONTROLLER;
            } else if (BACK.equals(action)) {
                url = BACK_CONTROLLER;
            } else if (LOGIN_GOOGLE.equals(action)) {
                url = LOGIN_GOOGLE_CONTROLLER;
            } //------ParkingAtendant-Controller-----
            else if (SEARCH_OFFICE_EMPLOYEE.equals(action)) {
                url = SEARCH_CONTROLLER_OFFICE_EMPLOYEE;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (DISPLAY_PAT.equals(action)) {
                url = DISPLAY_PAT_CONTROLLER;
            } else if (GET_INFO_PAT.equals(action)) {
                url = GET_INFO_PAT_CONTROLLER;
            }//--------OfficeEmployees-Controller-----
            else if (DISPLAY_OE.equals(action)) {
                url = DISPLAY_OE_CONTROLLER;
            } else if (DELETE_OE.equals(action)) {
                url = DELETE_CONTROLLER_OE;
            } else if (UPDATE_OE.equals(action)) {
                url = UPDATE_CONTROLLER_OE;
            } else if (CREATE_OE.equals(action)) {
                url = CREATE_CONTROLLER_OE;
            } else if (GET_INFO_OE.equals(action)) {
                url = GET_INFO_OE_CONTROLLER;
            }//-------Feedback-Controller-----------
            else if (VIEW_FEEDBACK.equals(action)) {
                url = VIEW_FEEDBACK_CONTROLLER;
            } else if (REMOVE_FEEDBACK.equals(action)) {
                url = REMOVE_FEEDBACK_CONTROLLER;
            } else if (ADD_FEEDBACK.equals(action)) {
                url = ADD_FEEDBACK_CONTROLLER;
            } //-----------Customer-Controller-------
            else if (DISPLAY_CUS.equals(action)) {
                url = DISPLAY_CUS_CONTROLLER;
            } else if (CREATE_CUS.equals(action)) {
                url = CREATE_CUS_CONTROLLER;
            } else if (DELETE_CUS.equals(action)) {
                url = DELETE_CUS_CONTROLLER;
            } else if (UPDATE_CUS.equals(action)) {
                url = UPDATE_CUS_CONTROLLER;
            } else if (GET_INFO_CUS.equals(action)) {
                url = GET_INFO_CUS_CONTROLLER;
            } else if (DISPLAY_USERPROFILE.equals(action)) {
                url = DISPLAY_USERPROFILE_CONTROLLER;
            } else if (ADD_INFO_CUS.equals(action)) {
                url = ADD_INFO_CUS_CONTROLLER;
            } else if (GET_INFO_ADD_CUS.equals(action)) {
                url = GET_INFO_ADD_CUS_CONTROLLER;
            } //----------Account-Controller---------
            else if (DISPLAY_ACCOUNT.equals(action)) {
                url = DISPLAY_ACCOUNT_CONTROLLER;
            } else if (CREATE_ACCOUNT.equals(action)) {
                url = CREATE_ACCOUNT_CONTROLLER;
            } else if (DELETE_ACCOUNT.equals(action)) {
                url = DELETE_ACCOUNT_CONTROLLER;
            } else if (GET_INFO_ACCOUNT.equals(action)) {
                url = GET_INFO_ACCOUNT_CONTROLLER;
            } else if (UPDATE_ACCOUNT.equals(action)) {
                url = UPDATE_ACCOUNT_CONTROLLER;
            }//--------Send-Email-Controller----------------
            else if (SEND_EMAIL.equals(action)) {
                url = SEND_EMAIL_CONTROLLER;
            }//--------News-Controller----------------
            else if (DISPLAY_NEWS.equals(action)) {
                url = DISPLAY_NEWS_CONTROLLER;
            } else if (ADD_NEWS.equals(action)) {
                url = ADD_NEWS_CONTROLLER;
            } else if (VIEW_NEWS.equals(action)) {
                url = VIEW_NEWS_CONTROLLER;
            } else if (REMOVE_NEWS.equals(action)) {
                url = REMOVE_NEWS_CONTROLLER;
            } else if (UPDATE_NEWS.equals(action)) {
                url = UPDATE_NEWS_CONTROLLER;
            } else if (SEARCH_NEWS.equals(action)) {
                url = SEARCH_NEWS_CONTROLLER;
            } else if (GET_INFO_NEWS.equals(action)) {
                url = GET_INFO_NEWS_CONTROLLER;
            }//--------Space-Controller----------------
            else if (DISPLAY_SPACE.equals(action)) {
                url = DISPLAY_SPACE_CONTROLLER;
            } else if (UPDATE_SPACE.equals(action)) {
                url = UPDATE_SPACE_CONTROLLER;
            } else if (GET_INFO_SPACE.equals(action)) {
                url = GET_INFO_SPACE_CONTROLLER;
            } else if (DISPLAY_SPACE_DETAIL.equals(action)) {
                url = DISPLAY_SPACE_DETAIL_CONTROLLER;
            } else if (DELETE_STATUS.equals(action)) {
                url = DELETE_STATUS_CONTROLLER;
            } else if (ADD_VEHICLE_TO_SLOT.equals(action)) {
                url = ADD_VEHICLE_TO_SLOT_CONTROLLER;
            } else if (GET_INFO_ADD_VEHICLE_TO_SLOT.equals(action)) {
                url = GET_INFO_ADD_VEHICLE_TO_SLOT_CONTROLLER;
            } else if (DISPLAY_SPACE_A1.equals(action)) {
                url = DISPLAY_SPACE_A1_CONTROLLER;
            } else if (DISPLAY_SPACE_A2.equals(action)) {
                url = DISPLAY_SPACE_A2_CONTROLLER;
            } else if (DISPLAY_SPACE_B1.equals(action)) {
                url = DISPLAY_SPACE_B1_CONTROLLER;
            } else if (DISPLAY_SPACE_B2.equals(action)) {
                url = DISPLAY_SPACE_B2_CONTROLLER;
            } else if (CLEAR_CAR.equals(action)) {
                url = CLEAR_CAR_CONTROLLER;
            } else if (UPDATE_PRICE.equals(action)) {
                url = UPDATE_PRICE_CONTROLLER;
            }//-----------------Booking-----------------------
            else if (ADD_TO_CARD.equals(action)) {
                url = ADD_TO_CARD_CONTROLLER;
            } else if (DISPLAY_BOOKING.equals(action)) {
                url = DISPLAY_BOOKING_CONTROLLER;
            } else if (REMOVE_CART.equals(action)) {
                url = REMOVE_CART_CONTROLLER;
            } else if (CHECK_OUT.equals(action)) {
                url = CHECK_OUT_CONTROLLER;
            } else if (VIEW_CART.equals(action)) {
                url = VIEW_CART_CONTROLLER;
            } else if (DISPLAY_ORDER.equals(action)) {
                url = DISPLAY_ORDER_CONTROLLER;
            } else if (DISPLAY_ORDER_DETAIL_BY_ID.equals(action)) {
                url = DISPLAY_ORDER_DETAIL_BY_ID_CONTROLLER;
            } else if (SUCCESS_ORDER.equals(action)) {
                url = SUCCESS_ORDER_CONTROLLER;
            } else if (DISPLAY_SPACE_BOOKING.equals(action)) {
                url = DISPLAY_SPACE_BOOKING_CONTROLLER;
            } else if (INFO_BOOKING.equals(action)) {
                url = INFO_BOOKING_CONTROLLER;
            } else if (A1_BOOKING.equals(action)) {
                url = A1_BOOKING_CONTROLLER;
            } else if (A2_BOOKING.equals(action)) {
                url = A2_BOOKING_CONTROLLER;
            } else if (B1_BOOKING.equals(action)) {
                url = B1_BOOKING_CONTROLLER;
            } else if (B2_BOOKING.equals(action)) {
                url = B2_BOOKING_CONTROLLER;
            } else if (BACK_BOOKING.equals(action)) {
                url = BACK_BOOKING_CONTROLLER;
            } else if (DISPLAY_MY_ORDER.equals(action)) {
                url = DISPLAY_MY_ORDER_CONTROLLER;
            } else if (DISPLAY_MY_ORDER_DETAIL.equals(action)) {
                url = DISPLAY_MY_ORDER_DETAIL_CONTROLLER;
            }//------------------Home----------------
            else if (VIEW_INFO_CUS.equals(action)) {
                url = VIEW_INFO_CUS_CONTROLLER;
            } else if (GET_HOME.equals(action)) {
                url = GET_HOME_CONTROLLER;
            }//-------------------History----------
            else if (ADD_VEHICLE_HISTORY.equals(action)) {
                url = ADD_VEHICLE_HISTORY_CONTROLLER;
            } else if (ADD_VEHICLE_HISTORY_CHECK_OUT.equals(action)) {
                url = ADD_VEHICLE_HISTORY_CHECK_OUT_CONTROLLER;
            } else if (DISPLAY_VEHICLE_HISTORY.equals(action)) {
                url = DISPLAY_VEHICLE_HISTORY_CONTROLLER;
            } else if (REMOVE_VEHICLE_HISTORY.equals(action)) {
                url = REMOVE_VEHICLE_HISTORY_CONTROLLER;
            }//-----------------Turnover------------
            else if (DISPLAY_TURNOVER.equals(action)) {
                url = DISPLAY_TURNOVER_CONTROLLER;
            } else if (DISPLAY_TURNOVER_YEAR.equals(action)) {
                url = DISPLAY_TURNOVER_YEAR_CONTROLLER;
            }//-----------------Card-----------------
            else if (CREATE_CARD.equals(action)) {
                url = CREATE_CARD_CONTROLLER;
            } else if (GET_INFO_CREATE.equals(action)) {
                url = GET_INFO_CREATE_CONTROLLER;
            } else if (DISPLAY_CARD.equals(action)) {
                url = DISPLAY_CARD_CONTROLLER;
            } else if (SUCCESS_CARD.equals(action)) {
                url = SUCCESS_CARD_CONTROLLER;
            } else if (GET_EXTEND.equals(action)) {
                url = GET_EXTEND_CONTROLLER;
            } else if (EXTEND_CARD.equals(action)) {
                url = EXTEND_CARD_CONTROLLER;
            } else if (DISPLAY_MY_CARD.equals(action)) {
                url = DISPLAY_MY_CARD_CONTROLLER;
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
