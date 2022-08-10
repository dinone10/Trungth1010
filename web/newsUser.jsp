<%-- 
    Document   : newsUser.jsp
    Created on : Jun 7, 2022, 8:23:13 PM
    Author     : Admin
--%>

<%@page import="news.NewsDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>NEWS USER!</h1>
        <a href="feedbackADD.jsp">ADD YOUR FEEDBACK</a></br> 
        <%
            AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginUser == null || !loginUser.getRoleID().equals("CUS")) {
                response.sendRedirect("index.jsp");
            }

        %>

        <%  List<NewsDTO> list = (List<NewsDTO>) session.getAttribute("LIST_NEWS");
            if (list != null) {
                if (!list.isEmpty()) {
        %>



        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID NEWS</th>
                    <th>TITLE NEWS</th>
                    <th>INFO NEWS</th>
                    <th>IMAGE</th>
                    <th>DATE SUBMITTED</th>
                    <th>ID EMPLOYEE</th>           
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (NewsDTO news : list) {
                %>
            <form action="MainController">
                <tr>
                    <td><%=count++%></td>
                    <td><%=news.getIdNews()%></td>
                    <td><%=news.getTitle()%></td>
                    <td><%=news.getInfoNews()%></td>
                    <td><%=news.getImage()%></td>
                    <td><%=news.getDateSubmited()%></td> 
                    <td><%=news.getOfficeEmpID()%></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>   
    <%
            }
        }
    %> 

    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>
    <%=error%>
    </body>
</html>
