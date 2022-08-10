<%-- 
    Document   : register
    Created on : May 31, 2022, 8:01:01 AM
    Author     : Admin
--%>

<%@page import="accounts.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <%
            AccountError accountError = (AccountError) request.getAttribute("ACCOUNT_ERROR");
            if (accountError == null) {
                accountError = new AccountError();
            }
        %>
        <form action="MainController" method="post">
            <h2>Register</h2>
            Account ID: <input type="text" name="idAccount" required="">
            <%= accountError.getIdAccountError()%></br>
            UserName: <input type="text" name="userName" required="">
            <%= accountError.getUserNameError()%></br>           
            Password: <input type="password" name="password"  required="">
            <%= accountError.getPasswordError()%></br>
            Confirm Password: <input type="password" name="confirm"  required="">
            <%= accountError.getConfirmError()%></br>
            Role ID: <input type="text" name="roleID" value="CUS"  readonly=""></br>
            Email: <input type="text" name="email" required="">
            <%= accountError.getEmailError()%></br>           
            <p></p>
            <button type="submit" name="action" value="Register">Register Now</button>
        </form>
        Already have an account? <a href="login.jsp">Sign in</a>
    </body>
</html>
