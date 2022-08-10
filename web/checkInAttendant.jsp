<%-- 
    Document   : checkInAttendant
    Created on : Jul 31, 2022, 3:59:11 AM
    Author     : Admin
--%>

<%@page import="vehicleHistory.VehicleHistoryError"%>
<%@page import="vehicleHistory.VehicleHistoryError"%>
<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TRANG CHECK-IN!</h1>
        <%
            AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginUser == null || !loginUser.getRoleID().equals("PAT")) {
                response.sendRedirect("index.jsp");
            }

        %>

        <%            VehicleHistoryError VehicleHistoryError = (VehicleHistoryError) request.getAttribute("VEHICLE_HISTORY_ERROR");
            if (VehicleHistoryError == null) {
                VehicleHistoryError = new VehicleHistoryError();
            }
        %>
        <form action="MainController" method="POST">
            Vehicle ID <input type="text" name="vehicleID" required=""/>
            <%= VehicleHistoryError.getVehicleIDError()%><br>
            <!--            Employee ID <input type="text" name="empID" required=""/>
            <%= loginUser.getIdAccount()%><br>-->
            Employee ID <input type="text" name="empID" required=""/>
            <%= VehicleHistoryError.getEmpIDError()%><br>
            <input class="button" type="submit" name="action" value="AddVehicleHistory"/>
            <input class="button" type="reset" value="Reset"/>
            <%= VehicleHistoryError.getMessageError()%>
        </form>
    </body>
</html>
