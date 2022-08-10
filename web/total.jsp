<%-- 
    Document   : total
    Created on : Jul 9, 2022, 2:09:25 PM
    Author     : tunvo
--%>

<%@page import="cart.OrderDetailDTO"%>
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
        <h1>Hello World!</h1>
        <%  List<OrderDetailDTO> listAll = (List<OrderDetailDTO>) session.getAttribute("GET_PRICE_ORDER");
            float total = 0;
            if (listAll != null) {
                if (!listAll.isEmpty()) {

                    for (OrderDetailDTO order : listAll) {
                        total += order.getPrice();

                    }
                }
            }
        %>
        <p>
            <%= total%>
        </p>
        <%

        %>
        <form action="MainController">
            <input type="text" name="year" value="" />
            <li>
                <input type="submit" name="action" value="DisplayTurnoverByYear" />
            </li>
        </form>


    </body>
</html>
