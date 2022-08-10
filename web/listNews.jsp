<%-- 
    Document   : listNews
    Created on : Jun 10, 2022, 3:23:45 PM
    Author     : Admin
--%>

<%@page import="news.NewsDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  List<NewsDTO> listAll = (List<NewsDTO>) session.getAttribute("LIST_ALL_NEWS");
            if (listAll != null) {
                if (!listAll.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID NEW</th>
                    <th>TITLE</th>
                    <th>INFORMATION NEWS</th>                       
                    <th>IMAGE</th>   
                    <th>DATE SUBMITTED</th>   
                    <th>OFFICES EMPLOYEES ID</th>     
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (NewsDTO news : listAll) {
                %>

                <tr>
                    <td><%=count++%></td>
                    <td><%=news.getIdNews()%></td>
                    <td><%=news.getTitle()%></td>      
                    <td><%=news.getInfoNews()%></td>
                    <td><img src="<%=news.getImage()%>" alt="image" width=250 height=250></td>  
                    <td><%=news.getDateSubmited()%></td>
                    <td><%=news.getOfficeEmpID()%></td>

            <form action="MainController" method="POST">
                <td>
                    <input type="hidden" name="id" value="<%=news.getIdNews()%>"/>
                    <input type="hidden" name="name" value="<%=news.getTitle()%>"/>
                    <input type="hidden" name="gender" value="<%=news.getInfoNews()%>"/>
                    <input type="hidden" name="dbo" value="<%=news.getImage()%>"/>
                    <input type="hidden" name="dbo" value="<%=news.getDateSubmited()%>"/>
                    <input type="hidden" name="dbo" value="<%=news.getOfficeEmpID()%>"/>
                    <input type="submit"  name="action" value="editNews"/>
                </td>
            </form>

            <td>
                <form action="MainController">
                    <input type="hidden" name="id" value="<%=news.getIdNews()%>"/>
                    <input type="submit"  name="action" value="deleteNews"/>
                </form>

            </td>
        </tr>

        <%
            }
        %>
        <a href="create.jsp">Create</a>
    </tbody>
</table>   
<%
        }
    }
%> 

</body>
</html>
