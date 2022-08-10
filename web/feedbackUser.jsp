<%-- 
    Document   : feedbackUser.jsp
    Created on : Jun 6, 2022, 9:54:12 PM
    Author     : Admin
--%>

<%@page import="accounts.AccountDTO"%>
<%@page import="feedback.FeedbackDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>FEEDBACK USER!</h1>
        <a href="feedbackADD.jsp">ADD YOUR FEEDBACK</a></br> 
        <%
            AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginUser == null || !loginUser.getRoleID().equals("CUS")) {
                response.sendRedirect("index.jsp");
            }

        %>

        <%  List<FeedbackDTO> list = (List<FeedbackDTO>) session.getAttribute("LIST_FEEDBACK");
            if (list != null) {
                if (!list.isEmpty()) {
        %>



        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>RATE</th>
                    <th>ID CUSTOMER</th>
                    <th>FEEDBACK</th>             
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (FeedbackDTO feedback : list) {
                %>
            <form action="MainController">
                <tr>
                    <td><%=count++%></td>
                    <td><%=feedback.getRate()%></td>
                    <td><%=feedback.getCusID()%></td> 
                    <td><%=feedback.getInfoFeedback()%></td>
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
