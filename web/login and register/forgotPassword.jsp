<%-- 
    Document   : forgotPassword
    Created on : Jun 1, 2022, 12:16:08 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <b>Forgot Password</b></br>
            UserName :<input type="text" name="userName" required="" /></br>
            Email :<input type="text" name="email" required="" /></br>
            <input type="submit" name="action" value="Retrieve">
            <a href="login.jsp">Sign in</a>
        </form>
        <%
            String error = (String) session.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <%= error%>

    </body>
</html>
