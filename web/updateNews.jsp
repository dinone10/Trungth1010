<%-- 
    Document   : updateNews.jsp
    Created on : Jun 7, 2022, 8:54:39 PM
    Author     : Admin
--%>

<%@page import="news.NewsDTO"%>
<%@page import="java.util.List"%>
<%@page import="news.NewsError"%>
<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit NEWS Here!</h1>

        <%
            AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginUser == null || !loginUser.getRoleID().equals("OE")) {
                response.sendRedirect("index.jsp");
            }
            NewsError newsError = (NewsError) request.getAttribute("NEWS_ERROR");
            if (newsError == null) {
                newsError = new NewsError();
            }
            List<NewsDTO> list = (List<NewsDTO>) session.getAttribute("LIST_NEWS");
        %>
        <form action="MainController">

            <label for="UpdateNews">Id News</label>
            <input type="text" class="form-control"  placeholder="Enter ID News" name="idNews" readonly="" value="<%= request.getParameter("idNews")%>">

            <label for="UpdateNews">Title</label>
            <input type="text" class="form-control"  placeholder="Enter Title News" name="idNews" readonly="" value="<%= request.getParameter("title")%>">

            <label for="UpdateNews">Infor News</label>
            <input type="text" class="form-control"  placeholder="Enter Infor News" name="infoNews" readonly="" value="<%= request.getParameter("infoNews")%>">


            <label for="UpdateNews">Parking Attendant ID</label>
            <input type="text" class="form-control"  placeholder="Take A Image" name="image" readonly="" value="<%= request.getParameter("image")%>">


            <label for="UpdateNews">Parking Attendant ID</label>
            <input type="text" class="form-control"  placeholder="Enter Date Submited" name="dateSubmited" readonly="" value="<%= request.getParameter("dateSubmited")%>">


            <label for="UpdateNews">Parking Attendant ID</label>
            <input type="text" class="form-control"  placeholder="Enter ID Em" name="empID" readonly="" value="<%= request.getParameter("empID")%>">

            <input class="button_checkOut" type="submit" name="action" value="ConfirmEditNews">
            </body>
            </html>
