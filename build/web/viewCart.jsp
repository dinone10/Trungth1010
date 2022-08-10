<%-- 
    Document   : viewCart
    Created on : Mar 10, 2022, 1:58:51 AM
    Author     : Admin
--%>

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.products.ProductDTO"%>
<%@page import="sample.products.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h2>Giỏ hàng</h2>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1 class="message">Not have any products!!!</h1>
        <%
        } else {
        %>
        <%
            String message = (String) request.getAttribute("SHOPPING_MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1 class="message"><%=message%></h1></br>
        <div class="content">               
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                        <th>Total</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <%  int count = 1;
                        float total = 0;
                        for (ProductDTO product : cart.getCart().values()) {
                            total += product.getPrice() * product.getQuantity();
                    %>                             
                <form action="MainController">
                    <tr>
                        <td><%=count++%></td>
                        <td><%=product.getProductID()%></td>
                        <td><%=product.getProductName()%></td>
                        <td>                               
                            <input type="number" name="quantity" value="<%=product.getQuantity()%>" required="" min="1"/>
                        </td>
                        <td><%=product.getPrice()%></td>
                        <td><%=product.getPrice() * product.getQuantity()%></td>
                        <td>
                            <input type="hidden" name="productQuantityAvailable" value="<%=product.getQuantityAvaiable()%>"/>
                            <input type="submit" name="action" value="Update"/>
                        </td>
                        <td>
                            <input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
                            <input type="submit" name="action" value="RemoveCart"/>
                        </td>
                    </tr>
                </form>                               
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <h4>Total: <%=total%></h4>
        <div>
            <% 
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            %>
            <form action="MainController">
                <input type="hidden" name="userID" value="<%= loginUser.getUserID()%>"/>
                <input type="hidden" name="total" value="<%=total%>" min="1"/>
                <input class="button" type="submit" name="action" value="Go To Check Out"/>
            </form>               
        </div> 
        <%
            }
        %>
        <div class="shopping">
            <a  href="shopping.jsp">Shopping more</a>
        </div>


    </body>
</html>
