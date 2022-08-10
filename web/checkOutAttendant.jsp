<%-- 
    Document   : checkOutAttendant
    Created on : Jul 30, 2022, 10:12:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="MainController" method="POST">
            Vehicle ID <input type="text" name="vehicleID" required=""/>
            <input class="button" type="submit" name="action" value="AddVehicleHistoryOut"/>
            <input class="button" type="reset" value="Reset"/>
        </form>
    </body>
</html>
