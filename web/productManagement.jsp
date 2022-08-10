<%-- 
    Document   : productManagement
    Created on : Mar 11, 2022, 7:33:24 AM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="sample.products.ProductDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Page</title>
    </head>
    <body>
        <h2>LIST VAGETABLE</h2>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
            }

        %>

        <%    String message = (String) request.getAttribute("SHOPPING_MESSAGE");
            if (message
                    == null) {
                message = "";
            }
        %>
        <h1 class="message"><%=message%></h1></br>

        <a href=createProduct.jsp>Add Product</a>
        <a href="MainController?action=Logout">Logout</a>
        <div class="content">
            <%  List<ProductDTO> listAll = (List<ProductDTO>) session.getAttribute("LIST_ALL_PRODUCT");
                if (listAll != null) {
                    if (!listAll.isEmpty()) {
            %>

            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ProductID</th>
                        <th>ProductName</th>
                        <th>Image</th>                       
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
                        for (ProductDTO product : listAll) {
                    %>
                <form action="MainController">
                    <tr>
                        <td><%=count++%></td>
                        <td><%=product.getProductID()%></td>
                        <td><%=product.getProductName()%></td>
                        <td><img src="<%=product.getImage()%>" alt="Image" width=250 height=250></td>                  
                        <td><%=product.getPrice()%></td>
                        <td><%=product.getQuantity()%></td>
                        <td><%=product.getCatagoryID()%></td>
                        <td><%=product.getImportDate()%></td>
                        <td><%=product.getUsingDate()%></td>
                        <td><%=product.getStatus()%></td>


                        <td>
                            <input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
                            <input type="hidden" name="productName" value="<%=product.getProductName()%>"/>
                            <input type="hidden" name="image" value="<%=product.getImage()%>"/>
                            <input type="hidden" name="quantityAvailable" value="<%=product.getQuantity()%>"/>
                            <input type="hidden" name="price" value="<%=product.getPrice()%>"/>
                            <input type="hidden" name="categoryID" value="<%=product.getCatagoryID()%>"/>
                            <input type="hidden" name="importDate" value="<%=product.getImportDate()%>"/>
                            <input type="hidden" name="usingDate" value="<%=product.getUsingDate()%>"/>
                            <input type="hidden" name="status" value="<%=product.getStatus()%>"/>
                            <input type="submit"  name="action" value="Edit"/>
                        </td>
                        <td>
                            <form action="MainController">
                                <input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
                                <input type="submit"  name="action" value="Delete"/>
                            </form>

                        </td>
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
        </div>
    </body>
</html>
