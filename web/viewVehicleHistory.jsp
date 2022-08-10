<%-- 
    Document   : viewVehicleHistory
    Created on : Jul 30, 2022, 11:17:58 PM
    Author     : Admin
--%>

<%@page import="vehicleHistory.VehicleHistoryDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  List<VehicleHistoryDTO> listAll = (List<VehicleHistoryDTO>) session.getAttribute("LIST_VEHICLE_HISTORY");
            if (listAll != null) {
                if (!listAll.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Vehicle ID</th>
                    <th>Employee ID</th>
                    <th>Time Check In</th>
                    <th>Time Check Out</th>                       
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (VehicleHistoryDTO vehicleHistory : listAll) {
                %>

                <tr>
                    <td><%=count++%></td>
                    <td><%=vehicleHistory.getVehicleID()%></td>
                    <td><%=vehicleHistory.getEmpID()%></td>      
                    <td><%=vehicleHistory.getTimeCheckIn()%></td>                  
                    <td><%=vehicleHistory.getTimeCheckOut()%></td>
                </tr>

        <%
            }
        %>
 
<%
        }
    }
%> 
    </body>
</html>
