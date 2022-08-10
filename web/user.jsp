<%-- 
    Document   : user
    Created on : Mar 7, 2022, 9:49:39 PM
    Author     : Admin
--%>

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.products.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>

        <p>Welcome User: <%=((UserDTO) session.getAttribute("LOGIN_USER")).getFullName()%> !!!</p>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                response.sendRedirect("login.jsp");
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController" >
            Search<input type="text" name="search"  value="<%= search%>" placeholder="input your text"/>
            <input type="submit" name="action"  value="search"/>
        </form>
        <a href="MainController?action=role">Happy shopping</a></br>
        <%
            List<ProductDTO> listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>    
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>CategoryID</th>
                    <th>ImportDate</th>
                    <th>UsingDate</th>
                    <th>Status</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO product : listProduct) {
                %>

                <tr>
                    <td><%= count++%></td>
                    <td>
                        <%= product.getProductID()%> 
                    </td>
                    <td>
                        <%= product.getProductName()%>
                    </td>
                    <td><img src="<%=product.getImage()%>" alt="Image" width=250 height=250></td>
                    <td>
                        <%= product.getPrice()%>
                    </td>
                    <td>
                        <%= product.getQuantity()%>
                    </td>
                    <td>
                        <%= product.getCatagoryID()%>
                    </td>
                    <td>
                        <%= product.getImportDate()%>
                    <td>
                        <%= product.getUsingDate()%> 
                    </td>
                    <td>
                        <%= product.getStatus()%>
                    </td>                  
                    <%
                        }
                    %>
                </tr>



            </tbody>
        </table>
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <%=error%>


        <%
                }
            }
        %>        
    </body>
</html>
