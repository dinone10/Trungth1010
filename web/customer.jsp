<%-- 
    Document   : customer
    Created on : May 30, 2022, 3:17:04 PM
    Author     : Admin
--%>

<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <%
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginAccount == null || !loginAccount.getRoleID().equals("CUS")) {
                response.sendRedirect("index.jsp");
            }

            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        Welcome User: <h1><%= loginAccount.getUserName()%></h1>

        <form action="MainController" >
            Search<input type="text" name="Search"  value="<%= search%>" placeholder="input your text"/>
            <input type="submit" name="action"  value="Search"/>
        </form>
    
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1><%= message%></h1>
    </form>
</body>
</html>
