<%-- 
    Document   : createProduct
    Created on : Mar 12, 2022, 11:13:45 AM
    Author     : Admin
--%>

<%@page import="sample.products.ProductError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>
    </head>
    <body>
         <%
            ProductError productError = (ProductError) request.getAttribute("PRODUCT_ERROR");
            if(productError == null){
                productError = new ProductError();
            }
        %>
        <form action="MainController" method="POST">
            Product ID<input type="text" name="productID" required=""/>
            Product Name<input type="text" name="productName" required=""/>
            Image<input type="text" name="image" required=""/>
             Price<input type="text" name="price" required=""/>
            Quantity<input type="text" name="quantity" required=""/>
            CategoryID<input type="text" name="categoryID" required=""/>         
            ImportDate<input type="text" name="importDate" required=""/>
            UsingDate<input type="text" name="usingDate" required=""/>
            Status<input type="text" name="status" required=""/>
            <input type="submit" name="action" value="Add" /></br>
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
